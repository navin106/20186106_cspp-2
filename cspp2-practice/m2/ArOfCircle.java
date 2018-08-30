import java.util.Scanner;
/**
 * @author:navin106.
 * area of circle.
 */
public final class ArOfCircle {
    /**
     * pi value.
     */
    private static final double PI = 3.14159;
    /**
     * constructor of class.
     */
    private ArOfCircle() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter radius of circle");
        int rad = input.nextInt();
        /*System.out.println(PI);*/
        double res = PI * rad * rad;
        System.out.println(res);

    }
}
