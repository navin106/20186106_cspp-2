import java.util.Scanner;
import java.util.Arrays;
/**
 * @author:navin106
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/* Fill the main function to print resultant of addition of matrices*/
	/**
	 * main method to add the two matrices.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String k = s.nextLine();
		int[] l = new int[k.length()];
		int i = 0;
		for (String a : k) {
			l[i] = Integer.parseInt(a);
			i++;
		}
		System.out.println(l);
	}
	public static int  mat(int a, int b) {
		return 0;
	}
}
