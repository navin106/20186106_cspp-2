import java.util.Scanner;

class Show {
    String moviename;
    String timedate;
    String[] seats;
    public Show(String a, String b, String[] c) {
        this.moviename = a;
        this.timedate = b;
        this.seats = c;
    }
    public String toString() {
        return (this.moviename + "," + this.timedate);
    }
}
class Patron {
    String Patronname;
    String Mobilenumber;
    public Patron(String a, String b) {
        this.Patronname = a;
        this.Mobilenumber = b;
    }
    public String toString() {
        return (this.Patronname+" "+this.Mobilenumber);
    }
}
/**
 * Class for BookYourShow.
 */
class BookYourShow {
    /**
     * Constructs the object.
     */
    Show[] movielist;
    Patron[] patronlist;
    int size = 0;

    public BookYourShow() {
        this.movielist = new Show[10];
        this.patronlist = new Patron[10];
        this.size = 0;
    }
    public void addAShow(Show k) {
        movielist[size++] = k;
    }
    public Show getAShow(String a, String b) {

        for (int i = 0; i < movielist.length; i++) {
            if ((movielist[i].moviename).equals(a)) {
                if ((movielist[i].timedate).equals(b)) {
                    return movielist[i];
                    
                }
            }

        }
        return null;
    }
    public void bookAShow(String a, String b, Patron c, String[] d) {
        int cnt = 0;
        int l = 0;
        for (int k = 0; k < movielist.length; k++) {
            if (a.equals(movielist[k].moviename)) {
                if ((movielist[k].timedate).equals(b)) {

                    String[] availseats = movielist[k].seats;
                    for (int i = 0; i < d.length; i++) {
                        for (int j = 0; j < availseats.length; j++) {
                            if (availseats[j].equals(d[i])) {
                                cnt += 1;
                            }

                        }

                    }
                    if (cnt == d.length) {
                        patronlist[l] = c;
                        l++;
                    }
                }

            }
        }

    }
    public void printTicket(String a, String b, String c) {
        for (int i = 0; i < patronlist.length; i++) {
            if (c.equals(patronlist[i].Mobilenumber)) {
                System.out.println(patronlist[i].Mobilenumber + " " + a + " " + b);
            }
        }

    }
    // showAll() {

    // }
}
public final class Solution {
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        BookYourShow bys = new BookYourShow();
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] tokens = scan.nextLine().
                              replace("[", "").replace("]", "").split(",");
            String[] check = tokens[0].split(" ");
            switch (check[0]) {
            case "add":
                int k = 2;
                String[] seats = new String[tokens.length - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.addAShow(new Show(check[1], tokens[1], seats));
                break;

            case "book":
                k = 2 + 2;
                seats = new String[tokens.length - 2 - 2];
                for (int j = 0; j < seats.length; j++) {
                    seats[j] = tokens[k++];
                }
                bys.bookAShow(check[1], tokens[1],
                              new Patron(tokens[2], tokens[2 + 1]), seats);
                break;

            case "get":
                Show show = bys.getAShow(check[1], tokens[1]);
                if (show != null) {
                    System.out.println(show);
                } else {
                    System.out.println("No show");
                }
                break;

            case "print":
                bys.printTicket(check[1], tokens[1], tokens[2]);
                break;

            // case "showAll":
            //     bys.showAll();
            //     break;

            default:
                break;
            }
        }
    }
}
