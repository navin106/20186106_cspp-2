import java.util.Scanner;
/**
 *@author:navin106
 *
 * Solution class for code-eval.
 */
public final class Solution {
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        boolean flag = true;
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                try {
                    loadQuestions(s, q, Integer.parseInt(tokens[1]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    flag = false;
                }
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                if (flag) {
                    displayScore(q);
                }
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      scan       The scan
     * @param      quiz       The quiz
     * @param      q          The question count
     *
     * @throws     Exception  { exception_description }
     */
    public static void loadQuestions(final Scanner scan,
                    final Quiz quiz, final int q) throws Exception {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        if (q == 0) {
            throw new Exception("Quiz does not have questions");
        }
        for (int  i = 0; i < q; i++) {
            String[] tokens = scan.nextLine().split(":");
            for (String token : tokens)  {
                if (token.equals("")) {
                    throw new Exception("Error! Malformed question");
                }
            }
            if (tokens.length < 2 + 2 + 1) {
                throw new Exception("Error! Malformed question");
            }
            if (tokens[1].split(",").length < 2) {
                throw new Exception(tokens[0]
            + " does not have enough answer choices");
            }
            if (Integer.parseInt(tokens[2]) > tokens[1].split(",").length) {
                throw new Exception("Error! Correct answer" + 
                " choice number is out of range for question text " + (i + 1));
            }
            if (Integer.parseInt(tokens[2 + 1]) < 0) {
                throw new Exception("Invalid max marks for " + tokens[0]);
            }
            if (Integer.parseInt(tokens[2 + 2]) > 0) {
                throw new Exception("Invalid penalty for " + tokens[0]);
            }
            quiz.addQuestion(new Question(tokens[0], tokens[1].split(
                ","), Integer.parseInt(tokens[2]), Integer.parseInt(
                tokens[2 + 1]), Integer.parseInt(tokens[2 + 2])));
            // System.out.println(i);
        }
        System.out.println(q + " are added to the quiz");
    }
    /**
     * Starts a quiz.
     *
     * @param      scan  The scan
     * @param      quiz  The quiz
     * @param      q     The answer count
     */
    public static void startQuiz(final Scanner scan,
                                 final Quiz quiz, final int q) {
        // write your code here to display the quiz questions on the console.
        // read the user responses from the console using scanner object.
        // store the user respone in the question object
        for (Question question : quiz.getQuestions()) {
            System.out.println(question);
            question.setResponse(scan.nextLine());
        }
    }
    /**
     * Displays the score report.
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report using quiz object.
        System.out.println(quiz.showReport());
    }
}
