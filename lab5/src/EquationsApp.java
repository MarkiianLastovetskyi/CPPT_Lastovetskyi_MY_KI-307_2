import java.io.IOException;

public class EquationsApp {
    public static void main(String[] args) {
        CalculateTheEquation calc = new CalculateTheEquation();
        try {
            calc.readResultFromBin("src/bin.bin");
            System.out.println("Result of calculation: " + calc.doCalculation());
            calc.writeResultToBin("src/bin.bin");
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            calc.readResultFromTxt("src/txt.txt");
            System.out.println("Result of calculation: " + calc.doCalculation());
            calc.writeResultToTxt("src/txt.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
