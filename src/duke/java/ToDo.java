package duke.java;

public class ToDo extends Task{

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    public String toFileFormat() {
        return "T," + String.valueOf(isDone) + "," + description;
    }
}
