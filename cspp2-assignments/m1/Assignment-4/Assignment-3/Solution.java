import java.util.Scanner;
/**
*@author:navin106.
*date:28-08-2018
*/
public final class  Solution {
    /**
    *constants.
    */
    public static final double NUM = 0.5556;
    /**
    *constants.
    */
    public static final double NUM1 = 32;
    /**
      *Do not modify this main function.
      */
    private Solution() {

    }
    /**
    *@param args for command line argument main method.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        System.out.println(calculateFromDegreesToFarenheit(degreesCelsius));
    }
    /**
    Need to fill the calculateFromDegrees\
    ToFarenheit function and print the output.
    of fahrenheit.
    */
    /**
    @param d arg for the method.
    @return int to main method.
    */
    public static double calculateFromDegreesToFarenheit(final double d) {
        return (d - NUM1) * NUM;
    }
}
