import java.util.Scanner;
/**
* @author Navin106
*/
public final class Solution {
  /**
    *Do not modify this main function.
    */
    public static final double NUM = 0.5;
  /**
    *Empty constructor.
    */
    private Solution() {

    }
    /**
    * @param args commandline argument.
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        System.out.println(areaOfTriangle(base, height));
    }
  /**
    *Need to fill the areaOfTriangle.
    *function and print the output of fahrenheit.
    *@param b variable
    *@param h variable
    *@return double type
    */
    public static double areaOfTriangle(final int b, final int h) {
        return b * h * NUM;
    }
}
