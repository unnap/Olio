package Assignment2dot2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

// I made it so that the program makes the list kinda random
// checking what item it has is random too
// if you want to check if it uses the removeItem, just run it enough times...
// I know this wasn't asked in the assignment, but I wanted to make it more fun for myself

// ......

// goddamn I just read the rest of the tasks
// takaisin sorvin ääreen
public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();


    void addItem(String item){
        if(!groceryList.contains(item)){
        groceryList.add(item);
        } else {
            System.out.println("Item already in the list");
        }
    }
    void removeItem(String item){
        groceryList.remove(item);
    }
    void displayList(){
        int i = 1;
        System.out.println("Grocery list:");
        for(String item : groceryList){
            System.out.println(i+++". "+item);
        }
    }
    boolean checkItem(String item){
        return groceryList.contains(item);
    }

    void run(){
        List<String> items = Arrays.asList("Banana", "Coconut", "Pineapple", "Milk", "Bread", "Ground meat",
                "Cereal", "Frozen pizza", "Pasta", "Instant noodles", "Rice", "Flour",
                "Roux", "Toilet paper", "Chocolate", "Sugar", "Shampoo", "Handsoap",
                "Walnuts", "Ice cream", "Cheese", "Butter", "Tofu", "Curry");
        int loops = ThreadLocalRandom.current().nextInt(3,10);
        Collections.shuffle(items);
        Utili.separator1();
        for(int i=0;i<=loops;i++){
            addItem(items.get(i));
        }

        displayList();
        System.out.println();
        String itemi;
        int num = ThreadLocalRandom.current().nextInt(0,items.size()-1);
        itemi=items.get(num);
        System.out.println("Does the list contain "+itemi+"?");
        if(checkItem(itemi)){
            Utili.getScanner().nextLine();
            System.out.println("...");

            Utili.getScanner().nextLine();
            System.out.println("Yup!");
            removeItem(itemi);

        } else {
            Utili.getScanner().nextLine();
            System.out.println("...");
            Utili.getScanner().nextLine();
            System.out.println("Nope!");
            Utili.getScanner().nextLine();
            System.out.println("Adding "+itemi+" to the grocery list...");
            addItem(itemi);
        }
        Utili.getScanner().nextLine();
        System.out.print("Updated ");
        displayList();
        groceryList.clear();
    }
}
