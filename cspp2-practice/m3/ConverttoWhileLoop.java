/**
*@author:navin106.
*/
public final class ConverttoWhileLoop {
    /**
    *constructor.
    */
    private ConverttoWhileLoop() {

    }
    /**
    *num is constant for while condition.
    */
    public static final int NUM = 10;
    /**
    *main function.
    *@param args command line argument.
    */
    public static void main(final String[] args) {
        int i = 2;
        while (i <= NUM) {
            System.out.println(i);
            i = i + 2;
        }
        System.out.println("GoodBye!");
    }

}
