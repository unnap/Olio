package Assignment1dot2;

import java.util.Scanner;

class Task1{
    static void run(Scanner scanner){
        System.out.println("Enter Fahrenheit");
        double temp = scanner.nextDouble();
        double celsius = (temp-32)/1.8;
        System.out.printf("%.1f Fahrenheit is %.1f Celsius", temp, celsius);
    }
}

class Task2{
    static void run(Scanner scanner){
        System.out.println("Leg one");
        double leg1 = scanner.nextDouble();
        System.out.println("Leg two");
        double leg2 = scanner.nextDouble();
        double hypo = Math.sqrt(Math.pow(leg1,2)+Math.pow(leg2,2));
        System.out.printf("Your hypotenuse is %.2f", hypo);
    }
}

class Task3{
    static void run(Scanner scanner){
        System.out.println("Anna gramma");
        double gramma = scanner.nextDouble(), alkupGramma = gramma;
        double luotiGrammat = 13.28;
        double naulaGrammat = luotiGrammat*32;
        double leiviskaGrammat = naulaGrammat*20;
        double luodit;
        int naulat = 0, leiviskat = 0;

        if (gramma>=leiviskaGrammat) {
            leiviskat = (int) (gramma/leiviskaGrammat);
            gramma-=(leiviskat*leiviskaGrammat);
        }
        if (gramma>=naulaGrammat) {
            naulat = (int) (gramma/naulaGrammat);
            gramma-=(naulat*naulaGrammat);
        }
        luodit = gramma/luotiGrammat;

        System.out.printf("%.2f grammaa on %d leiviskää, %d naulaa ja %.2f luotia",
                alkupGramma, leiviskat, naulat, luodit);
    }
}

public class Tasks {
    public static void main(String[] args) {
        String separator1 = "==============";
        String separator2 = "\n-----\n";
        String cont = "Press Enter to continue";
        Scanner scanner = new Scanner(System.in);

        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        boolean juokse = true;

        while (juokse) {
            System.out.println(separator1 + "\nChoose task:\n1) Task1\n2) Task2\n3) Task3\n4) Exit\n");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        task1.run(scanner);
                        break;
                    case 2:
                        task2.run(scanner);
                        break;
                    case 3:
                        task3.run(scanner);
                        break;
                    case 4:
                        System.out.println("Thanks bye");
                        juokse = false;
                        break;
                    default:
                        System.out.println("No such task");
                }
                scanner.nextLine();
                System.out.println(separator2 + cont);
                scanner.nextLine();
            } else {
                System.out.println("You need to input a valid integer");
                scanner.nextLine();
                System.out.println(separator2 + cont);
                scanner.nextLine();
            }
        }
    }
}