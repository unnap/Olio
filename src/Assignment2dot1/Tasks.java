package Assignment2dot1;

public class Tasks {
    public static void main(String[] args) {
        boolean juokse = true;
        TelevisionViewer katselija = new TelevisionViewer();
        CarDriver carDriver = new CarDriver();
        CoffeeMakerDriver kahvikone = new CoffeeMakerDriver();

        while(juokse) {
            Utili.separator1();
            System.out.println("Choose task:\n1) Task1\n2) Task2&4 Let's drive a car\n3) Task3\n4) Exit\n");

            if (Utili.checkInt()) {
                int choice = Utili.getScanner().nextInt();
                switch(choice) {
                    case 1:
                        katselija.watch();
                        break;
                    case 2:
                        carDriver.run();
                        break;
                    case 3:
                        kahvikone.run();
                        break;
                    case 4:
                        System.out.println("Thanks bye");
                        juokse = false;
                        break;
                    default:
                        System.out.println("No such task");
                }
                Utili.getScanner().nextLine();
                Utili.separator2();
                Utili.cont();
                Utili.getScanner().nextLine();
            }
        }
    }
}