import java.util.Scanner;

public class Solution {
    /*
    Do not modify this main function.
    */
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);      
        long base = s.nextLong();
        long exponent = s.nextLong();
        long result = power(base,exponent);
        System.out.println(result);
    }
    /*
    Need to write the power function and print the output.
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
