package coms309;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ExceptionController {

    @RequestMapping(method = RequestMethod.GET, path = "/oopsiepoopsie")
    public String triggerException() {
        throw new RuntimeException("Oh no! There seems to be an error :(");
    }

}
