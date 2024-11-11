package machine;

import java.util.Scanner;

public class InputHelper{
    private static final Scanner scanner = new Scanner(System.in);

    public int getInt(String message){
        System.out.println(message);
        return scanner.nextInt();
    }

    public String getString(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static void closeScanner(){
        scanner.close();
    }
}