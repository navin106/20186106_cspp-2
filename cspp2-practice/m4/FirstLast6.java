import java.util.Scanner;
/**
 * @author:navin106
 */
public final class FirstLast6 {
	/**
	 * private function
	 */
	private FirstLast6() {

	}
	/**
	 * main fucntion
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("enter the no of elements you want to enter");
		int n = s.nextInt();
		System.out.println("enter the numbers");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		if (arr[0] == 6 || arr[n - 1] == 6) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
}
