import java.util.Scanner;
class Quiz {
	private String[] choices;
	private int rtanswer;
	private int maxmark;
	private int negativemark;
	private int markaward;
	private int chooseoption;
	public Quiz() {

	}
	public Quiz(String[] cs, int ca, int mm, int nm) {
		this.choices = cs;
		this.rtanswer = ca;
		this.maxmark = mm;
		this.negativemark = nm;
	}
	public Quiz(int ma, int co) {
		this.markaward = ma;
		this.chooseoption = co;
	}
	public int getchooseoption() {
		return chooseoption;
	}

	public void setchooseoption(int chooseoption) {
		this.chooseoption = chooseoption;
	}
	public int getmarkaward() {
		return markaward;
	}

	public void setmarkaward(int markaward) {
		this.markaward = markaward;
	}
	public int getnegativemark() {
		return negativemark;
	}

	public void setnegativemark(int negativemark) {
		this.negativemark = negativemark;
	}
	public int getmaxmark() {
		return maxmark;
	}

	public void setmaxmark(int maxmark) {
		this.maxmark = maxmark;
	}
	public int getrtanswer() {
		return rtanswer;
	}

	public void setrtanswer(int rtanswer) {
		this.rtanswer = rtanswer;
	}
	public String[] getchoices() {
		return choices;
	}

	public void setchoices(String[] choices) {
		this.choices = choices;
	}

}
/**
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
				loadQuestions(s, q, Integer.parseInt(tokens[1]));
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
				displayScore(q);
				break;
			default:
				break;
			}
		}
	}
	/**
	 * Loads questions.
	 *
	 * @param      s              The scanner object for user input
	 * @param      quiz           The quiz object
	 * @param      questionCount  The question count
	 */
	static Quiz[] quizlist;
	static int qsize;
	public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		quizlist = new Quiz[10];
		qsize = 0;
		for (int i = 0; i < questionCount; i++) {
			String[] questoken = s.nextLine().split(":");
			String[] choices = questoken[1].split(",");
			if (choices.length >= 2) {
				quizlist[qsize++] = new Quiz(choices,  Integer.parseInt(questoken[2]), Integer.parseInt(questoken[3]), Integer.parseInt(questoken[4]));
			} else {
				System.out.println("invallid");
			}
		}
		System.out.println(qsize + " are added to the quiz");
	}

	/**
	 * Starts a quiz.
	 *
	 * @param      s            The scanner object for user input
	 * @param      quiz         The quiz object
	 * @param      answerCount  The answer count
	 */
	static Quiz[] quizmarklist;
	static int size;
	public static void startQuiz(final Scanner s, final Quiz quiz, final int answerCount) {
		// write your code here to display the quiz questions
		// read the user responses from the console
		// store the user respones in the quiz object
		quizmarklist = new Quiz[10];
		size = 0;
		int cnt = 0;
		for (int i = 0; i < answerCount; i++) {
			String choose = s.nextLine();
			String[] k = choose.split(" ");
			if (Integer.parseInt(k[1]) < 5 && Integer.parseInt(k[1].trim()) > 0) {
				String[] avail = quizlist[i].getchoices();
				for (int j = 0; j < avail.length; j++) {
					if (choose.equals(avail[j])) {
						if (Integer.parseInt(k[1]) == quizlist[i].getrtanswer()) {
							quizmarklist[size++] = new Quiz(quizlist[i].getmaxmark(), Integer.parseInt(k[1].trim()));
						} else {
							quizmarklist[size++] = new Quiz(quizlist[i].getnegativemark(), Integer.parseInt(k[1].trim()));
						}
					}
				}
			} else {
				System.out.println("invalid option");
			}

		}
		for (int k = 0; k < qsize; k++) {
			System.out.println("question text 1(" + quizmarklist[k].getmarkaward	() + ")");
			System.out.println("choice 1	choice 2	choice 3	choice 4");
			System.out.println();
		}
	}
	/**
	 * Displays the score report
	 *
	 * @param      quiz     The quiz object
	 */
	public static void displayScore(final Quiz quiz) {
		// write your code here to display the score report
		int mark = 0;
		for (int i = 1; i <= size; i++) {
			System.out.println("question text " + i);
			if (quizmarklist[i-1].getmarkaward() > 0) {
				System.out.println(" Correct Answer! - Marks Awarded:" + quizlist[i-1].getmaxmark());
				mark += quizlist[i-1].getmaxmark();
			} else {
				System.out.println(" Wrong Answer! - Penalty:" + quizlist[i-1].getnegativemark());
				mark += quizlist[i-1].getnegativemark();
			}
		}
		System.out.println("Total Score: " + mark);
	}
}