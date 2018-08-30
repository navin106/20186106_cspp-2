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
     * Creates a matrix.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static int[][] buildmat(final int a, final int b) {
        return new int[a][b];
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
        int[][] matrix = buildmat(a, b);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                matrix[i][j] = inp.nextInt();
            }
        }
        return matrix;
    }

    /**
     * Adds a matrix.
     *
     * @param      matrix1  The matrix 1
     * @param      matrix2  The matrix 2
     */
    public static void matadd(final int[][] matrix1, final int[][] matrix2) {
        if (rowlen(matrix1) == rowlen(matrix2)
                    && collen(matrix1) == collen(matrix2)) {
            int[][] sumMatrix = buildmat(rowlen(matrix1),
                                            collen(matrix1));
            for (int i = 0; i < rowlen(sumMatrix); i++) {
                for (int j = 0; j < collen(sumMatrix); j++) {
                    sumMatrix[i][j] += matrix2[i][j] + matrix1[i][j];
                }
            }
            System.out.println(matout(sumMatrix));
        } else {
            System.out.println("not possible");
        }
    }

    /**
     * Gets the row size.
     *
     * @param      matrix  The matrix
     *
     * @return     The row size.
     */
    public static int rowlen(final int[][] matrix) {
        return matrix.length;
    }

    /**
     * Gets the column size.
     *
     * @param      matrix  The matrix
     *
     * @return     The column size.
     */
    public static int collen(final int[][] matrix) {
        return matrix[0].length;
    }

    /**
     * { function_description }.
     *
     * @param      matrix  The matrix
     *
     * @return     { description_of_the_return_value }
     */
    public static String matout(final int[][] matrix) {
        String temp = "";
        for (int i = 0; i < rowlen(matrix); i++) {
            for (int j = 0; j < collen(matrix); j++) {
                temp += matrix[i][j] + " ";
            }
            temp = temp.trim();
            temp += "\n";
        }
        return temp;
    }
}
