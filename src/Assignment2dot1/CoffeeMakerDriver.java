package Assignment2dot1;

public class CoffeeMakerDriver {
    CoffeeMaker coffeeMaker = new CoffeeMaker();
    String espresso = "espresso";
    String normal = "normal";

    void toggleType(){
        if(coffeeMaker.getType()==normal){
            coffeeMaker.setType(espresso);
        } else {
            coffeeMaker.setType(normal);
        }
    }
    void toggleOn(){
        coffeeMaker.pressOnOff();
        System.out.print("\nCoffee maker switched ");
        if(coffeeMaker.isOn()){
            System.out.print("on\n");
        } else {
            System.out.print("off\n");
        }
    }

    void printInfo(){
        System.out.print("\nCoffee maker is ");
        if(coffeeMaker.isOn()){
            System.out.print("on\n");
        } else {
            System.out.print("off\n");
        }
        System.out.println("Coffee type is "+coffeeMaker.getType());
        System.out.println("Coffee amount is "+coffeeMaker.getVolume()+"ml");
    }
    void run(){
        // oletan nyt tehtävänannosta että ei haluta käyttäjän inputtei
        System.out.println("Check coffee maker default settings");
        printInfo();
        System.out.println();
        System.out.println("Attempting change settings when device is off");
        toggleType();
        coffeeMaker.setVolume(5);
        printInfo();

        Utili.separator2();
        System.out.println("Turning the device on and attempting change settings");
        toggleOn();
        toggleType();
        coffeeMaker.setVolume(5);
        printInfo();

        Utili.separator2();
        System.out.println("Turning the device off and on");
        toggleOn();
        toggleOn();

        Utili.separator2();
        System.out.println("Checking if the settings stayed same");
        printInfo();
    }
}
