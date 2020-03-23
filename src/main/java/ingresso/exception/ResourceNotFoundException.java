package ingresso.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Integer id) {
		super(String.format("Recurso %d não encontrado!", id));
	}

}
