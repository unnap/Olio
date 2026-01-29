package Assignment2dot1;

public class CarDriver {
    Car myCar = new Car("Toyota Corolla", 180,100);

    public CarDriver(){

    }
    void run() {
        //myCar.fillTank();
        boolean juokse = true;

        while(juokse) {
            Utili.separator1();
            System.out.println("LET'S DRIVE");
            Utili.separator2();
            System.out.println("1) Fill tank\n" +
                    "2) Let's go!\n" +
                    "3) Cruise control\n" +
                    "4) Exit");
            switch (Utili.getScanner().nextInt()) {
                case 1:
                    myCar.fillTank();
                    break;
                case 2:
                    System.out.println("Enter how far you want to go");
                    drive(Utili.getScanner().nextInt());
                    break;
                case 3:
                    myCar.cruiseControl();
                    break;
                default:
                    System.out.println("Let's not drive");
                    juokse = false;
            }
            if(juokse) {
                Utili.getScanner().nextLine();
                Utili.separator2();
                Utili.cont();
                Utili.getScanner().nextLine();
            }
        }
    }

    void drive(int distance){
        if(myCar.getGasolineLevel()>0) {
            for (int i = 0; i < distance && myCar.getGasolineLevel() > 0; i++) {
                Utili.separator2();
                myCar.accelerate();
                myCar.gasConsumption();
                System.out.printf("%s: speed is %.2f km/h\nGas left: %.2f\n",
                        myCar.getTypeName(),myCar.getSpeed(),myCar.getGasolineLevel());
                //System.out.println("Gas left: " + myCar.getGasolineLevel());
                //Utili.separator2();
            }

            while (myCar.getSpeed() > 0) {
                Utili.separator2();
                myCar.decelerate(15);
                myCar.gasConsumption();
                System.out.printf("%s: speed is %.2f km/h\nGas left: %.2f\n",
                        myCar.getTypeName(),myCar.getSpeed(),myCar.getGasolineLevel());

            }
        } else {
            System.out.println("OUT OF GAS");
        }
    }
}