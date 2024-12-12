import java.util.ArrayList;

public class Tasks {
    ArrayList<String> tasks = new ArrayList<String>();

    public Tasks() {

    }

    public void addTasks(String task) {
        tasks.add(task);
    }

    public void removeAll() {
        tasks.clear();
    }

    public int RemoveTasks(String task) {
        for (int i = 0; i < tasks.size(); i++) {
            String x = tasks.get(i);
            if (x.equals(task)) {
                tasks.remove(i);
                return 1;
            }
        }
        return 0;
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

}
