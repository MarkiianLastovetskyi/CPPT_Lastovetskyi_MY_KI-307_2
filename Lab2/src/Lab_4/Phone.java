package Lab_4;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;

/**
 * Class <code>Phone</code> implements phone
 * @author roman
 * @version 1.0
 */
public abstract class Phone {
    protected VolButton Button;
    protected Battery Bat;
    protected PrintWriter     fout;
    protected Camera Camera;

    /**
     * Constructor
     *
     * @throws FileNotFoundException the file not found exception
     */
    public Phone() throws FileNotFoundException {
        Button = new VolButton();
        Bat = new Battery();
        Camera = new Camera();
        fout = new PrintWriter(new File("Log.txt"));
    }

    /**
     * Constructor
     *
     * @param charge the Battery Charge value
     * @throws FileNotFoundException the file not found exception
     */
    public Phone(int charge) throws FileNotFoundException {
        Button = new VolButton();
        Bat = new Battery(charge);
        Camera = new Camera();
        fout = new PrintWriter(new File("Log.txt"));
    }

    /**
     * Method checks if the phone number is correct
     * @param s the phone number
     * @return is phone number Valid
     */
    private static boolean isValid(String s) {
        Pattern p = Pattern.compile("380\\d{9}");
        Matcher m = p.matcher(s);
        return (m.matches());
    }

    /**
     * Method calls the phone number
     *
     * @param phoneNumber the Phone number
     */
    public void callTO(String phoneNumber) {
        //Is phone number correct
        if (isValid(phoneNumber)) {
            //is phone battery charged
            if (Bat.getBatteryCharge() >= 0) {
                //Start calling
                System.out.println("You calling to :\n" + phoneNumber);
                //Time in start calling
                long time1 = System.currentTimeMillis();
                //End call
                System.out.println("To end call press Enter:");
                Scanner s = new Scanner(System.in);
                s.nextLine();
                s.close();
                //Time in end calling
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

    /**
     * Method make picture on camera
     */
    public void makePicture() {

        if (Camera.getState()) {
            // camera on

            if (Bat.getBatteryCharge() >= 0) {
                // battery charged
                Bat.setBatteryCharge(Bat.getBatteryCharge() - 3);
                System.out.println("You make photo");
                fout.println("You made photo");

            } else
                // battery is not charged
                System.out.println("Your battery is drained");

        } else
            // camera off

            System.out.println("Your camera is off");

    }

    /**
     * Method changes the state of camera to opposite
     */
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

    /**
     * Method click on upper volume button
     */
    public void clickUpButton()
    {

        Button.ClickUpButton();
        System.out.println("Volume = "+Button.getVolume());
        fout.println("Volume changed to "+Button.getVolume());

    }

    /**
     * Method click on upper volume button n times
     *
     * @param n the n
     */
    public void clickUpButton(int n)
    {   for(int i =0;i<n;i++)
        Button.ClickUpButton();
        System.out.println("Volume = "+Button.getVolume());
        fout.println("Volume changed to "+Button.getVolume());
    }

    /**
     * Method click on lower volume button
     */
    public void clickDownButton()
    {
        Button.ClickDownButton();
        System.out.println("Volume = "+Button.getVolume());
        fout.println("Volume changed to "+Button.getVolume());
    }

    /**
     * Method click on lower volume button n times
     *
     * @param n the n
     */
    public void clickDownButton(int n )
    {   for(int i =0;i<n;i++)
        Button.ClickDownButton();
        System.out.println("Volume = "+Button.getVolume());
        fout.println("Volume changed to "+Button.getVolume());
    }

    /**
     * Method close file
     */
    public void fileClose(){fout.close();}

    /**
     * Method print in console phone charge
     */
    public void showCharge(){
        System.out.println("Charge : "+Bat.getBatteryCharge()+" %");
    }



}

/**
 * Class <code>Battery</code> implements phone  battery
 */
class Battery {
    private int BatteryCharge;
    private static final int Max_BatteryCharge = 100;
    private static final int Min_BatteryCharge = 0;

    /**
     * Constructor
     */
    public Battery() {
        BatteryCharge = 100;
    }

    /**
     * Constructor
     *
     * @param num the Battery Charge value
     */
    public Battery(int num) {
        if (num > Max_BatteryCharge) {
            BatteryCharge = Max_BatteryCharge;
        } else BatteryCharge = Math.max(num, Min_BatteryCharge);

    }

    /**
     * Method set Battery Charge value in range[Min_BatteryCharge,Max_BatteryCharge]
     *
     * @param num the Battery Charge value
     */
    public void setBatteryCharge(int num) {
        if (num > Max_BatteryCharge) {
            BatteryCharge = Max_BatteryCharge;
        } else BatteryCharge = Math.max(num, Min_BatteryCharge);
    }

    /**
     * Method return Battery Charge value
     *
     * @return the Battery Charge value
     */
    public int getBatteryCharge() {
        return BatteryCharge;
    }
}

/**
 * Class <code>Camera</code> implements camera
 */
class Camera {
    /**
     * The State.
     */
    boolean state;

    /**
     * Constructor
     */
    public Camera() {
        state = true;
    }

    /**
     * Constructor
     *
     * @param status the status
     */
    public Camera(boolean status) {
        state = status;
    }

    /**
     * Method returns Camera State
     *
     * @return the camera state
     */
    public boolean getState() {
        return state;
    }

    /**
     * Method set Camera state
     *
     * @param status the status
     */
    public void setState(boolean status) {
        state = status;
    }



}

/**
 * Class <code>VolButton</code> implements Volume button
 */
class VolButton {
    private static final int Min_Volume = 0;
    private static final int MAX_Volume = 10;
    private int Volume;

    /**
     * Constructor
     */
    public VolButton() {
        Volume = MAX_Volume;

    }

    /**
     * Constructor
     *
     * @param Vol Volume in range[Min_Volume,Max_Volume]
     */
    public VolButton(int Vol) {
        if (Vol > MAX_Volume) {
            Volume = MAX_Volume;
        } else Volume = Math.max(Vol, Min_Volume);
    }

    /**
     * Method Simulate increasing Volume by 1 in range[Min_Volume,Max_Volume]
     */
    public void ClickUpButton() {
        if (Volume != MAX_Volume)
            Volume++;
    }

    /**
     * Method Simulate decreasing Volume by 1 in range[Min_Volume,Max_Volume]
     */
    public void ClickDownButton() {
        if (Volume != Min_Volume)
            Volume--;

    }

    /**
     * Method returns Value of Volume
     *
     * @return Volume volume
     */
    public int getVolume() {
        return Volume;
    }

    /**
     * Method set Volume in range[Min_Volume,Max_Volume]
     *
     * @param Vol the Volume value
     */
    public void setVolume(int Vol) {
        if (Vol > MAX_Volume) {
            Volume = MAX_Volume;
        } else Volume = Math.max(Vol, Min_Volume);
    }

}