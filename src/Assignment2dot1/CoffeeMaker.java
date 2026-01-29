package Assignment2dot1;

public class CoffeeMaker {
    private boolean on = false;
    // eli tässä olen ajatellut että jos käyttäjälle antaa listan josta valita 1-8
    // tälleen ajatellen että tässä on console käyttöliittymä
    // ja että määrän voi valita 10ml välillä
    private final int minVol = 1;
    private final int maxVol = 8;
    private final int stepSize = 10;

    private int volume;
    private final String normal = "normal";
    private final String espresso = "espresso";
    private String coffeeType;

    public CoffeeMaker(){
        this.volume=40;
        this.coffeeType=normal;
    }
    void setVolume(int vol){
        if(on){
            if(vol<minVol){
                this.volume=minVol*stepSize;
            }else{
                this.volume=Math.min(maxVol*stepSize,vol*stepSize);
            }
        }
    }
    void setType(String type){
        if(on){
            this.coffeeType=type;
        }
    }
    int getVolume(){return volume;}
    String getType(){return coffeeType;}
    boolean isOn(){return on;}
    public void pressOnOff(){on=!on;}
}
/*
A coffee maker has a selector for coffee type (normal/espresso) and a selector for coffee amount (10–80 ml).
It also has an on/off switch that behaves in the same way as TV on/off switch.
Coffee type and amount selectors behave like TV channel switch,
i.e., they can only be changed when the device is on,
and the device remembers the selections even when it is switched off.

CoffeeMaker class should not have any console input/output operations.
Create another class, CoffeeMakerDriver, that creates an instance of CoffeeMaker and
tests it by switching the device on, setting the coffee type and amount,
and switching the device off.
*/