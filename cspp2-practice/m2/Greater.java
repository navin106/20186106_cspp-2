import java.util.Scanner;
/**
 * @author :navin106.
 * finding the greater number
 */
public final class Greater {
    /**
     * constructor.
     */
    private Greater() {

    }
    /**
     * fucntion to find greater number.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner k = new Scanner(System.in);
        System.out.println("enter number a");
        int numa = k.nextInt();
        System.out.println("enter number b");
        int numb = k.nextInt();
        System.out.println("enter number c");
        int numc = k.nextInt();
        if (numa > numb) {
            if (numa > numc) {
                System.out.println("numa is greater");
            } else {
                System.out.println("numc is greater");
                }
        } else {
            System.out.println("numb is greater");
        }
    }
}
