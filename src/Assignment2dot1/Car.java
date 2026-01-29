package Assignment2dot1;

public class Car {
    private double speed;
    private double gasolineLevel;
    private String typeName;
    private double tankCapacity;
    private double maxSpeed;
    private double acceleration;
    private double currentMaxSpeed;
    private final double cruiseMinSpeed = 40;
    private final double cruiseMaxSpeed = 130;
    private double tarSpeed;
    private boolean cruiseOn;

    public Car(String typeName, double maxSpeed, double tankCapacity) {
        this.speed = 0;
        this.acceleration = 10;
        this.gasolineLevel = 0;
        this.typeName = typeName;
        this.maxSpeed = maxSpeed;
        this.currentMaxSpeed = maxSpeed;
        //this.cruiseMinSpeed = 40;
        //this.currentMaxSpeed = 130;
        this.tankCapacity = tankCapacity;
        this.cruiseOn = false;
    }
    public void gasConsumption(){
        double gasCon = 0.5+speed*0.02;
        gasolineLevel = Math.max(0,gasolineLevel-gasCon);
        System.out.printf("GAS CONSUMPTION: %.2f\n",gasCon);
    }
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed = Math.min(currentMaxSpeed, speed + acceleration);
            //gasConsumption();
        } else {
            System.out.println("TANK EMPTY");
            decelerate(15);
        }
    }
    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            speed = Math.max(0, speed - amount);
            //gasConsumption();
        } else {
            speed = Math.max(0,speed-(amount*2));
        }
    }

    void cruiseControl(){
        if(!cruiseOn){
            System.out.println("Enter desired cruise speed");
            double speedEnter = Utili.getScanner().nextDouble();
            if(speedEnter>=cruiseMinSpeed&&speedEnter<=cruiseMaxSpeed){
                cruiseOn=true;
                currentMaxSpeed=speedEnter;
                System.out.println("Cruise turned on");
            } else {
                System.out.printf("Please set speed between %.0fkm/h - %.0fkm/h\n",
                        cruiseMinSpeed,cruiseMaxSpeed);
            }
        }else{
            cruiseOn=false;
            currentMaxSpeed=maxSpeed;
            System.out.println("Cruise turned off");
        }
    }

    double getSpeed() {return speed;}
    double getMaxSpeed() {return maxSpeed;}
    double getTankCapacity() {return tankCapacity;}
    double getGasolineLevel() {return gasolineLevel;}
    String getTypeName() {return typeName;}
    void fillTank() {
        gasolineLevel = tankCapacity;
        System.out.println("Tank filled");
    }

}