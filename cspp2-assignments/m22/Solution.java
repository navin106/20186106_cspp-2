import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
class SociaNetwork {
	HashMap<String, ArrayList<String>> sn;
	SociaNetwork() {
		sn = new HashMap<String, ArrayList<String>>();
	}
	public void addConnection(String key, String[] value) {
		sn.putIfAbsent(key, new ArrayList(Arrays.asList(value)));
	}
	public void addConnection(String key, String value) {
		int flag = 0;
		sn.putIfAbsent(key, new ArrayList<String>());
		for (String a : sn.keySet()) {
			if (a.equals(value)) {
				sn.get(key).add(value);
				flag = 1;
			}
		}
		if (flag == 0) {
			System.out.println("Not a user in Network");
		}
		// System.out.println(sn);
		// System.out.println(sn.entrySet());
		// System.out.println(sn.keySet());
		// System.out.println(sn.values());

	}
	public ArrayList<String> getConnection(String key) {
		if (sn.get(key) == null) {
			System.out.println("Not a user in Network");
			return null;
		} else {
			return sn.get(key);
		}
	}
	public ArrayList<String> getCommon(String user1, String user2) {
		ArrayList<String> cn = new ArrayList<String>();
		ArrayList<String> u1 = getConnection(user1);
		ArrayList<String> u2 = getConnection(user2);
		for (String a : u1) {
			for (String b : u2) {
				if (a.equals(b)) {
					cn.add(a);
				}
			}
		}
		return cn;
	}
	public void network() {
		String str = "";
		String k[] = sn.keySet().toString().replace("[", "").replace("]", "").split(", ");
		Arrays.sort(k);
		for (int i = 0; i < k.length; i++) {
			str += k[i] + ": " + getConnection(k[i]) + ", ";
		}
		System.out.println(str.substring(0, str.length() - 2));
	}
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SociaNetwork sn = new SociaNetwork();
		while (sc.hasNext()) {
			String t = sc.nextLine().replace(".", "");
			String[] token = t.split(" is connected to ");
			if (token.length == 2) {
				sn.addConnection(token[0], token[1].split(", "));
			} else {
				String[] tokens = t.split(" ");
				switch (tokens[0]) {
				case "addConnections":
					sn.addConnection(tokens[1], tokens[2]);
					break;
				case "getConnections":
					if (sn.getConnection(tokens[1]) != null) {
						System.out.println(sn.getConnection(tokens[1]));
					}
					break;
				case "CommonConnections":
					System.out.println(sn.getCommon(tokens[1], tokens[2]));
					break;
				case "Network":
					sn.network();
				default:
					break;
				}
			}
		}
	}
}