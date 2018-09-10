import java.util.Scanner;
import java.util.Arrays;
/**
 * @author :navin106
 * date:sep-11- 2018.
 */
class Sortedset extends Set{
    public int last() {
        return adtlist[size - 1];
    }
    public int[] addAll(int[] a) {
        int[] b = new int[a.length];
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            if(!contains(a[i])) {
                b[k++] = a[i];
            }
        }
        return b;
    }
    public int[] headSet(int toElement) {
        int len = 0;
        for (int j =0; j<size; j++) {
            if(adtlist[j] == toElement) {
                len = j;
                break;
            }
        }
        int[] headSet = new int[len];
        for (int i =0; i<len; i++) {
            if (adtlist[i] < toElement) {
                headSet[i] = adtlist[i];
            }
        }
        return headSet;
    }
    public int[] subSet(int fromElement, int toElement) {
        int len = 0;
        for (int j =0; j<size; j++) {
            if(adtlist[j] == toElement) {
                len = j;
                break;
            }
        }
        int k = 0;
        int[] subSet = new int[len];
        for (int i=0; i<len; i++) {
            if (adtlist[i] == fromElement) {
                subSet[k++] = adtlist[i];
            }
            
        }
        return subSet;
    }

}
public final class Solution {
    public static void main(String[] args) {
        Sortedset s =  new Sortedset();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] token = (sc.next()).split(" ");
            switch (token[0]) {
            case "last":
                System.out.println(s.last());
                break;
            case "addAll":
                String[] a = token[1].split(",");
                int[] b = new int[a.length];
                for (int i = 0; i < a.length; i++) {
                    b[i] = Integer.parseInt(a[i]);
                }
                System.out.println(s.addAll(b));
                break;
            case "print":
                System.out.println(s.toString());
                break;
            case "headSet":
                System.out.println(s.headSet(Integer.parseInt(token[1])));
                break;
            case "subSet":
                String[] c = token[1].split(",");
                System.out.println(s.subSet(Integer.parseInt(c[0]), Integer.parseInt(c[1])));
                break;
            default:
                break;
            }
        }
    }
}