package com;
import java.io.*;
import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {

        // code to create the file
   try{
    File myFile = new File("tasknew.txt");
   myFile.createNewFile();
    } catch (IOException e) {
       System.out.println("unable to create this file ");
       throw new RuntimeException(e);
   }

   //code to write a file
        try {
            FileWriter fileWriter =new FileWriter( "tasknew.txt");
            fileWriter.write("this is my first task of the java programming languange ");
            fileWriter.close();
            System.out.println("File Write.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // code to read a file
        File myfile =new File("tasknew.txt");
        try {
            Scanner sc =new Scanner(myfile);
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
            System.out.println("File Read.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

            // code to modify  a file
        FileWriter modify  = null;
        try {
            modify = new FileWriter( "tasknew.txt", true);
            modify.write("\n File modified successfully.");
            modify.close();
            System.out.println("File modified.");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}









