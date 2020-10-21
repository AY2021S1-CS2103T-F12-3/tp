package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.Date;
import seedu.address.model.task.Priority;
import seedu.address.model.task.Status;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskName;

/**
 * Jackson-friendly version of {@link Task}.
 */
public class JsonAdaptedTask {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Task's %s field is missing!";

    private final String name;
    private final JsonAdaptedTag tag;
    private final String priority;
    private final String date;
    private final String status;

    /**
     * Constructs a {@code JsonAdaptedTask} with the given task details.
     */
    @JsonCreator
    public JsonAdaptedTask(@JsonProperty("name") String name, @JsonProperty("tag") JsonAdaptedTag tag,
                              @JsonProperty("priority") String priority,
                           @JsonProperty("date") String date, @JsonProperty("status") String status) {
        this.name = name;
        this.tag = tag;
        this.priority = priority;
        this.date = date;
        this.status = status;
    }

    /**
     * Converts a given {@code Task} into this class for Jackson use.
     */
    public JsonAdaptedTask(Task source) {
        name = source.getName().get().getValue();
        tag = new JsonAdaptedTag(source.getTag().get());
        priority = source.getPriority().get().toString();
        date = source.getDate().get().toString();
        status = source.getStatus().get().toString();
    }

    /**
     * Converts this Jackson-friendly adapted task object into the model's {@code Task} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted contact.
     */
    public Task toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    TaskName.class.getSimpleName()));
        }
        if (!TaskName.isValidTaskName(name)) {
            throw new IllegalValueException(TaskName.MESSAGE_CONSTRAINTS);
        }
        final TaskName modelTaskName = new TaskName(name);
        final Tag modelTag = tag.toModelType();

        if (priority == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Priority.class.getSimpleName()));
        }
        if (!Priority.isValidPriority(priority)) {
            throw new IllegalValueException(Priority.MESSAGE_CONSTRAINTS);
        }
        final Priority modelPriority = Priority.getPriority(priority);
        if (date == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Date.class.getSimpleName()));
        }
        if (!Date.isValidDate(date)) {
            throw new IllegalValueException(Date.MESSAGE_CONSTRAINTS);
        }
        final Date modelDate = new Date(date);
        if (status == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Status.class.getSimpleName()));
        }
        final Status modelStatus = Status.getStatus(status);
        return new Task(modelTaskName, modelTag, modelPriority, modelDate, modelStatus);
    }

}
