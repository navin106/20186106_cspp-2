import java.util.Scanner;
/**
*name:navin106.
*rollno and name.
*/
public final class Solution {
    /**
    *constructor.
    */
    private Solution() {

    }
    /**@param args command line argument*/
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String rollno = input.nextLine();
        System.out.println("Name : ," + name
            + " Roll Number : " + rollno);
    }
}
