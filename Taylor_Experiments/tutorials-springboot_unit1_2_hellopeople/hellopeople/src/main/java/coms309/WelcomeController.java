package coms309;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple Hello World Controller to display the string returned
 *
 */

@RestController
class WelcomeController {

    @GetMapping("/greeting-page")
    public String welcome() {
        return "Duality - Connecting Mind & Body";
    }

    @GetMapping("/greeting-page/{name}")
    public String welcomeUser(@PathVariable String name) {
        return "Hey there, " + name + ", welcome to Duality!";
    }
}
