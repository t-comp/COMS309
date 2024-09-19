package coms309.people;


/**
 * Provides the Definition/Structure for the people row
 */

public class Person {

    private String firstName;

    private String lastName;

    private String address;

    private String telephone;

    private int userID;




    public Person(){
        
    }

    public Person(int userID, String firstName, String lastName, String address, String telephone) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.telephone = telephone;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getUserID() {return this.userID;}

    public void setUserID(int userID) {this.userID = userID;}

    @Override
    public String toString() {
        return userID + " "
                + firstName + " "
               + lastName + " "
               + address + " "
               + telephone;
    }
}
