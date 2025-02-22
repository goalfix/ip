package duke;

/**
 * Class that represents a Task. Contains the description of the Task and whether it has been completed.
 */
public class Task {

    protected String description;
    protected boolean isDone;

    /**
     * Constructs an instance of Task.
     *
     * @param description Description of task.
     */
    public Task(String description) {
        assert(description != null && !description.equals(""));
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets the current status icon of the task.
     *
     * @return String description whether the task has been completed.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /** Marks the current task as done. */
    public void markDone() {
        isDone = true;
    }

    /** Marks the current task as undone. */
    public void markUndone() {
        isDone = false;
    }

    /**
     * Converts Task to string format.
     *
     * @return Task in string format.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + this.description;
    }

    /**
     * Converts Task to file format.
     *
     * @return Task in file format.
     */
    public String toFileFormat() {
        return null;
    }
}
