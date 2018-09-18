import java.util.Random;

public class MysteriousClient { public MysteriousClient() {}
  
  public static void main(String[] paramArrayOfString) { Random localRandom = new Random();
    int i = localRandom.nextInt(100);
    int j = localRandom.nextInt(10);
    List localList = new List(i);
    int k = 0;
    String str = "[";
    try {
      for (k = 0; k < i + j; k++) {
        localList.add(k);
        str = str + localList.get(k) + ",";
      }
      str = str.substring(0, str.length() - 1) + "]";
    } catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {
      System.out.println("Grrr... List ADT crashed :-(");
    }
    if (k == i + j) {
      if (localList.toString().equals(str)) {
        System.out.println("List ADT works like a charm! :-)");
      } else {
        System.out.println("Grrr... List ADT crashed :-(");
      }
    }
  }
}
