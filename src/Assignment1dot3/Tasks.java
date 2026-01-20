package Assignment1dot3;

import java.util.Scanner;

//on hindsight, it's probably bad idea to name this class util?
//since java has its own "util"?
//oh well... TOO LATE NOW
class Util{
    static void seperator1(){
        System.out.println("==============");
    }
    static void seperator2(){
        System.out.println("-----");
    }
    static void cont(){
        System.out.println("Press Enter to continue");
    }

    //I don't consistently check if the user enters a proper integer
    //this is just for fun when I have the energy
    static boolean checkInt(Scanner scanner){
        if(scanner.hasNextInt()){
            return true;
        } else {
            System.out.println("You need to input a valid integer");
            scanner.nextLine();
            Util.seperator2();
            cont();
            scanner.nextLine();
            return false;
        }
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
    static void run(Scanner scanner){
        //enter the coefficients of a quadratic equation
        // (ax^2 + bx + c = 0)
        System.out.println("ax^2 + bx + c = 0");
        Util.seperator2();
        System.out.println("Enter value for a");
        double a = scanner.nextDouble();
        System.out.println("Enter value for b");
        double b = scanner.nextDouble();
        System.out.println("Enter value for c");
        double c = scanner.nextDouble();
        double discriminate = Math.pow(b,2)-(4*a*c);

        if(discriminate<0){
            //EI JUURI
            Util.seperator2();
            System.out.println("No real roots");
        } else if(discriminate==0) {
            //YKSI JUURI
            double x = -b/(2*a);
            Util.seperator2();
            System.out.printf("x = %.2f\n",x);
        } else {
            //KAKSI JUURI
            double x1 = (-b+Math.sqrt(discriminate))/(2*a);
            double x2 = (-b-Math.sqrt(discriminate))/(2*a);
            Util.seperator2();
            System.out.printf("x = %.2f\ntai\nx = %.2f\n",x1,x2);
        }
    }
}

class Task2{
    static void run(Scanner scanner){
        System.out.println("Enter binary:");
        scanner.nextLine();
        String binary = scanner.nextLine();
        int n = 0;
        int dec = 0;
        for(int i=binary.length()-1; i>=0; i--){
            int oneZero = Character.getNumericValue(binary.charAt(i));
            dec+=oneZero*Math.pow(2,n);
            n++;
        }
        Util.seperator2();
        System.out.printf("Binary %s is %d in decimal numbers", binary, dec);
    }
}

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

    static void run(Scanner scanner){
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
                        Util.seperator2();
                        System.out.println("The integer needs to be a positive number");
                        Util.seperator2();
                    }
                }
            } else {
                System.out.println("Give second integer that is bigger than the first");
                if(Util.checkInt(scanner)){
                    num2 = scanner.nextInt();
                    if(num1<num2){
                        loops++;
                    } else {
                        Util.seperator2();
                        System.out.println("The integer needs to be bigger than the first one");
                        Util.seperator2();
                    }
                }
            }
        }
        Util.seperator2();
        System.out.printf("The prime numbers between %d and %d:\n",num1,num2);
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

    static void run(Scanner scanner) {
        System.out.println("MULTIPLICATION QUIZ TIME");
        Util.seperator1();
        boolean loopin = true;

        while(loopin){
            int correct = 0;
            int loops = 10;
            System.out.printf("You need to score %d to succeed\n", loops);
            for(int i = 0; i<loops; i++){
                Util.seperator1();
                int num1 = (int) (Math.random() * 10) + 1;
                int num2 = (int) (Math.random() * 10) + 1;
                int correctAnswer = num1*num2;
                System.out.printf("\nQuestion #%d\n%d x %d = \n",i+1, num1, num2);
                int userAnswer = scanner.nextInt();
                if(userAnswer==correctAnswer){
                    System.out.printf("CORRECT!\n%d x %d = %d\n",num1,num2,correctAnswer);
                    correct++;
                } else {
                    System.out.printf("WRONG!\n%d x %d = %d\n",num1,num2,correctAnswer);
                }
            }
            Util.seperator1();
            System.out.printf("\nYou got %d answers correct\n",correct);
            Util.seperator2();
            if(correct==loops){
                System.out.println("YOU GOT EVERYTHING RIGHT!");
                scanner.nextLine();
                scanner.nextLine();
                System.out.println("You are free to go.");
                loopin = false;
            } else {
                System.out.printf("YOU NEED %d ANSWERS CORRECT TO ESCAPE",loops);
                scanner.nextLine();
                scanner.nextLine();
                Util.seperator2();
                System.out.println("Here we go again");
                Util.seperator2();
                scanner.nextLine();

            }
        }
    }
}

public class Tasks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean juokse = true;

        while(juokse) {
            Util.seperator1();
            System.out.println("Choose task:\n1) Task1\n2) Task2\n3) Task3\n4) Task4\n5) Exit\n");

            if (Util.checkInt(scanner)) {
                int choice = scanner.nextInt();
                switch(choice) {
                    case 1:
                        Task1.run(scanner);
                        break;
                    case 2:
                        Task2.run(scanner);
                        break;
                    case 3:
                        Task3.run(scanner);
                        break;
                    case 4:
                        Task4.run(scanner);
                        break;
                    case 5:
                        System.out.println("Thanks bye");
                        juokse = false;
                        break;
                    default:
                        System.out.println("No such task");
                }
                scanner.nextLine();
                Util.seperator2();
                Util.cont();
                scanner.nextLine();
            }
        }
    }
}
