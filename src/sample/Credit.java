package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Credit {
    public static void main(String[] args) throws FileNotFoundException {

        //htpp://textfiles.com/100/capmidn.txt

        File file = new File("C:/Users/ibo20/Desktop/hey.txt");
        Scanner scan  = new Scanner(file);

        System.out.print(scan.nextLine());

        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }



    }
}
