public class Calculate {
    public double calc(double x){

        //13. y=sin(x)/ctg(8x)
        double rad=x*Math.PI/180;
        double y;

        try{

            y=Math.sin(rad)/Math.atan(8*rad);
            if(y== Double.NEGATIVE_INFINITY || y==Double.POSITIVE_INFINITY || y==Double.NaN || Math.abs((8*x)%180)==0||Math.abs((8*x)%180)==90)
                throw new ArithmeticException();
        }

        catch(ArithmeticException e){
            if(Math.abs((8*x)%180)==0)
                throw new CalcException("Exception reason: Illegal value of X for cotangent calculation");
            else if(Math.abs((8*x)%180)==90)
                throw new CalcException("Exception reason: divide by zero");
            else
                throw new CalcException("Exception reason: Unknown reason of the exception during exception calculation");



        }
        return y;
    }

}
