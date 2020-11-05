package seedu.address.model.task;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Task in the todo list.
 * Guarantees: non-null field values are validated, immutable.
 */
public class Task {
    private final TaskName name;
    private final Set<Tag> tags = new HashSet<>();
    private final Priority priority;
    private final Date date;
    private final Status status;

    // unrelated field to the user

    private final LocalDate dateCreated;

    /**
     * Initial constructor to avoid having null as arguments.
     * Should be only used to add a new task.
     *
     * @param name name of the task
     */
    public Task(TaskName name) {
        assert name != null;
        this.name = name;
        this.priority = null;
        this.date = null;
        this.status = Status.NOT_COMPLETED;
        this.dateCreated = LocalDate.now();
    }

    /**
     * Constructor to support immutability.
     *
     * @param name name of the task
     * @param tags tags related to the task
     * @param priority priority of the task
     * @param date date of the task
     * @param status status of the task
     * @param dateCreated date creation of the task
     */
    public Task(TaskName name, Set<Tag> tags, Priority priority, Date date, Status status, LocalDate dateCreated) {
        requireAllNonNull(name, status);
        this.name = name;
        this.tags.addAll(tags);
        this.priority = priority;
        this.date = date;
        this.status = status;
        this.dateCreated = dateCreated;
    }

    public Optional<TaskName> getName() {
        return Optional.of(this.name);
    }

    public Task setName(TaskName name) {
        return new Task(name, this.tags, this.priority, this.date, this.status, this.dateCreated);
    }

    public Optional<Set<Tag>> getTags() {
        return Optional.of(this.tags).map(Collections::unmodifiableSet);
    }

    public Task setTags(Set<Tag> tags) {
        return new Task(this.name, tags, this.priority, this.date, this.status, this.dateCreated);
    }

    public Optional<Priority> getPriority() {
        return Optional.ofNullable(this.priority);
    }

    public Task setPriority(Priority priority) {
        return new Task(this.name, this.tags, priority, this.date, this.status, this.dateCreated);
    }

    public Optional<Date> getDate() {
        return Optional.ofNullable(this.date);
    }

    public Task setDate(Date date) {
        return new Task(this.name, this.tags, this.priority, date, this.status, this.dateCreated);
    }

    public Optional<Status> getStatus() {
        assert this.status != null;
        return Optional.of(this.status);
    }

    public Task setStatus(Status status) {
        return new Task(this.name, this.tags, this.priority, this.date, status, this.dateCreated);
    }

    public Optional<LocalDate> getDateCreated() {
        assert dateCreated != null;
        return Optional.of(dateCreated);
    }

    /**
     * Returns true if both task have the same name.
     * This defines a weaker notion of equality between two tasks.
     *
     * @param otherTask other task to be compared
     * @return true if both task has the same name.
     */
    public boolean isSameTask(Task otherTask) {
        if (this == otherTask) {
            return true;
        }

        return getName().equals((otherTask.getName()));
    }

    /**
     * Returns true if this task has the specified date.
     *
     * @param date the specified date
     * @return true if this task has the specified date.
     */
    public boolean hasSameDate(Date date) {
        requireNonNull(this.date);
        return this.date.equals(date);
    }

    /**
     * Returns true if this task has the specified priority.
     *
     * @param priority the specified priority
     * @return true if this task has the specified priority
     */
    public boolean hasSamePriority(Priority priority) {
        requireNonNull(this.priority);
        return this.priority.equals(priority);
    }

    /**
     * Returns true if this task has the specified tag(s).
     *
     * @param tag the specified tag
     * @return true if this task has the specified tag(s)
     */
    public boolean hasSameTag(Set<Tag> tag) {
        requireNonNull(this.tags);
        return this.tags.equals(tag);
    }

    /**
     * Checks if two tasks are equal.
     * This defines a stronger equality between two tasks.
     *
     * @param other other task to be compared
     * @return true if both task have the same name, type, priority, date, and status
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
        return otherTask.getName().equals(getName())
            && otherTask.getTags().equals(getTags())
            && otherTask.getPriority().equals(getPriority())
            && otherTask.getDate().equals(getDate())
            && otherTask.getStatus().equals(getStatus());
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder
            .append(" *Name: ")
            .append(getName().isPresent() ? getName().get() : "")
            .append("\n")
            .append(" *Tag: ")
            .append(getTags().isPresent() ? getTags().get() : "")
            .append("\n")
            .append(" *Priority: ")
            .append(getPriority().isPresent() ? getPriority().get() : "")
            .append("\n")
            .append(" *Date: ")
            .append(getDate().isPresent() ? getDate().get() : "")
            .append("\n")
            .append(" *Status: ")
            .append(getStatus().isPresent() ? getStatus().get() : "")
            .append("\n");
        return builder.toString();
    }

    // ============================ UI getter ================================ //

    /**
     * Returns string representing of the name of the task for the UI.
     *
     * @return string to be displayed in the UI.
     */
    public String getNameForUi() {
        assert this.name != null;
        return this.name.toString();
    }

    /**
     * Returns a set representing of the tags of the task for the UI.
     *
     * @return set of tags to be displayed in the UI.
     */
    public Set<Tag> getTagsForUi() {
        if (this.tags.isEmpty()) {
            HashSet<Tag> defaultTags = new HashSet<>();
            defaultTags.add(new Tag("NoTags"));
            return defaultTags;
        } else {
            return this.tags;
        }
    }

    /**
     * Returns string representing of the priority of the task for the UI.
     *
     * @return string to be displayed in the UI.
     */
    public String getPriorityForUi() {
        if (this.priority == null) {
            return "-  -  -  -";
        }
        switch(priority) {
        case HIGH:
            return "★★★★";
        case NORMAL:
            return "★★★";
        case LOW:
            return "★★";
        default:
            return "-  -  -  -";
        }
    }

    /**
     * Returns string representing of the date of the task for the UI.
     *
     * @return string to be displayed in the UI.
     */
    public String getDateForUi() {
        if (this.date == null) {
            return "-   -   -   -";
        } else {
            return this.date.toString();
        }
    }

    /**
     * Returns string representing of the status of the task for the UI.
     *
     * @return string to be displayed in the UI.
     */
    public String getStatusForUi() {
        assert this.status != null;
        if (status == Status.COMPLETED) {
            return "COMPLETED";
        } else {
            return "NOT COMPLETED";
        }
    }

    /**
     * Returns the number of days since this Task is created.
     *
     * @return number of days as double
     */
    private double getDaysSinceCreated() {
        LocalDate currentDate = LocalDate.now();
        return dateCreated.until(currentDate, DAYS);
    }

    /**
     * Returns the number of days between the date of the creation of the Task until the deadline.
     *
     * @return number of days as double
     */
    private double getDaysFromCreatedToDeadline() {
        if (date == null) {
            return 0;
        } else {
            return dateCreated.until(date.getValue(), DAYS);
        }
    }

    /**
     * Returns the number of days from now until the deadline.
     *
     * @return number of days as double
     */
    private double getDaysUntilDeadline() {
        LocalDate tomorrow = LocalDate.now();
        return tomorrow.until(date.getValue(), DAYS);
    }

    /**
     * Returns the percentage of days passed since the date of the Task created to the deadline.
     *
     * @return double value from 0 to 1
     */
    public double getProgressPercentageForUi() {
        if (this.status.equals(Status.COMPLETED)) {
            return 1;
        }

        if (date == null) {
            return 0;
        }

        if (getDaysUntilDeadline() < 0) {
            return -1;
        }

        if (getDaysFromCreatedToDeadline() == 0) {
            return 1;
        }

        return getDaysSinceCreated() / getDaysFromCreatedToDeadline();
    }

    /**
     * Returns the remaining days until the deadline to be displayed in the GUI.
     *
     * @return number of days as integer
     */
    public String getDaysUntilDeadlineForUi() {
        String toDisplay = "Remaining days : ";

        if (this.status.equals(Status.COMPLETED)) {
            toDisplay += "-";
            return toDisplay;
        }

        if (date == null) {
            toDisplay += "∞";
            return toDisplay;
        }

        int remainingDays = (int) getDaysUntilDeadline();
        if (remainingDays < 0) {
            toDisplay += "!!!";
        } else {
            toDisplay += String.valueOf(remainingDays);
        }

        return toDisplay;
    }

    /**
     * Returns true if this task is overdue.
     *
     * @return true if this task is overdue and date is not null;
     */
    public boolean isOverdue() {
        if (date == null) {
            return false;
        }
        return LocalDate.now().isAfter(date.getValue());
    }
}
