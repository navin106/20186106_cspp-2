import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author :
 */
final class Solution {
    public static final int NUM1 = 50;
    public static final int NUM2 = 150;
    public static final int NUM3 = 250;
    public static final int NUM4 = 350;
    public static final int NUM5 = 450;
    public static final int RNUM1 = 100;
    public static final int RNUM2 = 200;
    public static final int RNUM3 = 300;
    public static final int RNUM4 = 400;

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
    static int[][] roundHundred(final int[][] a, final int rows, final int columns) {

        // write ypur code here
        int[][] temp = new int[rows][columns];
        for (int i = 0; i < rows ; i++ ) {
            for (int j = 0; j < columns ; j++) {
                if (a[i][j] < NUM1) {
                    temp[i][j] = 0;
                } else if (a[i][j] < NUM2) {
                    temp[i][j] = RNUM1;
                } else if (a[i][j] < NUM3) {
                    temp[i][j] = RNUM2;
                } else if (a[i][j] < NUM4) {
                    temp[i][j] = RNUM3;

                } else if (a[i][j] < NUM5) {
                    temp[i][j] = RNUM4;

                } else {
                    temp[i][j] = 500;
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