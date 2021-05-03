package org.example;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;

public class Program {
    private int programID;
    private String title;
    private String releaseDate;
    //AtomicInteger count = new AtomicInteger(0);
    private static final AtomicInteger programCounter = new AtomicInteger(0);

    ArrayList<Credit> listOfCreditsL;

    //Overloading this constructor so it's possible to create other objects
    public Program (int programID, String title, String releaseDate){
        //We start by initializing the variables
        this.programID = programID;
        this.title = title;
        this.releaseDate = releaseDate;
    }


    public int generateProgramID() {
        programID = programCounter.incrementAndGet();
        return programID;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
