package Assignment2dot1;

import java.util.Scanner;

public class Utili{
    private static final Scanner skanneri = new Scanner(System.in);
    public static Scanner getScanner(){
        return skanneri;
    }
    public static void closeScanner() {
        skanneri.close();
    }
    static void separator1(){
        System.out.println("==============");
    }
    static void separator2(){
        System.out.println("-----");
    }
    static void cont(){
        System.out.println("Press Enter to continue");
    }

    static boolean checkInt(){
        if(skanneri.hasNextInt()){
            return true;
        } else {
            System.out.println("You need to input a valid integer");
            skanneri.nextLine();
            Utili.separator2();
            cont();
            skanneri.nextLine();
            skanneri.nextLine();
            return false;
        }
    }
}