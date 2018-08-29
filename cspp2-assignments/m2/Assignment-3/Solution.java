import java.util.Scanner;
/**
*@author:navin106.
*/
public final class Solution {
    /**
    *private method.
    */
    private Solution() {

    }
    /**
    *@param args for command line input.
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        long base = s.nextLong();
        long exponent = s.nextLong();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    *Need to write the power function and print the output.
    *@param a for base
    *@param b for exponent
    *@return the result of power
    */
    public static long power(final long a, final long b) {
        if (b == 0) {
            return 1;
        }
        else {
            return (a * power(a, b - 1));
        }
    }
}
