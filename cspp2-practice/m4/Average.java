import java.util.Scanner;
/**
 * @author:navin106
 */
public final class Average {
	/**
	 * private function
	 */
	private Average() {

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
		int sum = 0;
		System.out.println("enter the numbers");
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
			sum += arr[i];
		}
		System.out.println(sum/n);
	}
}
