package console;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class consoleReader {
    public static void main(String[] args) throws IOException {

         FileWriter writer= new FileWriter("D:\\test.txt");
         BufferedWriter buffer=new BufferedWriter(writer);
         System.out.println("Enter data:");
         Scanner input = new Scanner(System.in);
         String cont = input.nextLine();
         while (!cont.equals("stop")) {
             System.out.println("Enter data:");
             cont = input.nextLine();
             System.out.println("data is :"+cont);
             buffer.write(cont+"\n" );
         }
         buffer.close();
       }
     }




