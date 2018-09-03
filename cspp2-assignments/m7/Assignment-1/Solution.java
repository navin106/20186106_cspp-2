import java.util.Scanner;
/**
 * @author: navin106.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }


    
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);

        String input = s.next();

        InputValidator i = new InputValidator(input);

        System.out.println(i.validateData());
    }
}
