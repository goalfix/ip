package duke;

import java.io.IOException;
import java.time.format.DateTimeParseException;

/**
 * Class that represents a command to add a task.
 */
public class AddTaskCommand extends Command {

    private String description;
    private String type;
    private String toDoBy;

    /**
     * Constructs an instance of Add Task Command.
     *
     * @param description Description of task.
     * @param type Type of task, either ToDo, Deadline or Event.
     */
    public AddTaskCommand(String description, String type) {
        assert(description != null && !description.equals(""));
        assert(type != null && !type.equals(""));
        this.description = description;
        this.type = type;
    }

    /**
     * Constructs an instance of Add Task Command.
     *
     * @param description Description of task.
     * @param type Type of task, either ToDo, Deadline or Event.
     * @param toDoBy Deadline which task must be completed by.
     */
    public AddTaskCommand(String description, String type, String toDoBy) {
        assert(description != null && !description.equals(""));
        assert(type != null && !type.equals(""));
        assert(toDoBy != null && !type.equals(""));
        this.description = description;
        this.type = type;
        this.toDoBy = toDoBy;
    }

    /**
     * Executes the instance of Add Task Command.
     *
     * @param tasks Contains the task list.
     * @param ui Deals with interaction with the user.
     * @param storage Deals with loading tasks from the file and saving tasks in the file.
     */
    @Override
    public String execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            Task t;
            if (type.equals("todo")) {
                t = new ToDo(description);
            } else if (type.equals("deadline")) {
                t = new Deadline(description, toDoBy);
            } else {
                t = new Event(description, toDoBy);
            }

            if (tasks.checkTaskExist(t)) {
                return "Your task already exist in your Task List, duplicates not allowed!";
            }
            tasks.addTask(t);
            storage.writeToFile(tasks.getTaskArr());
            return ui.showSucessfulAdd(tasks.getTask(tasks.size() - 1), tasks.size());
        } catch (DateTimeParseException e) {
            return ui.showError("DateTimeParseException");
        } catch (IOException e) {
            return ui.showError("IOException");
        }
    }

    /**
     * Checks whether this command is the terminating command to Duke.
     *
     * @return False.
     */
    @Override
    public boolean isEnd() {
        return false;
    }

}
