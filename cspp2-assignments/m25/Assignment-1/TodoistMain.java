import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
/**
  * write your code below this comment
  */
class Task {
    private String title;
    private String assignedTo;
    private int timeToComplete;
    private String urgent;
    private String important;
    private String status;
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getassignedTo() {
        return assignedTo;
    }

    public void setassignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }
    public int gettimeToComplete() {
        return timeToComplete;
    }

    public void settimeToComplete(int timeToComplete) {
        this.timeToComplete = timeToComplete;
    }
    public String getimportant() {
        return important;
    }

    public void setimportant(String important) {
        this.important = important;
    }
    public String geturgent() {
        return urgent;
    }

    public void seturgent(String urgent) {
        this.urgent = urgent;
    }
    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
    Task(String title, String assignedTo, int timeToComplete, boolean important, boolean urgent, String status) throws Exception {
        if (title.length() == 0) {
            throw new Exception("Title not provided");
        } else {
            this.title = title;
        }
        this.assignedTo = assignedTo;
        if (timeToComplete < 0) {
            throw new Exception("Invalid timeToComplete " + timeToComplete);
        } else {
            this.timeToComplete = timeToComplete;
        }
        if (important == true) {
        this.important = "Important";
        } else {
            this.important = "Not Important";
        }
        if (urgent == true) {
        this.urgent = "Urgent";
        } else {
            this.urgent = "Not Urgent";
        }
        if (status.equals("todo") || status.equals("done")) {
            this.status = status;
        } else {
            throw new Exception("Invalid status dud." + status);
        }
    }

    public String toString() {
        return title + ", " + assignedTo + ", " + timeToComplete + ", " + important + ", " + urgent + ", " + status;
    }
}

class Todoist {
    ArrayList<Task> nourgent;
    ArrayList<Task> urgent;
    Task[] tasklist;
    int size;
    int nourgentindex = 0;
    int urgentindex = 0;
    Todoist() {
        tasklist = new Task[10];
        size = 0;
    }


    public void  addTask(Task t) {
        if (size == tasklist.length) {
            resize();
        }
        tasklist[size++]  = t;
        System.out.println(t);
    }


    public void resize() {
        tasklist = Arrays.copyOf(tasklist, tasklist.length * 2);
    }


    public  Task[] getNextTask(String name, int count) {
        Task[] cnttask = new Task[count];
        for (int i = 0; i < count; i++) {
            cnttask[i] = nourgent.get(nourgentindex);
        }
        return cnttask;
    }
    public Task getNextTask(String name) {
        nourgent = new ArrayList<Task>();
        urgent = new ArrayList<Task>();
        for (Task t : tasklist) {
            if (name.equals(t.getassignedTo())) {
                if ("todo".equals(t.getstatus())) {
                    if (t.getimportant().equals("Important")) {
                        if (!(t.geturgent().equals("Urgent"))) {
                            nourgent.add(t);
                        }
                    }

                }

            }
        }
        if (nourgent.size() == 0) {
            for (Task nt : tasklist) {
                if (name.equals(nt.getassignedTo())) {
                    if ("todo".equals(nt.getstatus())) {
                        if (nt.getimportant().equals("Important")) {
                            if (nt.geturgent().equals("Urgent")) {
                                urgent.add(nt);
                            }
                        }
                    }
                }
            }
            if (urgent.size() == 0) {
                return null;
            } else {
                return urgent.get(urgentindex++);

            }
        } else {
            return nourgent.get(nourgentindex++);
        }

    }
    public int totalTime4Completion() {
        int totalsum = 0;
        for (Task t : tasklist) {
            totalsum += t.gettimeToComplete();
        }
        return totalsum;
    }
    public String toString() {
        return "helloworld";
    }
}

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
            case "task":
                testTask(tokens);
                break;
            case "add-task":
                testAddTask(todo, tokens);
                break;
            case "print-todoist":
                System.out.println(todo);
                break;
            case "get-next":
                System.out.println(todo.getNextTask(tokens[1]));
                break;
            case "get-next-n":
                int n = Integer.parseInt(tokens[2]);
                Task[] tasks = todo.getNextTask(tokens[1], n);
                System.out.println(Arrays.deepToString(tasks));
                break;
            case "total-time":
                System.out.println(todo.totalTime4Completion());
                break;
            default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return (new Task(title, assignedTo, timeToComplete, important, urgent, status));
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
