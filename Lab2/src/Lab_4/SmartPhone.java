package Lab_4;

import java.io.FileNotFoundException;
import java.time.*;
import java.io.*;

public class SmartPhone extends Phone implements InterfaceSmartphone {
    private String userName;
    public SmartPhone(int charge) throws FileNotFoundException {
        super(charge);
    }
    public SmartPhone(int charge,String name) throws FileNotFoundException{
        super(charge);
        System.out.println("Object created");
        this.userName=name;
    }
    @Override
    public void makePicture() {

        if (super.Camera.getState()) {
            // camera on

            if (super.Bat.getBatteryCharge() >= 0) {
                // battery charged
                super.Bat.setBatteryCharge(Bat.getBatteryCharge() - 3);
                System.out.println("You make good photo");
                super.fout.println("You made good photo");

            } else
                // battery is not charged
                System.out.println("Your battery is drained");

        } else
            // camera off

            System.out.println("Your camera is off");

    }

    @Override
    public void surfingNet(int sec) {
        System.out.println("You surfing in internet  "+sec+" seconds");
    }

    @Override
    public void showTime() {
        LocalTime obj=LocalTime.now();
        System.out.println("Time :"+obj);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getConstant(){
        return constant;
    }

}