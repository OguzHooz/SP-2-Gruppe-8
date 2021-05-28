package org.example;
import java.util.HashMap;

public class Credit {

    public String getPersonRole() {
        return personRole;
    }

    public void setPersonRole(String personRole) {
        this.personRole = personRole;
    }

    private String personRole;

    public int getpID() {
        return pID;
    }

    public String getpName() {
        return pName;
    }

    private int pID;
    private String pName;

    public Credit(Person person, String personRole, int pID, String pName) {
        this.personRole = personRole;
        this.pID =person.getPersonID();
        this.pName = person.getPersonName();
    }

    public Credit(String personRole, int pID, String pName){

    }

}