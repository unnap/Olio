package Assignment2dot1;

public class Television{
    private int channel = 1;
    private boolean on = false;

    int getChannel(){return channel;}
    public void setChannel(int chan){
        if(on) {
            if (chan < 1) {
                channel = 10;
            } else if (chan > 10) {
                channel = 1;
            } else {
                channel = chan;
            }
        }
    }
    boolean isOn(){return on;}
    public void pressOnOff(){on=!on;}
}