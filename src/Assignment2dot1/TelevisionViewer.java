package Assignment2dot1;

public class TelevisionViewer {
    static void watch() {
        Television myTV = new Television();
        myTV.setChannel(1);

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (!myTV.isOn())
                myTV.pressOnOff();

            while (!tired) {
                System.out.println("Watching channel " + myTV.getChannel());
                myTV.setChannel(myTV.getChannel() + 1);
                if (myTV.getChannel() % 4 == 0)
                    tired = true;
            }

            myTV.pressOnOff();
            myTV.setChannel(3);
            System.out.println("channel is on "+myTV.getChannel());
            System.out.println("Falling asleep");
        }
    }
}