import java.util.Scanner;
/**
 * @author: navin106.
 */
public class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { item_description }.
	 * @param : args
	 */
	public static void main(final String args[]) {

		Scanner s = new Scanner(System.in);

		String input = s.next();

		InputValidator i = new InputValidator(input);

		System.out.println(i.validateData());
	}
}
