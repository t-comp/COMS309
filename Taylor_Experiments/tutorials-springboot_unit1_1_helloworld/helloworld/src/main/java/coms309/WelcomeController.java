package coms309;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "Hello! Welcome from Taylor :D";
    }

    @GetMapping("/{name}")
    public String welcome(@PathVariable String name) {
        return "Hello, " + name + "! Welcome from Taylor :D";
    }
}
