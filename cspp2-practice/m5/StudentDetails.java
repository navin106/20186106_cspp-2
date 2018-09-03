import java.util.Scanner;
/**
 * @author:navin106
 */
public final class StudentDetails {
    /**
     * noof sum.
     */
    private static final int NOOFSUB = 3;
    /**
     * { var_description }.
     */
    private static final int NO = 10;
    /**
     * constructs.
     */
    private StudentDetails() {
    }

    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println(
            "enter the name, rollno,marks of three subjects");
        studinput(s);
    }
    /**
     * { function_description }.
     *
     * @param      s     { parameter_description }
     */
    public static void studinput(final Scanner s) {
        Student k = new Student(s.nextLine(),
                                s.nextLine(), s.nextDouble(),
                                s.nextDouble(), s.nextDouble());
        System.out.println((Math.floor((k.getavg()) * NO)) / NO);
    }
    /**
     * Class for student.
     */
    public static  class Student {
        /**
         * { var_description }.
         */
        private String s;
        /**
         * { var_description }.
         */
        private String r;
        /**
         * { var_description }.
         */
        private Double a;
        /**
         * { var_description }.
         */
        private Double b;
        /**
         * { var_description }.
         */
        private Double c;
        /**
         * Constructs the object.
         *
         * @param      sa    { parameter_description }
         * @param      ra    { parameter_description }
         * @param      aa    { parameter_description }
         * @param      ba    { parameter_description }
         * @param      ca    { parameter_description }
         */
        public Student(final String sa, final String ra,
                       final Double aa, final Double ba,
                       final Double ca) {
            this.s = sa;
            this.r = ra;
            this.a = aa;
            this.b = ba;
            this.c = ca;
        }
        /**
         * Gets the average.
         *
         * @return     The average.
         */
        public Double getavg() {
            return (a + b + c) / NOOFSUB;
        }

    }

}
