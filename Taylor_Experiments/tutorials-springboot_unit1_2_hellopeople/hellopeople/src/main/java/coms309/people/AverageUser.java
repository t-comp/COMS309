package coms309.people;

public class AverageUser extends Person {

    private int timesLoggedIn;

    // default constructor
    public AverageUser() {
        super();
    }

    public AverageUser(int userID, String firstName, String lastName, String address, String telephone, int timesLoggedIn) {
        super(userID, firstName, lastName, address, telephone);
        this.timesLoggedIn = timesLoggedIn;
    }

    // returns number of times user logged in
    public int getTimesLoggedIn() {
        return timesLoggedIn;
    }

    // sets number of times a user logged in
    public void setTimesLoggedIn(int timesLoggedIn) {
        this.timesLoggedIn = timesLoggedIn;
    }

}
