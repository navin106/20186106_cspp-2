import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for sorted set.
 */
class SortedSet extends Set {
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (item == adtlist[i]) {
                return i;
            }
        }
        return -1;
    }
    /**
     * { function_description }.
     *
     * @param      fromElement  The from element
     * @param      toElement    To element
     *
     * @return     { description_of_the_return_value }
     */
    public int[] subSet(final int fromElement, final int toElement) throws Exception {
        int index = 0;
        if (fromElement > toElement) {
            throw new Exception("Invalid Arguments to Subset Exception");
        }
        if (toElement < 0) {
            int[] a = new int[0];
            return a;
        }
        int[] empt = new int[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (adtlist[i] >= fromElement && adtlist[i] < toElement) {
                empt[count++] = adtlist[i];
            }
        }
        int[] subSet = new int[count];
        for (int i = 0; i < count; i++) {
            subSet[i] = empt[i];
        }
        return subSet;
    }
    /**
     * { function_description }.
     *
     * @param      toElement  To element
     *
     * @return     { description_of_the_return_value }
     */
    public int[] headSet(final int toElement) throws Exception {
        if (toElement == adtlist[0]) {
            throw new Exception("{}");
        }
        if (toElement < 0) {
            throw new Exception("Set Empty Exception");
        }
        int[] empt = new int[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (adtlist[i] < toElement) {
                empt[count++] = adtlist[i];
            }
        }
        int[] headSet =  new int[count];
        for (int i = 0; i < count; i++) {
            headSet[i] = empt[i];
        }
        /*int index = Arrays.asList(adtlist).indexOf(toElement);
        int k = 0;
        for (int i = 0; i < index; i++) {
            headSet[k++] = adtlist[i];
        }*/
        return headSet;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int last() throws Exception {
        if (size == 0) {
            throw new Exception("Set Empty Exception");
        }
        return adtlist[size - 1];
    }
    /**
     * Adds all.
     *
     * @param      d     { parameter_description }
     */
    public void addAll(final int[] d) {

        // Set k = new Set();
        if (d.length > 0) {
            for (int a : d) {
                add(a);
            }
        }
        adtlist = Arrays.copyOf(adtlist, size);
        Arrays.sort(adtlist);
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        SortedSet b = new SortedSet();
        while (sc.hasNext()) {
            String[] token = sc.nextLine().split(" ");
            switch (token[0]) {
            case "subSet":
                try {

                    String[] a = token[1].split(",");
                    if (b.subSet(Integer.parseInt(a[0]),
                                 Integer.parseInt(a[1])) != null) {
                        if (b.subSet(Integer.parseInt(a[0]),
                                     Integer.parseInt(a[1])).length == 0) {
                            System.out.println("{}");
                            break;
                        }
                        if (a.length == 2) {
                            String str = "{";
                            int[] k = b.subSet(Integer.parseInt(a[0]),
                                               Integer.parseInt(a[1]));
                            for (int i = 0; i < k.length - 1; i++) {
                                str += k[i] + ", ";
                            }
                            str += k[k.length - 1] + "}";
                            System.out.println(str);
                        }

                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "headSet":
                int m = Integer.parseInt(token[1]);
                try {
                    if (b.headSet(m) != null) {
                        if (b.headSet(m).length == 0) {
                            System.out.println("{}");
                            break;
                        }
                        int[] k = b.headSet(m);
                        if (token[1].length() > 0) {
                            String str = "{";
                            for (int i = 0; i < k.length - 1; i++) {
                                str += k[i] + ", ";
                            }
                            str += k[k.length - 1] + "}";
                            System.out.println(str);
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "last":
                try {

                    System.out.println(b.last());
                }
                catch(Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "addAll":
                if (token[1].length() >= 1) {
                    String[] d = token[1].split(",");
                    int[] c = new int[d.length];
                    int i = 0;
                    for (String e : d) {
                        c[i++] = Integer.parseInt(e.trim());
                    }
                    b.addAll(c);
                }
                break;
            case "print":
                System.out.println(b);
                break;
            default:
                break;
            }
        }
    }
}
