import java.util.Scanner;
/**
 * @author:navin106
 */
public final class Concatinate {
	/**
	 * private function
	 */
	private Concatinate() {

	}
	/**
	 * main fucntion
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner s = new Scanner(System.in);
		String n = "Hello";
		System.out.println("enter the string");
		String k = s.nextLine();
		System.out.println(n+" "+k);
	}
}
