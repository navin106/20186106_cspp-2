/**
*date:21-08-2018.
*author: navin106.
*swap class.
*/
public final class Swap {
    /**
    * private constructor.
    */
    private Swap() {

    }
    /**
    * @param args for command line argument.
    */
    public static void main(final String[] args) {
    int a = 40;
    int b = 58;
    a = a + b;
    b = a - b;
    a = a - b;
    System.out.println("a =" + a + "," + "b =" + b);
    }
}
