import java.util.Scanner;
import java.util.Arrays;
class SortedSet extends Set {
	public int indexOf(int item) {
		for (int i = 0; i < size; i++) {
			if (item == adtlist[i]) {
				return i;
			}
		}
		return -1;
	}
	public int[] subSet(int fromElement, int toElement) {
		int index = 0;
		if (fromElement > toElement) {
			System.out.println("Invalid​ ​ Arguments​ ​ to​ Subset​ ​ Exception");
			return null;
		}
		int[] empt = new int[size];
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (adtlist[i]>= fromElement && adtlist[i] < toElement) {
				empt[count++] = adtlist[i];
			}
		}
		int[] subSet = new int[count];
		for (int i = 0; i < count; i++) {
			subSet[i] = empt[i];
		}
		/*
		if (indexOf(fromElement) != -1) {
			index = indexOf(fromElement);
		}
		int[] subSet = new int[size];
		int k = 0;
		for (int i = index; i < size; i++) {
			if (adtlist[i] < toElement) {
				subSet[k++] = adtlist[i];
			}
		}*/
		return subSet;
	}
	public int[] headSet(int toElement) {
		if (toElement == adtlist[0]) {
			System.out.println("Invalid​ ​ Arguments​ ​ to​ Subset​ ​ Exception");
			return null;
		}
		int[] empt = new int[size];
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (adtlist[i] < toElement) {
				empt[count++] = adtlist[i];
			}
		}
		int[] headSet =  new int[count];
		for (int i =0; i < count; i++) {
			headSet[i] = empt[i];
		}
		/*int index = Arrays.asList(adtlist).indexOf(toElement);
		int k = 0;
		for (int i = 0; i < index; i++) {
			headSet[k++] = adtlist[i];
		}*/
		return headSet;
	}
	public int last() {
		if (size == 0) {
			System.out.println("Set​ Empty​ Exception");
			return -1;
		}
		return adtlist[size - 1];
	}
	public void addAll(int[] d) {
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
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SortedSet b = new SortedSet();
		while (sc.hasNext()) {
			String[] token = sc.nextLine().split(" ");
			switch (token[0]) {
			case "subSet":
				String[] a = token[1].split(",");
				if (a.length > 1) {
					String str = "{";
					int[] k = b.subSet(Integer.parseInt(a[0]), Integer.parseInt(a[1]));
					for (int i = 0; i < k.length - 1; i++) {
						str += k[i] + ", ";
					}
					str += k[k.length - 1] + "}";
					System.out.println(str);
				}
				break;
			case "headSet":
				System.out.println(b.headSet(Integer.parseInt(token[1])));
				break;
			case "last":
				System.out.println(b.last());
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