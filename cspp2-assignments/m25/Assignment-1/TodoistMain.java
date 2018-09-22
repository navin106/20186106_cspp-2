import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
/**
  * write your code below this comment
  */
class Task {
    private String Title;
    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }
    private String AssignedTo;
    public String getAssignedTo() {
        return AssignedTo;
    }

    public void setAssignedTo(String AssignedTo) {
        this.AssignedTo = AssignedTo;
    }
    private int TimeToComplete;
    public int getTimeToComplete() {
        return TimeToComplete;
    }

    public void setTimeToComplete(int TimeToComplete) {
        this.TimeToComplete = TimeToComplete;
    }
    private boolean Important;
    public boolean getImportant() {
        return Important;
    }

    public void setImportant(boolean Important) {
        this.Important = Important;
    }
    private boolean Urgent;
    public boolean getUrgent() {
        return Urgent;
    }

    public void setUrgent(boolean Urgent) {
        this.Urgent = Urgent;
    }
    private String Status;
    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    Task(String title, String assignedTo, int timeToComplete, boolean important, boolean urgent, String status) throws Exception {
        if (title.length() == 0) {
            throw new Exception("Title not provided");
        } else {
            this.Title = title;
        }
        this.AssignedTo = assignedTo;
        if (timeToComplete < 0) {
            throw new Exception("Invalid timeToComplete" + timeToComplete);
        } else {
            this.TimeToComplete = timeToComplete;
        }
        this.Important = important;
        this.Urgent = urgent;
        if (Status.equals("todo") || Status.equals("done")) {
            this.Status = status;
        } else {
            throw new Exception("Task status should be either todo or done and can’t have any other value." + Status);
        }
    }
    public String toString() {
        return Title + AssignedTo + TimeToComplete + Important + Urgent + Status;
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
            if (name.equals(t.getAssignedTo())) {
                if ("todo".equals(t.getStatus())) {
                    if (t.getImportant()) {
                        if (!(t.getUrgent())) {
                            nourgent.add(t);
                        }
                    }

                }

            }
        }
        if (nourgent.size() == 0) {
            for (Task nt : tasklist) {
                if (name.equals(nt.getAssignedTo())) {
                    if ("todo".equals(nt.getStatus())) {
                        if (nt.getImportant()) {
                            if (nt.getUrgent()) {
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
            totalsum += t.getTimeToComplete();
        }
        return totalsum;
    }
    public String toString() {
        String str = "";
        for (Task t : tasklist) {
            str += t;
        }
        return str;
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
        return new Task(
                   title, assignedTo, timeToComplete, important, urgent, status);
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
