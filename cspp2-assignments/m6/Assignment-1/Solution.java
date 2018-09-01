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
		int[] a = new int[n];
		int l = 0;
		int cnt = 0;
		for (int i = 2; i <= n; i++ ) {
			cnt = 0;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					cnt += 1;
				}
			}
			if (cnt != 0) {
				a[l] = i;
				l++;
			}
		}
		for (int k = 0; k < a.length ; k++ ) {
			if (a[k] != 0 && a[k] % 2 != 0) {
				System.out.println(a[k]);
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

