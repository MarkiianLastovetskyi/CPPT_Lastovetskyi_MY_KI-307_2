import java.util.*;
import java.io.*;
import static java.lang.System.out;
public class Main{


    public static void main(String[] args)
    {

        try
        {
            PrintWriter fout = new PrintWriter("Log.txt");
            double x;
            try
            {
                try
                {
                    Calculate calculate = new Calculate();
                    out.print("Enter X: ");
                    Scanner in = new Scanner(System.in);
                    x=in.nextDouble();

                    out.println("y = "+calculate.calc(x));
                    fout.print(calculate.calc(x));

                }
                finally
                {

                    fout.flush();
                    fout.close();
                }
            }
            catch (CalcException ex)
            {

                out.print(ex.getMessage());
            }
        }
        catch (FileNotFoundException ex)
        {

            out.print("Exception reason: Perhaps wrong file path");
        }
    }
}
