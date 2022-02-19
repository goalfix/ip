package duke;

/**
 * A type of Task that can be characterised as a ToDo. Contains the description of the Task to be Done.
 */
public class ToDo extends Task {

    /**
     * Constructs an instance of ToDo.
     *
     * @param description Description of ToDo.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Converts ToDo to string format.
     *
     * @return ToDo in string format.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Converts ToDo to file format.
     *
     * @return ToDo in file format.
     */
    public String toFileFormat() {
        return "T," + String.valueOf(isDone) + "," + description;
    }
}
