import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandler {

   public static void writeFile(String text) {
       try {
           PrintWriter writer = new PrintWriter("output.txt");
           writer.print(text);
           writer.close();
       }catch (FileNotFoundException e){
           e.printStackTrace();
       }

   }
   public static String readFile(String input) {
       try {
           String res= "";
           String path = input.isEmpty() ?  "output.txt" : input;
           File f = new File(path);
           Scanner reader = new Scanner(f);
           while (reader.hasNextLine()){
               res = res.concat(reader.nextLine()+ "\n");
           }
           reader.close();
           return res;

       }catch (FileNotFoundException e){
           e.printStackTrace();
       }
       return null;
   }

}
