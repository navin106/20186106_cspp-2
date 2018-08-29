import java.util.Scanner;
/**
*@author:navin106.
*/
public final class SumOfNNumbers {
    /**
    *constructor.
    */
    private SumOfNNumbers() {

    }
    /**
    *main function.
    *@param args command line argument.
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int no = s.nextInt();
        int k = (no * (no + 1)) / 2;
        System.out.println(k);
    }

}
