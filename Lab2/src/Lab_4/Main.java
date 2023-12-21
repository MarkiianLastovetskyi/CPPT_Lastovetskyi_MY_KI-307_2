package Lab_4;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SmartPhone phone1=new SmartPhone(66,"User1");

        phone1.showTime();
        phone1.callTO("380673135428");

        phone1.makePicture();
        phone1.surfingNet(15);


        Phone phone2=new SmartPhone(66,"User2");
    }
}