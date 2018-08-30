import java.util.Scanner;
/**
 * @author : navin106
 */

public final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner inp = new Scanner(System.in);
		int a = inp.nextInt();
		int b = inp.nextInt();
		int[][] m1 = buildmat(a, b);
		int x = inp.nextInt();
		int y = inp.nextInt();
		int[][] m2 = buildmat(x, y);
		addmat(m1, m2);
	}
	/**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 * @param      b     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	/**
	 * { function_description }
	 *
	 * @param      a     { parameter_description }
	 * @param      b     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static int[][] empmatrix(final int a,final int b) {
		return new int[a][b];
	}
	public static int[][] buildmat(final int a,final int b) {
		Scanner inp1 = new Scanner(System.in);
		int[][] k = empmatrix(a, b);
		for (int i = 0; i < a; i++) {
			for (int j = 0; j < b; j++) {
				k[i][j] = inp1.nextInt();
			}
		}
		System.out.println(k);
		return k;
	}
	/**
	 * Constructs the object.
	 *
	 * @param      m1    The m 1
	 * @param      m2    The m 2
	 */
	public static void addmat(final int[][] m1,final int[][] m2) {
		int rowm1 = m1.length;
		int rowm2 = m2.length;
		int colm1 = m1[0].length;
		int colm2 = m2[0].length;
		if (rowm1 == rowm2  && colm1 == colm2) {
			int[][] empmatadd = buildmat(rowm1, colm1);
			for (int i = 0; i < rowm1; i++) {
				for (int j = 0; j < colm1; j++) {
					empmatadd[i][j] += m1[i][j] + m2[i][j];
				}
			}
			System.out.println(matout(empmatadd));
		} else {
			System.out.println("not possible");
		}

	}
	/**
	 * { function_description }
	 *
	 * @param      resmat  The resmat
	 *
	 * @return     { description_of_the_return_value }
	 */
	public static String matout(final int[][] resmat) {
		String mat = "";
		for (int i = 0; i < resmat.length; i++) {
			for (int j = 0; j < resmat[0].length; j++) {
				mat += resmat[i][j] + " ";
			}
			mat = mat.trim();
			mat +="\n";
		}
		return mat;
	}
}