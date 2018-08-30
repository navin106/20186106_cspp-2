import java.util.Scanner;
/**
 * @author :navin106.
 * finding factorial.
 */
public final class Factorial {
    /**
     * constructor.
     */
    private Factorial() {
    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the number to find the factorial");
        long fac = s.nextLong();
        System.out.println(fact(fac));
    }
    /**
     * returns factorial of a function.
     *
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static long fact(final long n) {
        if (n == 0) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }
}
