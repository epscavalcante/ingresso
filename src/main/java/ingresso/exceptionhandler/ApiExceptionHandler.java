package ingresso.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;

import ingresso.exception.AppException;
import ingresso.exception.ResourceNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Problem.Field> fields = ex.getBindingResult().getAllErrors().stream().map(objectError -> {
			String message = objectError.getDefaultMessage();
			String name = objectError.getObjectName();
			if (objectError instanceof FieldError) {
				name = ((FieldError) objectError).getField();
			}
			return new Problem.Field(name, message);
		}).collect(Collectors.toList());
		String message = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";
		Problem body = new Problem(message, status.value(), OffsetDateTime.now(), fields);
		return handleExceptionInternal(ex, body, headers, status, request);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Throwable rootCause = ExceptionUtils.getRootCause(ex);

		if (rootCause instanceof InvalidFormatException) {
			//
		} else if (rootCause instanceof PropertyBindingException) {
			//
		}

		String message = "O corpo da requisição está inválido. Verifique erro de sintaxe.";
		List<Problem.Field> fields = null;
		Problem body = new Problem(message, status.value(), OffsetDateTime.now(), fields);
		return handleExceptionInternal(ex, body, headers, status, request);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	private ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		Problem body = new Problem(ex.getMessage(), status.value(), OffsetDateTime.now(), null);
		return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(AppException.class)
	private ResponseEntity<?> handleAppException(AppException ex, WebRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		Problem body = new Problem(ex.getMessage(), status.value(), OffsetDateTime.now(), null);
		return handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
	}
}
