import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome Java");
        System.out.println("Enter a character");

        int n=0;
        try {
            n = System.in.read();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("you typed " + n);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String st1 = br.readLine();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        Scanner in = new Scanner(System.in);
        String str2 = in.nextLine();

        System.out.println("Using Console");
        Console console = System.console();
        if(console==null){
            System.err.println("error");
            System.exit(-1);
        }
        console.printf(console.readLine());

        System.out.println("Using Switch Expression");

    }
}
