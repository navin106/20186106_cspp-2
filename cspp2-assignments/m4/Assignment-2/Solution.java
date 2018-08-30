import java.util.Scanner;
/**
 * Class for solution.
 * @author navin106
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner inp = new Scanner(System.in);
        matadd(matinp(inp), matinp(inp));
    }
    /**
     * Gets the row size.
     *
     * @param      mat  The mat
     *
     * @return     The row size.
     */
    public static int rowlen(final int[][] mat) {
        return mat.length;
    }
    /**
     * Gets the column size.
     *
     * @param      mat  The mat
     *
     * @return     The column size.
     */
    public static int collen(final int[][] mat) {
        return mat[0].length;
    }
    /**
     * { function_description }.
     *
     * @param      inp  The inp
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] matinp(final Scanner inp) {
        int a = inp.nextInt();
        int b = inp.nextInt();
        int[][] mat = buildmat(a, b);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                mat[i][j] = inp.nextInt();
            }
        }
        return mat;
    }
    /**
     * Adds a mat.
     *
     * @param      m1  The mat 1
     * @param      m2  The mat 2
     */
    public static void matadd(final int[][] m1, final int[][] m2) {
        if (rowlen(m1) == rowlen(m2)
                    && collen(m1) == collen(m2)) {
            int[][] sumMatrix = buildmat(rowlen(m1),
                                            collen(m1));
            for (int i = 0; i < rowlen(sumMatrix); i++) {
                for (int j = 0; j < collen(sumMatrix); j++) {
                    sumMatrix[i][j] += m2[i][j] + m1[i][j];
                }
            }
            System.out.println(matout(sumMatrix));
        } else {
            System.out.println("not possible");
        }
    }
    /**
     * { function_description }.
     *
     * @param      mat  The mat
     *
     * @return     { description_of_the_return_value }
     */
    public static String matout(final int[][] mat) {
        String temp = "";
        for (int i = 0; i < rowlen(mat); i++) {
            for (int j = 0; j < collen(mat); j++) {
                temp += mat[i][j] + " ";
            }
            temp = temp.trim();
            temp += "\n";
        }
        return temp;
    }
    /**
     * Creates a mat.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] buildmat(final int a, final int b) {
        return new int[a][b];
    }
}



