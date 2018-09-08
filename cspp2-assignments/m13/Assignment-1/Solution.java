import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Navin106
 */
class Set {
    /**
     * { var_description }.
     */
    private final int num = 10;
    /**
     * { var_description }.
     */
    private int[] adtlist;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Set() {
        adtlist = new int[num];
        size = 0;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == adtlist[i]) {
                return true;
            }

        }
        return false;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "{";
        if (size == 0) {
            return "{}";
        } else {
            for (int i = 0; i < size - 1; i++) {
                str += adtlist[i] + ", ";
            }
            str += adtlist[size - 1] + "}";
        }
        return str;

    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (item == adtlist[i]) {
                cnt++;
            }
        }
        if (cnt == 0) {
            adtlist[size] = item;
            size++;
        }
    }
    /**
     * { function_description }.
     *
     * @param      items  The items
     */
    public void add(final int[] items) {
        for (int i = 0; i < items.length; i++) {
            if (size > adtlist.length / 2) {
                resize();
            }
            add(items[i]);
        }
    }
    /**
     * { function_description }.
     */
    public void resize() {
        adtlist = Arrays.copyOf(adtlist, adtlist.length * 2);
    }
    /**
     * { function_description }.
     *
     * @param      newSet  The new set
     *
     * @return     { description_of_the_return_value }
     */
    public Set intersection(final Set newSet) {
        Set intersection = new Set();
        int[] temp = newSet.adtlist;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < temp.length; j++) {
                if (adtlist[i] == temp[j]) {
                    intersection.add(adtlist[i]);
                }
            }
        }
        return intersection;
    }
    /**
     * { function_description }.
     *
     * @param      newArray  The new array
     *
     * @return     { description_of_the_return_value }
     */
    public Set retainAll(final int[] newArray) {
        Set retainAll = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < newArray.length; j++) {
                if (adtlist[i] == newArray[j]) {
                    retainAll.add(adtlist[i]);
                }
            }
        }
        return retainAll;
    }
    /**
     * { function_description }.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        return adtlist[index];
    }
    /**
     * { function_description }.
     *
     * @param      newArray  The new array
     *
     * @return     { description_of_the_return_value }
     */
    public int[][] cartesianProduct(final Set newArray) {
        int k = this.size * newArray.size();
        int cnt = 0;
        int[][] result = new int[k][2];
        if (this.size == 0 || newArray.size() == 0) {
            return null;
        } else {
            int m = 0;
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < newArray.size; j++) {
                    if (m < k) {
                        result[m][0] = adtlist[i];
                        result[m][1] = newArray.get(j);
                        m += 1;
                    }
                }
            }

        }
        return result;
    }

}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
               .mapToInt(Integer::parseInt)
               .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        Set s = new Set();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list //
            //operation invoke the corresponding method
            switch (tokens[0]) {
            case "size":
                System.out.println(s.size());
                break;
            case "contains":
                System.out.println(s.contains(
                                Integer.parseInt(tokens[1])));
                break;
            case "print":
                System.out.println(s);
                break;
            case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
            case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(
                    Arrays.deepToString(s.cartesianProduct(t)));
                break;
            default:
                break;
            }
        }
    }
}
