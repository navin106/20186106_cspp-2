import java.util.Scanner;
/**
 * Write a java program to round the elements of a matrix to the nearest 100.
 *
 * @author     :
 */
final class Solution {
    /**
     * check num.
     */
    public static final int NUM1 = 50;
    /**
     * replace num.
     */
    public static final int RNUM1 = 100;
    /**
     * { var_description }
     */
    public static final int Two = 2;
    /**
     * { var_description }.
     */
    public static final int Three = 3;
    /**
     * { var_description }.
     */
    public static final int Four = 4;
    /**
     * { var_description }.
     */
    public static final int Five = 5;
    /**
     * { var_description }.
     */
    public static final int Seven = 7;
    /**
     * { var_description }.
     */
    public static final int Nine = 9;


    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    static int[][] roundHundred(final int[][] a,
                                final int rows, final int columns) {

        // write ypur code here
        int[][] temp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (a[i][j] < NUM1) {
                    temp[i][j] = 0;
                } else if (a[i][j] < Three * NUM1) {
                    temp[i][j] = RNUM1;
                } else if (a[i][j] < Five * NUM1) {
                    temp[i][j] = Two * RNUM1;
                } else if (a[i][j] < (Seven * NUM1)) {
                    temp[i][j] = Three * RNUM1;

                } else if (a[i][j] < Nine * NUM1) {
                    temp[i][j] = Four * RNUM1;

                } else {
                    temp[i][j] = Five * RNUM1;
                }
            }
        }
        return temp;

    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
