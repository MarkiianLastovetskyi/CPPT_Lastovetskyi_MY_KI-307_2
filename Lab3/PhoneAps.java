/**
 * Lab3 package
 */
package Lab_3_lahan;


import java.io.*;

/**
 * Phone Application class implements main method for Phone
 * class possibilities demonstration
 * @author roman
 * @version 1.0
 * @see Phone
 */

public class PhoneAps {

    public static void main(String[] args) throws FileNotFoundException {
        Phone xphone = new Phone(67);
        xphone.showCharge();
        //Call
        xphone.callTO("380673135428");
        xphone.showCharge();
        //make Picture
        xphone.makePicture();
        xphone.showCharge();
        //turn off camera
        xphone.turnOn_Off();
        //Make picture with turned off camera
        xphone.makePicture();
        //Change Volume
        xphone.clickUpButton();
        xphone.clickDownButton(7);
        //Invalid call
        xphone.callTO("1111111");
        xphone.showCharge();
        //End
        xphone.fileClose();

    }
}
