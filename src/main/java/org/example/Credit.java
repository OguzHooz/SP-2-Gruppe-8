package org.example;
import java.util.HashMap;

public class Credit {

    private int pID;
    private String pName;
    private String personRole;
    private int creditID;


    public Credit(Person person, String personRole, int pID, String pName) {
        this.personRole = personRole;
        this.pID =person.getPersonID();
        this.pName = person.getPersonName();
        this.creditID = 0;

    }

    public Credit(String personRole, int pID, int creditID){
        this.personRole = personRole;
        this.pID =pID;
        this.creditID = creditID;


    }


    public String getPersonRole() {
        return personRole;
    }

    public void setPersonRole(String personRole) {
        this.personRole = personRole;
    }

    public int getCreditID() {
        return creditID;
    }

    public void setCreditID(int creditID) {
        this.creditID = creditID;
    }


    public int getpID() {
        return pID;
    }

    public String getpName() {
        return pName;
    }


}