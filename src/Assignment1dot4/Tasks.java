package Assignment1dot4;

import java.util.Scanner;


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
    static boolean checkInt(Scanner scanner){
        if(scanner.hasNextInt()){
            return true;
        } else {
            System.out.println("You need to input a valid integer");
            scanner.nextLine();
            Util.seperator2();
            cont();
            scanner.nextLine();
            scanner.nextLine();
            return false;
        }
    }
}

class Task1{
    static void run(Scanner scanner){

        String[] firstNames = {"Mario ", "Luigi ", "Toad ", "Bowser ", "Daisy ",
                                "Hannu ", "Roope ", "Aku ", "Milla ", "Iines "};
        String[] lastNames = {"Kivinen", "Soranen", "Hanhi", "Ankka", "Toadstool",
                                "Järvinen", "Tanaka", "Smith", "Aran", "Magia"};
        boolean jatka = false;
        int loops = 0;
        while(!jatka){
            System.out.println("Enter how many names you want to generate");
            if(Util.checkInt(scanner)){
                loops = scanner.nextInt();
                if(loops>0){
                    jatka = true;
                } else {
                    System.out.println("Give number bigger than 0 >:(");
                    Util.seperator2();
                    scanner.nextLine();
                }
            }
            for(int i = 0; i<loops; i++){
                int f = (int)(Math.random()*10);
                int l = (int)(Math.random()*10);
                System.out.println(firstNames[f]+lastNames[l]);
            }
        }
    }
}

class Task2{
    static void run(Scanner scanner){
        System.out.println("Enter array size");
        int arraySize = scanner.nextInt();
        int[] numbers = new int[arraySize];
        System.out.println("Enter integers in the array");
        for(int i=0;i<arraySize;i++){
            System.out.printf("Enter integer #%d: ",i+1);
            numbers[i]= scanner.nextInt();
        }
        int maxSum=0;
        int startInt=0, endInt=0;

        //big thanks to GeeksForGeeks for saving my life
        //I got as far as the second loop but then my brain shut itself down
        //https://www.geeksforgeeks.org/dsa/generating-subarrays-using-recursion/
        //〒▽〒
        for(int a=0;a<arraySize;a++){

            for(int b=a;b<arraySize;b++){
                int sum = 0;

                for(int c=a;c<=b;c++){
                    sum+=numbers[c];
                }

                if(sum>maxSum){
                    maxSum=sum;
                    startInt=a+1;
                    endInt=b+1;
                }

            }
        }
    System.out.printf("\nMax sum: %d\nIntegers: %d-%d\n",maxSum,startInt,endInt);
    }
}

class Task3{
    static void run(Scanner scanner){
        System.out.println("Enter array size");
        int arraySize = scanner.nextInt();
        int[] numbers = new int[arraySize];
        int[] numbersNoDupes=new int[arraySize];
        System.out.println("Enter integers in the array");
        for(int i=0;i<arraySize;i++){
            System.out.printf("Enter integer #%d: ",i+1);
            numbers[i]= scanner.nextInt();
        }
        int position=0;
        for(int i=0;i<arraySize;i++){
            boolean dupe=false;
            for(int num : numbersNoDupes){
                if(num==numbers[i]){
                    dupe=true;
                }
            }
            if(!dupe){
                numbersNoDupes[position++]=numbers[i];
            }
        }
        System.out.println("\nThe array without duplicates:");
        for(int i=0;i<position;i++){
            System.out.print(numbersNoDupes[i]+" ");
        }
        System.out.println();
    }
}

public class Tasks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean juokse = true;

        while(juokse) {
            Util.seperator1();
            System.out.println("Choose task:\n1) Task1\n2) Task2\n3) Task3\n4) Exit\n");

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
