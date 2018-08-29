import java.util.Scanner;
/**
*@author:navin106.
*/
public final class Pattern {
    /**
    *constructor.
    */
    private Pattern() {

    }
    /**
    *main function.
    *@param args command line argument.
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

}
