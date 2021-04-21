package sample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Producer {



    public Program  addProgram(){
        //We start by importing the scanner
        Scanner myObj = new Scanner(System.in);

        //Start by asking for the movie title
        System.out.println("Indtast navnet på din film ");
        String title = myObj.nextLine(); //This should be a textfield on the GUI

        //Ask for the release date
        System.out.println("Indtast navnet på din udgivelsesdato på din film ");
        String releaseD = myObj.nextLine(); //This should be a textfield on the GUI
        Program test = new Program(0, null, null);


        //Program ID

        //Here we create the new program
        Program p = new Program (test.generateProgramID(), title, releaseD);

        System.out.println("Nu er filmen blevet tilføjet ");


        System.out.println("Filmen " + title+ " har ID " + test.getProgramID());


        //Here we add the newly created program to the array
        System1.listOfPrograms.add(p);

        return p;





    }
}
