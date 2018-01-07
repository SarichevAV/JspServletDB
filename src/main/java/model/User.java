package model;

import java.util.Date;

public class User {
    private int userid;
    private String firstname;
    private String lastname;
    private Date dob;
    private String email;

    public int getUserid() {
        return userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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
                "userid=" + userid +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                '}';
    }
}
