package Lab_3_lahan;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Lab_3_lahan.Phone;

public class Phone {
    private VolButton Button;
    private Battery Bat;
    private PrintWriter fout;
    private Camera Camera;

    public Phone() throws FileNotFoundException {
        Button = new VolButton();
        Bat = new Battery();
        Camera = new ConcreteCamera(); // Замінено на конкретну реалізацію абстрактного класу
        fout = new PrintWriter(new File("Log.txt"));
    }

    public Phone(int charge) throws FileNotFoundException {
        Button = new VolButton();
        Bat = new Battery(charge);
        Camera = new ConcreteCamera(); // Замінено на конкретну реалізацію абстрактного класу
        fout = new PrintWriter(new File("Log.txt"));
    }

    private static boolean isValid(String s) {
        Pattern p = Pattern.compile("380\\d{9}");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public void callTO(String phoneNumber) {
        if (isValid(phoneNumber)) {
            if (Bat.getBatteryCharge() >= 0) {
                System.out.println("You calling to :\n" + phoneNumber);
                long time1 = System.currentTimeMillis();
                System.out.println("To end call press Enter:");
                Scanner s = new Scanner(System.in);
                s.nextLine();
                s.close();
                long time2 = System.currentTimeMillis();

                System.out.println("Your call was in progress " + (time2 - time1) / 1000 + " seconds");

                Bat.setBatteryCharge((int) (Bat.getBatteryCharge() - (time2 - time1) / 30000));

                fout.println("You call to " + phoneNumber + "\t and spoke " + (time2 - time1) / 1000 + " seconds");

            } else {
                System.out.println("Your battery is drained");
            }
        } else {
            System.out.println("Wrong number");
        }
    }

    public void makePicture() {
        if (Camera.getState()) {
            if (Bat.getBatteryCharge() >= 0) {
                Bat.setBatteryCharge(Bat.getBatteryCharge() - 3);
                System.out.println("You make photo");
                fout.println("You made photo");

            } else
                System.out.println("Your battery is drained");

        } else
            System.out.println("Your camera is off");

    }

    public void turnOn_Off(){
        if(Camera.getState())
        {
            Camera.setState(false);
            System.out.println("Camera turn off");
        }
        else
        {
            Camera.setState(true);
            System.out.println("Camera turn on");
        }
    }

    public void clickUpButton() {
        Button.ClickUpButton();
        System.out.println("Volume = "+Button.getVolume());
        fout.println("Volume changed to "+Button.getVolume());
    }

    public void clickUpButton(int n) {
        for(int i =0;i<n;i++)
            Button.ClickUpButton();
        System.out.println("Volume = "+Button.getVolume());
        fout.println("Volume changed to "+Button.getVolume());
    }

    public void clickDownButton() {
        Button.ClickDownButton();
        System.out.println("Volume = "+Button.getVolume());
        fout.println("Volume changed to "+Button.getVolume());
    }

    public void clickDownButton(int n ) {
        for(int i =0;i<n;i++)
            Button.ClickDownButton();
        System.out.println("Volume = "+Button.getVolume());
        fout.println("Volume changed to "+Button.getVolume());
    }

    public void fileClose(){
        fout.close();
    }

    public void showCharge(){
        System.out.println("Charge : "+Bat.getBatteryCharge()+" %");
    }

    // Зробимо клас Camera абстрактним
    abstract class Camera {
        boolean state;

        public Camera() {
            state = true;
        }

        public Camera(boolean status) {
            state = status;
        }

        public boolean getState() {
            return state;
        }

        public void setState(boolean status) {
            state = status;
        }

        // Інші методи або оголошення, які ви хочете включити в абстрактний клас Camera
    }

    // Конкретна реалізація абстрактного класу Camera
    private class ConcreteCamera extends Camera {
        // Якщо потрібно, можете додати специфічну логіку для цієї конкретної реалізації абстрактного класу
    }
}

class Battery {
    private int BatteryCharge;
    private static final int Max_BatteryCharge = 100;
    private static final int Min_BatteryCharge = 0;

    public Battery() {
        BatteryCharge = 100;
    }

    public Battery(int num) {
        if (num > Max_BatteryCharge) {
            BatteryCharge = Max_BatteryCharge;
        } else BatteryCharge = Math.max(num, Min_BatteryCharge);
    }

    public void setBatteryCharge(int num) {
        if (num > Max_BatteryCharge) {
            BatteryCharge = Max_BatteryCharge;
        } else BatteryCharge = Math.max(num, Min_BatteryCharge);
    }

    public int getBatteryCharge() {
        return BatteryCharge;
    }
}

class VolButton {
    private static final int Min_Volume = 0;
    private static final int MAX_Volume = 10;
    private int Volume;

    public VolButton() {
        Volume = MAX_Volume;
    }

    public VolButton(int Vol) {
        if (Vol > MAX_Volume) {
            Volume = MAX_Volume;
        } else Volume = Math.max(Vol, Min_Volume);
    }

    public void ClickUpButton() {
        if (Volume != MAX_Volume)
            Volume++;
    }

    public void ClickDownButton() {
        if (Volume != Min_Volume)
            Volume--;
    }

    public int getVolume() {
        return Volume;
    }

    public void setVolume(int Vol) {
        if (Vol > MAX_Volume) {
            Volume = MAX_Volume;
        } else Volume = Math.max(Vol, Min_Volume);
    }
}
