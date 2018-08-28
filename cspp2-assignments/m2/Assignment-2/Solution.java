import java.util.Scanner;

public class Solution {
	/**
	*Do not modify this main function.
	*/
	private Solution() {

	}
	/**
	*@param args for command line input
	*/
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/**
	Need to write the rootsOfQuadraticEquation \
	function and print the output.
	*/
	/**
    *Need to write the rootsOfQuadraticEquation function and print the output.
    *@param x int
    *@param y int
    *@param z int
    */
    public static void rootsOfQuadraticEquation(final int x,final int y, final int z) {
        double d = (y * y) - (2 * 2 * x * z);
        double qua = Math.sqrt(d);
        double r1 = ((-y + qua) / (2 * x));
        double r2 = ((-y - qua) / (2 * x));
        System.out.println(r1 + " " + r2);
    }
}
