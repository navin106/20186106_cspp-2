
import java.lang.Math;
import java.util.Scanner;
// Given an String, Write a java method that returns the decimal value for the given binary string.
public class Solution {
	/*
	Do not modify this main function.
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i <= n; i++) {
			String s = sc.nextLine();
			String res = binaryToDecimal(s); //Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static String binaryToDecimal(String s) {
		int i = s.length();
		System.out.println(i);
		int sum = 0;
		String k = " ";
		System.out.println(s.toCharArray());
		for (char a : s.toCharArray()) {
			if (a == '1') {
				sum += Math.pow(2, i);
				System.out.println(a);
			}
			i--;
		}
		k = k + sum;
		return k.trim();
	}
}