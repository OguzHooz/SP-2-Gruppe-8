package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Credit {
    public static void main(String[] args) throws IOException {

        //htpp://textfiles.com/100/capmidn.txt

        File file = new File("C:/Users/ibo20/Desktop/hey.txt");
        Scanner scan  = new Scanner(file);

        //System.out.print(scan.nextLine());

        String fileContent = "";
        while(scan.hasNextLine()){
            //System.out.println(scan.nextLine());
            fileContent = fileContent.concat(scan.nextLine() + "\n");
        }
        FileWriter writer = new FileWriter("C:/Users/ibo20/Desktop/newJavaFileNew.txt");
        writer.write(fileContent);
        writer.close();



    }
}
