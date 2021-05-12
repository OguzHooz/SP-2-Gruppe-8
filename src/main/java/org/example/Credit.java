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

    public Credit(Person person, String personRole) {
        this.personRole = personRole;

    }

}