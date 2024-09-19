package coms309.people;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.HashMap;

/**
 * Controller used to showcase Create and Read from a LIST
 *
 * @author Vivek Bengre
 */

@RestController
public class PeopleController {
    // variable for guest user
    private Person guestUser;

    // stores Person and AverageUser by ID
    HashMap<Integer, Person> peopleList = new HashMap<>();

    // creates a guest user which will not be saved
    @PostMapping("/guest")
    public Person createGuest(@RequestBody Person p) {
        guestUser = p;
        return guestUser;
    }

    // reads current guest
    @GetMapping("/guest")
    public Person getGuest() {
        if (guestUser == null) {
            throw new IllegalStateException("There is no guest user!");
        }
        return guestUser;
    }

    // create AverageUser and saved it to peopleList
    // springboot automatically converts JSON input into a person object and the method below enters it into the list.
    // It returns a string message in THIS example.
    // in this case because of @ResponseBody
    // Note: To CREATE we use POST method
    @PostMapping("/averageUser")
    public String createAverageUser(@RequestBody AverageUser averageUser) {
        peopleList.put(averageUser.getUserID(), averageUser);
        return "Average user " + averageUser.getFirstName() + " has successfully been created and saved. UserID: " + averageUser.getUserID();
    }

    // returns AverageUser by userID
    // Springboot gets the PATHVARIABLE from the URL
    // We extract the AverageUser from the HashMap.
    // springboot automatically converts Person to JSON format when we return it
    // in this case because of @ResponseBody
    // Note: To READ we use GET method
    @GetMapping("/averageUser/{userID}")
    public AverageUser getAverageUser(@PathVariable int userID) {
        return (AverageUser) peopleList.get(userID);

    }

    // updates an average user
    // We extract the person from the HashMap and modify it.
    // Springboot automatically converts the Person to JSON format
    // Springboot gets the PATHVARIABLE from the URL
    // Here we are returning what we sent to the method
    // in this case because of @ResponseBody
    // Note: To UPDATE we use PUT method
    @PutMapping("/averageUser/{userID}")
    public AverageUser updateAverageUser(@PathVariable int userID, @RequestBody AverageUser averageUser) {
        peopleList.replace(userID, averageUser);
        return (AverageUser) peopleList.get(userID);
    }

    // deletes an average user
    // Springboot gets the PATHVARIABLE from the URL
    // We return the entire list -- converted to JSON
    // in this case because of @ResponseBody
    // Note: To DELETE we use delete method
    @DeleteMapping("/averageUser/{userID}")
    public HashMap<Integer, Person> deleteAverageUser(@PathVariable int userID) {
        peopleList.remove(userID);
        return peopleList;
    }

    // lists all average users
    @GetMapping("/averageUser/all")
        public HashMap<Integer, Person> getAllAverageUsers() {
        return peopleList;
    }


    @GetMapping("/welcome-back/{firstName}")
    public String welcomeBack(@PathVariable String firstName) {
        for (Person p : peopleList.values()) {
            if (p.getFirstName().equals(firstName)) {
                return "Hi, " + p.getFirstName() + ", welcome back to Duality!";
            }
        }
        return "User with the first name: " + firstName + " was not found in our system!";
    }

    @GetMapping("/user/{userID}")
    public String user(@PathVariable int userID) {
        Person p = peopleList.get(userID);
        return "ID: " + userID + ", First Name: " + p.getFirstName() + ", Last Name: " + p.getLastName();
    }
}
