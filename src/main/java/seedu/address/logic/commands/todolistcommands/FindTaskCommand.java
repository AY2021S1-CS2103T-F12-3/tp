package seedu.address.logic.commands.todolistcommands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.task.FindTaskCriteria;
import seedu.address.model.task.Task;

import java.util.function.Predicate;
import java.util.logging.Logger;

/**
 * Finds and lists all tasks in the TodoList whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindTaskCommand extends Command {

    public static final String COMMAND_WORD = "findtask";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all tasks which match all"
            + "the specified search parameters provided (case-insensitive) "
            + "and displays them as a list with index numbers.\n"
            + "At least one of the following search parameters must be provided: \n"
            + "Parameters: [n/TASK_NAME] [d/TASK_DATE] [p/TASK_PRIORITY] [t/TASK_TAG...]\n"
            + "Example: " + COMMAND_WORD + " n/lab t/easy t/cs2103T";

    private final Logger logger = LogsCenter.getLogger(FindTaskCommand.class);

    /**
     * Predicate to test if a task matches all the search criteria.
     */
    private final Predicate<Task> predicate;

    /**
     * Creates and initialises a new FindTaskCommand object.
     *
     * @param findTaskCriteria FindTaskCriteria that encapsulates a list of predicates to test a task with.
     */
    public FindTaskCommand(FindTaskCriteria findTaskCriteria) {
        requireNonNull(findTaskCriteria);
        this.predicate = findTaskCriteria.getFindTaskPredicate();
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredTodoList(predicate);
        logger.info("The find task command has been executed");
        return new CommandResult(
                String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, model.getFilteredTodoList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindTaskCommand // instanceof handles nulls
                && predicate.equals(
                        ((FindTaskCommand) other).predicate)); // state check
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
