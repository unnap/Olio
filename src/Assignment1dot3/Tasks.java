package Assignment1dot3;

import java.util.Scanner;


class Util{
    static boolean checkInt(Scanner scanner){
        //boolean isInt;
        if(scanner.hasNextInt()){
            //System.out.println(";)");
            //scanner.nextLine();
            //scanner.nextLine();
            return true;
        } else {
            System.out.println("Not an integer");
            scanner.nextLine();
            scanner.nextLine();
            return false;
        }
        //return isInt;
    }
}
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
        System.out.println("ax^2 + bx + c = 0\n"+separator+"\nEnter value for a");
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
            System.out.println(separator+"\nNo real roots");
        } else if(discriminate==0) {
            //YKSI JUURI
            //System.out.printf("yksi juuri");
            double x = -b/(2*a);
            System.out.printf(separator+"\nx = %.2f",x);
        } else {
            //KAKSI JUURI
            double x1 = (-b+Math.sqrt(discriminate))/(2*a);
            double x2 = (-b-Math.sqrt(discriminate))/(2*a);
            System.out.printf(separator+"\nx = %.2f\ntai\nx = %.2f",x1,x2);
        }
    }
}

class Task2{
    static void run(Scanner scanner, String separator){
        System.out.println("Enter binary:");
        scanner.nextLine();
        String binary = scanner.nextLine();
        int n = 0;
        int dec = 0;
        for(int i=binary.length()-1; i>=0; i--){
            //System.out.println(i);
            int oneZero = Character.getNumericValue(binary.charAt(i));
            dec+=oneZero*Math.pow(2,n);
            n++;
        }
        System.out.printf(separator+"\nBinary %s is %d in decimal numbers", binary, dec);
        //String testi = "1234";
        //int t = Character.getNumericValue(testi.charAt(3));
        //System.out.println(t);
        //System.out.println();
    }
}


/*

function isPrime(n) {
    if (n <= 1) {
        return false;
    }

    for (let i = 2; i <= Math.sqrt(n); i++) {
        if (n % i === 0) {
            return false;
        }
    }

    return true;
}

*/




class Task3{
    static boolean isPrime(int num){
        boolean prime = true;
        if (num==1){
            prime = false;
        } else {
            for (int i=2;i<=Math.sqrt(num);i++){
                if(num%i==0){
                    prime = false;
                }
            }
        }
        return prime;
    }

    static void run(Scanner scanner, String separator){
        int loops = 0;
        int num1=0, num2=0;
        while (loops<2){
            if (loops==0){
                System.out.println("Give the first integer");
                if(Util.checkInt(scanner)){
                    num1 = scanner.nextInt();
                    if(num1>0){
                        loops++;
                    } else {
                        System.out.println(separator+"\nThe integer needs to be a positive number\n"+separator);
                    }
                }
            } else {
                System.out.println("Give second integer that is bigger than the first");
                if(Util.checkInt(scanner)){
                    num2 = scanner.nextInt();
                    if(num1<num2){
                        loops++;
                    } else {
                        System.out.println(separator+"\nThe integer needs to be bigger than the first one\n"+separator);
                    }
                }
            }
        }
        //System.out.println("END");
        System.out.printf(separator+"\nThe prime numbers between %d and %d:\n",num1,num2);
        boolean found = false;
        for(int n = num1; n<=num2; n++){
            if(isPrime(n)){
                System.out.println(n);
                if(!found){
                    found=true;
                }
            }
        }
        if(!found){
            System.out.println("No primes");
        }
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
        String separator2 = "-----";
        String cont = "\nPress Enter to continue";
        Scanner scanner = new Scanner(System.in);
        boolean juokse = true;

        while(juokse) {
            System.out.println(separator1 +"\nChoose task:\n1) Task1\n2) Task2\n3) Task3\n4) Task4\n5) Exit\n");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch(choice) {
                    case 1:
                        Task1.run(scanner, separator2);
                        break;
                    case 2:
                        Task2.run(scanner, separator2);
                        break;
                    case 3:
                        Task3.run(scanner, separator2);
                        break;
                    case 4:
                        Task4.run();
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
