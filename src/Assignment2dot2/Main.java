package Assignment2dot2;


public class Main {
    public static void main(String[] args) {
        boolean juokse = true;
        GroceryListManager kauppalista1 = new GroceryListManager();
        GLM2 kauppalista2 = new GLM2();

        while(juokse) {
            Utili.separator1();
            System.out.println("Choose task:\n1) Task1\n2) The rest of the tasks\n4) Exit\n");

            if (Utili.checkInt()) {
                int choice = Utili.getScanner().nextInt();
                switch(choice) {
                    case 1:
                        kauppalista1.run();
                        break;
                    case 2:
                        kauppalista2.run();
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