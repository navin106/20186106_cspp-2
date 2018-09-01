import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
	/**
	* Empty constructor.
	*/
	private Solution() {
		//not used
	}
	/**
	 * Prints the odd composite numbers between 2 and n.
	 *
	 * @param      n     n value
	 */
	public static void oddComposites(final int n) {
		// write your code here
		int cnt = 0;
		          int[] a = new int[n];
		for (int i = 0; i < n ; i++ ) {
			for (int j = 2; j < i ; j++) {
				if (n % i == 0) {
					cnt += 1;
				}
				if (cnt == 2) {
					a[j] = i;
					j++;
				}
			}

		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0 && a[i] > 0) {
				System.out.println(a[i]);
			}
		}

	}
	/**
	* main method as driver program.
	* @param args is the parameter for this method
	*/
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		oddComposites(n);
	}
}

