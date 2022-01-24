import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan  = new Scanner(System.in);
        int decider = scan.nextInt();
        scan.nextLine();
        String txt , res="";
        switch (decider) {
            case 1 -> {
                txt = scan.nextLine();
                Compressor compress = new Compressor(txt);
                res = compress.compress();
            }
            case 2 -> {
                int numOfCodes = scan.nextInt();
                scan.nextLine();
                String[] inp;
                HashMap<Character, Integer> codes = new HashMap<>();
                for (int i = 0; i < numOfCodes; i++) {
                    inp = scan.nextLine().split(" ");
                    codes.put(inp[0].charAt(0), Integer.parseInt(inp[1]));
                }
                txt = scan.nextLine();
                Decompressor decompressor = new Decompressor(txt, codes);
                res = decompressor.decompress();
            }
        }
        System.out.println(res);

    }
}
