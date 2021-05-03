package org.example;
import java.util.HashMap;

public class Credit {

    private String personRole;

    static HashMap<Person, String> personWithRole = new HashMap<Person, String>();


    public String getPersonRole() {
        return personRole;
    }

    public void setPersonRole(String personRole) {
        this.personRole = personRole;
    }



}
