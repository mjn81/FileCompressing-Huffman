import java.io.*;

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
           StringBuilder res= new StringBuilder();
           String path = input.isEmpty() ?  "output.txt" : input;
           File f = new File(path);
           FileInputStream fis = new FileInputStream(f);
           int content;
           while ((content = fis.read()) != -1) {
               res.append((char) content);
           }
           return res.toString();

       }catch (IOException e){
           e.printStackTrace();
       }
       return null;
   }

}
