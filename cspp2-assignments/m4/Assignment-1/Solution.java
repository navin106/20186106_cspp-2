import java.util.*;
/**
 * Class for solution.
 * @author:navin106
 */
public final class Solution
{/**
    Fill this main function to print maximum of given array.
    */
    private static int temp = 0;
    private Solution () {
        
    }
    /**
     * main method to print largest number in the array.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (temp < arr[i]) {
                temp = arr[i]; 
            }
        }
        System.out.println(temp);

    }
}
