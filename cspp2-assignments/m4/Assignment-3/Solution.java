
import java.lang.Math;
import java.util.Scanner;
// Given an String, Write a java method that returns the decimal value for the given binary string.
public class Solution {
    /*
    Do not modify this main function.
    */
    private Solution() {

    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String res = binaryToDecimal(s); //Write binaryToDecimal function
            System.out.println(res);
        }
    }
    /**
     * { function_description }
     *
     * @param      s     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static String binaryToDecimal(String s) {
        int i = s.length() - 1;
        int sum = 0;
        String k = " ";
        for (char a : s.toCharArray()) {
            if (a == '1') {
                sum += Math.pow(2, i);
            }
            i--;
        }
        k = k + sum;
        return k.trim();
    }
}
