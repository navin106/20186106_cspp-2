
import java.util.Scanner;
/*
	Do not modify this main function.
	*/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
	public static int d = 7;
    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);      
        int n = s.nextInt();
        int cnt = 0;
        for(int i = d; i <= n; i++) {
        	for (char a : (String.valueOf(i)).toCharArray()) {
        		if (a == '7') {
        			cnt += 1;
        		}
        	}

        }
    System.out.println(cnt);
        
    }
}