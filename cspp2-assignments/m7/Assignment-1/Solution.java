import java.util.Scanner;

public class Solution {
	private Solution() {

	}

	public static void main(String args[]) {

		Scanner s = new Scanner(System.in);

		String input = s.next();

		InputValidator i = new InputValidator(input);
		
		System.out.println(i.validateData());
	}
}
