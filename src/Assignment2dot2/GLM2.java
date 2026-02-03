package Assignment2dot2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

// uhhhh
// I ended up doing a lot
// and this is a clusterfuck.
// but it should fulfill the requirements
// displayAvailableItems(): This method should display items along with their quantities that have a positive quantity.
// ^^I did not add this one since displayList() already fulfills it
// Should not be possible to add negative quantity items

public class GLM2 {
    private HashMap<String,ArrayList> groceryList = new HashMap();
    // Tulkitsin tehtävän että tässä tehtävässä oli tarkoitus nimenomaan käyttää listoja eikä classeja
    // kivuliasta

    void addItem(String item,String category,Double cost,int quantity){
        if(quantity>0) {
            if (!checkItem(item)) {
                ArrayList<Object> data = new ArrayList<>();
                data.add(category);
                data.add(cost);
                data.add(quantity);
                groceryList.put(item, data);
            } else {
                int newQuantity = (int) groceryList.get(item).get(2) + 1;
                groceryList.get(item).add(2, newQuantity);
            }
        } else {
            System.out.println("dont be cheeky i am tired");
        }
    }

    void removeItem(String item){
        groceryList.remove(item);
        System.out.println(item+" removed from the list");
    }

    // 0 CATEGORY
    // 1 COST
    // 2 QUANT
    void displayList(){
        int i = 1;
        final int indexWidth=3;
        final int nameWidth=17;
        final int priceWidth=7;
        final int totalCostWidth=21;
        String rowFormat="%-"+indexWidth+"s %-"+nameWidth+"s %"+priceWidth+".2f€    %-13s x%2d%n";

        System.out.println("Grocery list:");
        for(Map.Entry<String, ArrayList> item: groceryList.entrySet()){
            System.out.printf(rowFormat,i+++".",item.getKey(),item.getValue().get(1),item.getValue().get(0),
                    item.getValue().get(2));
        }
        rowFormat="%-"+totalCostWidth+"s %"+priceWidth+".2f€%n";
        Utili.separator2();
        System.out.printf(rowFormat,"Total cost:",calculateTotalCost());

        Utili.separator2();

        System.out.println("Wanna update quantity of an item?\n1) ye\n2) nah");
        Utili.getScanner().nextLine();
        if(Utili.getScanner().nextInt()==1){
            Utili.getScanner().nextLine();
            System.out.println("Enter which item (write it out)");
            String itemi = Utili.getScanner().nextLine();
            System.out.println("Enter new quantity");
            int q = Utili.getScanner().nextInt();
            updateQuantity(itemi,q);
        }
    }

    boolean checkItem(String item){return groceryList.containsKey(item);}

    void checkCat(){
        System.out.println("Categories present in the grocery list");
        ArrayList<String> categories = new ArrayList<>();
        int i = 1;
        for(Map.Entry<String,ArrayList> item : groceryList.entrySet()){
            String category=item.getValue().get(0).toString();
            if(!categories.contains(category)){
                categories.add(category);
                System.out.println(i+++") "+category);
            }
        }
        System.out.println("Choose category by entering the list number");
        int intti = Utili.getScanner().nextInt();
        displayByCategory(categories.get(intti-1));
    }

    Double calculateTotalCost(){
        Double total=0.0;
        for(Map.Entry<String, ArrayList> item : groceryList.entrySet()){
            int kerroin=(int)item.getValue().get(2);
            total+= (double)item.getValue().get(1)*kerroin;
        }
        return total;
    }

    void displayByCategory(String category){
        System.out.println("All "+category+" items:");
        // I'm getting lazy and just copying this here from displayItems
        int i=1;
        final int indexWidth=3;
        final int nameWidth=17;
        final int priceWidth=7;
        String rowFormat="%-"+indexWidth+"s %-"+nameWidth+"s %"+priceWidth+".2f€    %-13s x%2d%n";

        for(Map.Entry<String,ArrayList> item : groceryList.entrySet()){
            List cat = item.getValue();
            if(cat.get(0).toString().equalsIgnoreCase(category)){
                System.out.printf(rowFormat,i+++".",item.getKey(),item.getValue().get(1),item.getValue().get(0),
                        item.getValue().get(2));
            }
        }
    }

    void updateQuantity(String item, int quant){
        if(checkItem(item)) {
            if (quant <= 0) {
                removeItem(item);
            } else {
                groceryList.get(item).add(2, quant);
                System.out.println(item+" quantity updated");
            }
        }else{
            System.out.println("No such item");
        }
    }

    void run(){
        List<Grocery> items = Arrays.asList(new Grocery("Banana", "Fruit"),
                new Grocery("Coconut","Fruit"), new Grocery("Pineapple", "Fruit"),
                new Grocery("Milk","Dairy"), new Grocery("Bread","Carbs"),
                new Grocery("Ground meat","Protein"),
                new Grocery("Cereal","Carbs"), new Grocery("Frozen pizza","Food"),
                new Grocery("Pasta","Carbs"), new Grocery("Instant noodles","Food"),
                new Grocery("Rice","Carbs"), new Grocery("Flour","Carbs"),
                new Grocery("Roux","Cooking"), new Grocery("Toilet paper","Toiletries"),
                new Grocery("Chocolate","Snacks"), new Grocery("Sugar","Cooking"),
                new Grocery("Shampoo","Toiletries"), new Grocery("Handsoap","Toiletries"),
                new Grocery("Walnuts","Snacks"), new Grocery("Ice cream","Snacks"),
                new Grocery("Cheese","Snacks"), new Grocery("Butter","Dairy"),
                new Grocery("Tofu","Protein"), new Grocery("Curry","Cooking"));

        int loops = ThreadLocalRandom.current().nextInt(3,10);
        Collections.shuffle(items);
        for(int i=0;i<=loops;i++){
            Grocery item= items.get(i);
            int quantity = ThreadLocalRandom.current().nextInt(1,3);
            addItem(item.getName(),item.getCategory(),item.getCost(),quantity);
        }
        for(int i=0;i<3;i++){
            addItem("Coffee","Snacks",20.0,1);
        }

        boolean juokse = true;

        while(juokse) {
            Utili.separator1();
            System.out.println("LET'S GROCERY LIST");
            Utili.separator2();
            System.out.println("1) Check list\n" +
                    "2) Search by category!\n" +
                    "3) Add item\n" +
                    "4) Exit");
            switch (Utili.getScanner().nextInt()) {
                case 1:
                    displayList();
                    break;
                case 2:
                    checkCat();
                    break;
                case 3:
                    Utili.getScanner().nextLine();
                    System.out.println("Enter item name");
                    String userItem=Utili.getScanner().nextLine();
                    if(checkItem(userItem)){
                        System.out.println(userItem+" already in the list");
                        System.out.println("want to update quantity or remove item?\n1)update\n2)remove\n3)nothing");
                        switch (Utili.getScanner().nextInt()){
                            case 1:
                                System.out.println("Set quantity");
                                updateQuantity(userItem, Utili.getScanner().nextInt());
                                break;
                            case 2:
                                removeItem(userItem);
                                break;
                            default:
                                System.out.println("ok");
                                Utili.getScanner().nextLine();
                        }
                    } else {
                        System.out.println("Enter item category");
                        String userCat=Utili.getScanner().nextLine();
                        System.out.println("Enter item cost");
                        double userCost=Utili.getScanner().nextDouble();
                        System.out.println("Enter item quantity");
                        int userQuant=Utili.getScanner().nextInt();
                        addItem(userItem,userCat,userCost,userQuant);

                        if(userQuant>0) {
                            System.out.println("Item added");
                        }
                    }
                    break;
                default:
                    System.out.println("Let's not grocery");
                    juokse = false;
            }
            if(juokse) {
                Utili.getScanner().nextLine();
                Utili.separator2();
                Utili.cont();
                Utili.getScanner().nextLine();
            }
        }
        System.out.println();
        groceryList.clear();
    }
}

class Grocery{
    private String name;
    private String category;
    private double cost;

    Grocery(String name, String category){
        this.name=name;
        this.category=category;
        this.cost=ThreadLocalRandom.current().nextDouble(2,20);
    }
    String getName(){return this.name;}
    String getCategory(){return this.category;}
    Double getCost(){return this.cost;}
}