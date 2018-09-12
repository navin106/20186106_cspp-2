import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Navin106
 */
public class Set {
    /**
     * { var_description }.
     */
    public final int num = 10;
    /**
     * { var_description }.
     */
    public int[] adtlist;
    /**
     * { var_description }.
     */
    public int size;
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
        if (size > adtlist.length / 2) {
            resize();
        }
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
        if (size == adtlist.length / 2) {
            resize();
        }
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
    public Set intersection(final Set newSet) throws Exception {
        Set intersection = new Set();
        int[] temp = newSet.adtlist;
        int cnt = 0;
        if (newSet.size > 0 && size > 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < temp.length; j++) {
                    if (adtlist[i] == temp[j]) {
                        intersection.add(adtlist[i]);
                    }
                }
            }
            return intersection;
        } else {
            throw new Exception();
        }
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
