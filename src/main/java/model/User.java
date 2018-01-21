package model;

import java.util.Date;

public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private Date dob;
    private String email;


    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userId +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
