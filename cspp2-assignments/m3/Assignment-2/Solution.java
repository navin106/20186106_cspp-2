
import java.util.Scanner;
/**
*@author:navin106
*Do not modify this main function.
*/
public final class Solution {
/**
*Fill the main function to print the number of 7's between 1 to n.
*/
    private Solution() {

    }
    /**
    * d is a integer.
    */
    private static final int D = 7;
    /**
    * k is a character.
    */
    private static final char K = '7';
    /**
    *@param args for command line argument.
    */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int cnt = 0;
        for (int i = D; i <= n; i++) {
            for (char a : (String.valueOf(i)).toCharArray()) {
                if (a == K) {
                    cnt += 1;
                }
            }

        }
    System.out.println(cnt);
    }
}
