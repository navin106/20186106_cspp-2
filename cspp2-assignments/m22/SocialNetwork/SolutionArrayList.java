import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
class User {
	private String username;
	private ArrayList<String> followers;
	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}
	public ArrayList<String> getfollowers() {
		return followers;
	}

	public void setfollowers(ArrayList<String> followers) {
		this.followers = followers;
	}
	User() {

	}
	User(String un, ArrayList <String> fs) {
		username = un;
		followers = fs;
	}
	public String toString() {
		return username + ": " + followers.toString();
	}
}
class networkarraylist {
	ArrayList<User> database;
	networkarraylist() {
		database = new ArrayList<User>();
	}
	void addConnection(String s, User u) {
		database.add(u);
	}
	void addConnection(String un, String fl) {
		int flag = 0;
		for (User s1 : database) {
			if (fl.equals(s1.getusername())) {
				for (User s : database) {
					if (un.equals(s.getusername())) {
						s.getfollowers().add(fl);
						flag = 1;
						break;
					}
				}
			}
		}
		if (flag == 0) {
			System.out.println("Not a user in Network");
		}
	}
	ArrayList<String> getConnection(String un) {
		User k1 = new User();
		for (User k : database) {
			if (un.equals(k.getusername())) {
				k1 = k;
				break;
			}
		}
		return k1.getfollowers();
	}
	ArrayList<String> getCommon(String u1, String u2) {
		ArrayList<String> common = new ArrayList<String>();
		ArrayList<String> c1 = getConnection(u1);
		ArrayList<String> c2 = getConnection(u2);
		for (String k1 : c1) {
			for (String k2 : c2) {
				if (k1.equals(k2)) {
					common.add(k1);
				}
			}
		}
		return common;
	}
	void network() {
		String str = "";
		ArrayList<String> unames = new ArrayList<String>();
		for (User l : database) {
			unames.add(l.getusername());
		}
		String[] keys = unames.toArray(new String[unames.size()]);
		Arrays.sort(keys);
		for (String uname : keys) {
			str += uname + ": " + getConnection(uname) + ", ";
		}
		System.out.println(str.substring(0, str.length() - 2));
	}
}
public class SolutionArrayList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		networkarraylist sn = new networkarraylist();
		while (sc.hasNext()) {
			String t = sc.nextLine().replace(".", "");
			String[] token = t.split(" is connected to ");
			if (token.length == 2) {
				sn.addConnection(token[0], new User(token[0], new ArrayList<String>(Arrays.asList(token[1].split(", ")))));
			} else {
				String[] tokens = t.split(" ");
				switch (tokens[0]) {
				case "addConnections":
					sn.addConnection(tokens[1], tokens[2]);
					break;
				case "getConnections":
					if (sn.getConnection(tokens[1]) != null) {
						System.out.println(sn.getConnection(tokens[1]));
					} else {
						System.out.println("Not a user in Network");
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