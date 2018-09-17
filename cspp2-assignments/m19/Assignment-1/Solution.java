import java.util.Scanner;
class Quiz {
	private String[] choices;
	private int rtanswer;
	private int maxmark;
	private int negativemark;
	private int markaward;
	private String chooseoption;
	private String questionno;
	public Quiz() {
	}
	public Quiz(String qn, String[] cs, int ca, int mm, int nm) {
		this.choices = cs;
		this.rtanswer = ca;
		this.maxmark = mm;
		this.negativemark = nm;
		this.questionno = qn;
	}
	public Quiz(int ma, String co) {
		this.markaward = ma;
		this.chooseoption = co;
	}
	public String getquestionno() {
		return questionno;
	}
	public void setquestionno(String questionno) {
		this.questionno = questionno;
	}
	public String getchooseoption() {
		return chooseoption;
	}
	public void setchooseoption(String chooseoption) {
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
	static int tokensize;
	static int uopt;
	static int maxmark;
	public static void loadQuestions(final Scanner s, final Quiz quiz, final int questionCount) {
		// write your code here to read the questions from the console
		// tokenize the question line and create the question object
		// add the question objects to the quiz class
		quizlist = new Quiz[20];
		qsize = 0;
		for (int i = 0; i < questionCount; i++) {
			String[] questoken = s.nextLine().split(":");
			tokensize = questoken.length;
			String[] choices = questoken[1].split(",");
			uopt = Integer.parseInt(questoken[2]);
			if (tokensize == 5) {
				if (choices.length >= 2) {
					quizlist[qsize++] = new Quiz(questoken[0], choices,  Integer.parseInt(questoken[2]), Integer.parseInt(questoken[3]), Integer.parseInt(questoken[4]));
				} else {
					System.out.println("trick question  does not have enough answer choices");
				}
			}
		}
		if (qsize > 0 && tokensize == 5) {
			if (uopt > 4) {
				System.out.println("Error! Correct answer choice number is out of range for question text 1");
			} else {
				if (maxmark < 0) {

					System.out.println("Invalid max marks for question about sony");
				} else {
					System.out.println(qsize + " are added to the quiz");
				}
			}
		}
		if (qsize == 0 && tokensize == 0) {
			System.out.println("Quiz does not have questions");
		}
		if (tokensize < 5 && tokensize > 0) {
			System.out.println("Error! Malformed question");
		}
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
		quizmarklist = new Quiz[20];
		size = 0;
		int cnt = 0;
		if (qsize > 0 && tokensize == 5) {
			for (int i = 0; i < answerCount; i++) {
				String choose = s.nextLine();
				String[] k = choose.split(" ");
				String[] avail = quizlist[i].getchoices();
				for (int j = 0; j < avail.length; j++) {
					if (choose.equals(avail[j])) {
						if (quizlist[i].getrtanswer() <= 4) {
							if (choose.equals(avail[quizlist[i].getrtanswer() - 1])) {
								quizmarklist[size++] = new Quiz(quizlist[i].getmaxmark(), k[1]);
							} else {
								quizmarklist[size++] = new Quiz(quizlist[i].getnegativemark(), k[1]);
							}
						}
					}
				}
			}
			if (uopt <= 4 && maxmark > 0) {
				for (int k = 0; k < qsize; k++) {
					String[] avail = quizlist[k].getchoices();
					System.out.println(quizlist[k].getquestionno() + "(" + quizlist[k].getmaxmark() + ")");
					String str = "";
					for (int i = 0; i < avail.length - 1; i++) {
						str += avail[i] + "\t";
					}
					str += avail[avail.length - 1];
					System.out.println(str);
					System.out.println();
				}
			}
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
		if (size > 0 && tokensize == 5) {

			for (int i = 1; i <= size; i++) {
				if (uopt <= 4 && quizlist[size-1].getmaxmark() > 0) {
					System.out.println(quizlist[i - 1].getquestionno());
					if (quizmarklist[i - 1].getmarkaward() > 0) {
						System.out.println(" Correct Answer! - Marks Awarded: " + quizlist[i - 1].getmaxmark());
						mark += quizlist[i - 1].getmaxmark();
					} else {
						System.out.println(" Wrong Answer! - Penalty: " + quizlist[i - 1].getnegativemark());
						mark += quizlist[i - 1].getnegativemark();
					}
				}
			}
			if (size > 0 && uopt <= 4 && quizlist[size-1].getmaxmark() > 0) {
				System.out.println("Total Score: " + mark);
			}
		}
	}
}
