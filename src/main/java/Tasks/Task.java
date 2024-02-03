package Tasks;

/**
 * A abstract class to handle details of a task.
 * This class is extended by 3 sub-classes:
 * 1) ToDo
 * 2) Deadline
 * 3) Event
 */
abstract public class Task {
    protected String name;
    protected boolean isDone = false;

    public Task(String name) {
        this.name = name;
    }

    abstract protected void formatInput(String description);

    /**
     * compress task details into a line separated with ','
     * 
     * The format for all tasks should include:
     * - task type:           E, D, T         [Event, Deadline, ToDo respectively]
     * - completion status:   0, 1   
     * - task description:    String of words
     * 
     * specific task types should append other relevant details.
     * 
     * @return a single string line containing its description.
     */
    abstract public String toCSV();

    // Get description of the task.
    public String getName() {
        return this.name;
    }

    // Get task completion status.
    public boolean getStatus() {
        return this.isDone;
    }

    /**
     * Set completion status of the task.
     * @param status true is completed, false otherwise
     */
    public void setStatus(boolean status) {
        this.isDone = status;
    }

    @Override
    public String toString() {
        return this.getStatus()
            ? "[X]" + " " + this.name
            : "[ ]" + " " + this.name;
    }
    
}