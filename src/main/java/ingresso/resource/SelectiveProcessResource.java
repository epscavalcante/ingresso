package ingresso.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ingresso.model.SelectiveProcess;

@RestController
@RequestMapping("/selective-processes")
public class SelectiveProcessResource extends ApiResource<SelectiveProcess, Integer> {

}
