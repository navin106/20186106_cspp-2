
import java.util.Scanner;
/**
    Do not modify this main function.
    @author : navin106
    */
public final class Solution {
/**
*constructor.
*/
    private Solution() {

    }
    /**
    *@param args command line argument.
    */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        int gcd = gcd(n1, n2);
        System.out.println(gcd);
    }
    /**
    *Need to write the gcd function and print the output.
    *@param n1 is integer.
    *@param n2 is integer.
    *@return int
    */
    public static int gcd(final int n1, final int n2) {
        if (n1 == 0 || n2 == 0) {
            return 0;
        }
        if (n1 == n2) {
            return n1;
        }
        if (n1 > n2) {
            return gcd(n1 - n2, n2);
        } else {
            return gcd(n1, n2 - n1);
        }
    }
}
