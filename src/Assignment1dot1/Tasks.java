package Assignment1dot1;

import java.util.Scanner;

class Task1 {
    static void run() {
        System.out.println("Terve");
    }
}

class Task2 {
    static void run() {
        System.out.println(
                "    *\n" +
                "   ***\n" +
                "  *****\n" +
                " *******\n" +
                " ");
    }
}

class Task3 {
    static void run(Scanner scanner) {


        System.out.println("Give integer: ");
        int first = scanner.nextInt();

        System.out.println("Second int: ");
        int second = scanner.nextInt();

        System.out.println("Third int: ");
        int third = scanner.nextInt();

        double avg = (double)(first+second+third)/3;
        //int cant do decimals so you need to change it to double

        System.out.println("The sum of your numbers is "+(first+second+third)
                +"\nThe product is "+(first*second*third)
                +"\nThe average is "+avg);
    }
}

class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("Kissa "+name+" sanoo Mau!");
    }
}

class Task4 {
    static void run() {
        Cat cat1 = new Cat("Lissu");
        Cat cat2 = new Cat("Ville");

        cat1.meow();
        cat1.meow();
        cat2.meow();
        cat1.meow();
    }
}


public class Tasks {
    public static void main(String[] args) {
        String separator1 = "==============";
        String separator2 = "-----\n";
        String cont = "Press Enter to continue";
        Scanner scanner = new Scanner(System.in);
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Task3 task3 = new Task3();
        Task4 task4 = new Task4();
        boolean juokse = true;

        while(juokse) {
            System.out.println(separator1 +"\nChoose task:\n1) Task1\n2) Task2\n3) Task3\n4) Task4\n5) Exit\n");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch(choice) {
                    case 1:
                        task1.run();
                        break;
                    case 2:
                        task2.run();
                        break;
                    case 3:
                        task3.run(scanner);
                        break;
                    case 4:
                        task4.run();
                        break;
                    case 5:
                        System.out.println("Thanks bye");
                        juokse = false;
                        break;
                    default:
                        System.out.println("No such task");
                }
                scanner.nextLine();
                System.out.println(separator2+cont);
                scanner.nextLine();
            } else {
                System.out.println("You need to input a valid integer");
                scanner.nextLine();
                System.out.println(separator2+cont);
                scanner.nextLine();
            }
        }
    }
}

