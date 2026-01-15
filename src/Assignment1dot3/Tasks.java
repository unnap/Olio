package Assignment1dot3;

import java.util.Scanner;

/*
Ei reaalisia juuria (D<0)
Esimerkki:
a=1
b=2
c=5

Yksi reaalinen juuri (D=0)
Esimerkki:
a=1
b=2
c=1

Kaksi reaalista juurta (D>0)
Esimerkki:
a=1
b=−3
c=2
*/


class Task1{
    static void run(Scanner scanner, String separator){
        //enter the coefficients of a quadratic equation
        // (ax^2 + bx + c = 0)
        System.out.println("ax^2 + bx + c = 0"+separator+"Enter value for a");
        double a = scanner.nextDouble();
        System.out.println("Enter value for b");
        double b = scanner.nextDouble();
        System.out.println("Enter value for c");
        double c = scanner.nextDouble();
        //x = (-b+-sqr(b2-4ac))/2a
        double discriminate = Math.pow(b,2)-(4*a*c);
        //System.out.println(discriminate);
        //System.out.println(Math.sqrt(discriminate));
        //D>0 kaksi juuri
        //D=0 yksi juuri
        //D<0 ei juuri
        if(discriminate<0){
            //EI JUURI
            System.out.printf(separator+"No real roots");
        } else if(discriminate==0) {
            //YKSI JUURI
            //System.out.printf("yksi juuri");
            double x = -b/(2*a);
            System.out.printf(separator+"x = %.2f",x);
        } else {
            //KAKSI JUURI
            double x1 = (-b+Math.sqrt(discriminate))/(2*a);
            double x2 = (-b-Math.sqrt(discriminate))/(2*a);
            System.out.printf(separator+"x = %.2f\ntai\nx = %.2f",x1,x2);
        }
    }
}

class Task2{
    static void run(){
        String bin = "1101";
        int n = 0;
        int dec = 0;
        for(int i=bin.length()-1; i>=0; i--){
            //System.out.println(i);
            int oneZero = Character.getNumericValue(bin.charAt(i));
            dec+=oneZero*Math.pow(2,n);
            n++;
        }
        System.out.println(dec);
        //String testi = "1234";
        //int t = Character.getNumericValue(testi.charAt(3));
        //System.out.println(t);
        //System.out.println();
    }
}

class Task3{
    static void run(){
        System.out.println("placeholder 3");
    }
}

class Task4{
    static void run(){
        System.out.println("placeholder 4");
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
        Task4 task4 = new Task4();
        boolean juokse = true;

        while(juokse) {
            System.out.println(separator1 +"\nChoose task:\n1) Task1\n2) Task2\n3) Task3\n4) Task4\n5) Exit\n");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch(choice) {
                    case 1:
                        task1.run(scanner, separator2);
                        break;
                    case 2:
                        task2.run();
                        break;
                    case 3:
                        task3.run();
                        break;
                    case 4:
                        task4.run();
                        break;
                    case 5:
                        System.out.printf("Thanks bye");
                        juokse = false;
                        break;
                    default:
                        System.out.printf("No such task");
                }
                scanner.nextLine();
                System.out.printf(separator2+cont);
                scanner.nextLine();
            } else {
                System.out.printf("You need to input a valid integer");
                scanner.nextLine();
                System.out.printf(separator2+cont);
                scanner.nextLine();
            }
        }
    }
}
