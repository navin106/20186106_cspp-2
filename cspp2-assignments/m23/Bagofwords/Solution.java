import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

class Freqdict {
    HashMap<String, Integer> hm;
    Freqdict() {
        hm = new HashMap<String, Integer>();
    }
    HashMap<String, Integer> makedict(String[] d) {
        HashSet<String> set = new HashSet<>(Arrays.asList(d));
        int cnt = 0;
        for (String l : set) {
            cnt = 0;
            for (String k : d) {
                if (l.equals(k)) {
                    cnt++;
                }
            }
            hm.put(l, cnt);
        }
        return hm;
    }
}
class Plagarise {
    int Dotproduct(HashMap<String, Integer> freqd1, HashMap<String, Integer> freqd2) {
        int dp = 0;
        HashSet<String> newSet = new HashSet<String>(freqd1.keySet());

        newSet.addAll(freqd2.keySet());

        for (String k : newSet) {
            if (freqd1.get(k) == null) {
                freqd1.put(k, 0);
            }
            if (freqd2.get(k) == null) {
                freqd2.put(k, 0);
            }
            dp += freqd1.get(k) * freqd2.get(k);
        }
        return dp;
    }
    double EuclideanNorm(Collection<Integer> a, Collection<Integer> b) {
        int s1 = 0;
        int s2 = 0;
        for (int c : a) {
            s1 += Math.pow(c, 2);
        }
        for (int d : b) {
            s2 += Math.pow(d, 2);
        }
        return Math.sqrt(s1) * Math.sqrt(s2);
    }
}
public class Solution {
    public static void main(String[] args) throws Exception {
        try {

            Freqdict k1;
            Plagarise pl;
            Scanner sc = new Scanner(System.in);
            File folder = new File(sc.next());
            File[] filesArray = folder.listFiles();
            Arrays.sort(filesArray);
            String[] filenames = folder.list();
            Arrays.sort(filenames);
            ArrayList<String> filestringslist = new ArrayList<String>();
            for (File a : filesArray) {
                // System.out.println(a);
                FileReader f = new FileReader(a);
                BufferedReader b = new BufferedReader(f);
                String filestring = "";
                while (true) {
                    String tmp = b.readLine();
                    if (tmp != null) {
                        filestring += tmp;
                    } else {
                        break;
                    }
                }
                // System.out.println(filestring);
                filestringslist.add(filestring);
                f.close();
                b.close();
            }

            HashMap<String, Integer> freqd1;
            double percent = 0;
            ArrayList<Long> resultlist = new ArrayList<Long>();
            ArrayList<HashMap<String, Integer>> dictlist = new ArrayList<HashMap<String, Integer>>();
            for (String b : filestringslist) {
                // System.out.println(b);
                k1 = new Freqdict();
                freqd1 = new HashMap<String, Integer>();
                freqd1 = k1.makedict(cleanstring(b).split(" "));
                // freqd1 = k1.makedict(b. toLowerCase().split(" "));
                dictlist.add(freqd1);
                // System.out.println(freqd1);
            }

            String[] mp = new String[2];
            float max = 0;
            int x = -1;
            int y = -1;
            for (HashMap<String, Integer> k : dictlist) {
                x++;
                for (HashMap<String, Integer> l : dictlist) {
                    y++;
                    pl = new Plagarise();
                    int dp = pl.Dotproduct(k, l);
                    double en = pl.EuclideanNorm(k.values(), l.values());
                    percent = dp / en * 100;
                    if (max < Math.round(percent) && Math.round(percent) != 100) {
                        max = Math.round(percent);
                        mp[0] = filenames[x];
                        mp[1] = filenames[y];
                    }
                    resultlist.add(Math.round(percent));
                }
                y = -1;
            }
            x = -1;
            String s = "      " + "\t\t";
            for (String k : filenames) {
                s += k + "\t";
            }
            int k = 0;
            s += "\n";
            for (int i = 0; i < filenames.length; i++) {
                s += filenames[i] + "\t";
                for (int j = 0; j < filenames.length; j++) {
                    s += resultlist.get(k++) + "\t" + "\t";
                }
                s += "\n";
            }
            System.out.print(s);
            System.out.println("Maximum similarity is between " + mp[0] + " and " + mp[1]);
        }

        catch (Exception e) {
            System.out.println("empty directory");
        }
    }
    public static String cleanstring(String d1) {
        // System.out.println(d1);
        Pattern p = Pattern.compile("[^a-z A-Z 0-9]");
        Matcher m = p.matcher(d1);
        String newstring = m.replaceAll("").toLowerCase().replace(".", " ");
        // System.out.println(newstring);
        return newstring;
    }

}