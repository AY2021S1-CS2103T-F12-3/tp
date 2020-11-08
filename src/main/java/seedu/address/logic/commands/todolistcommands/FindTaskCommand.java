package seedu.address.logic.commands.todolistcommands;

import static java.util.Objects.requireNonNull;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.model.Model;
import seedu.address.model.task.FindTaskCriteria;

/**
 * Finds and lists all tasks in the TodoList whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class FindTaskCommand extends Command {

    public static final String COMMAND_WORD = "findtask";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all tasks which match all "
            + "the specified search parameters provided (case-insensitive) "
            + "and displays them as a list with index numbers.\n"
            + "At least one of the following search parameters must be provided: \n"
            + "Parameters: [n/TASK_NAME] [d/TASK_DATE] [p/TASK_PRIORITY] [s/TASK_STATUS] [t/TASK_TAG]...\n"
            + "Example: " + COMMAND_WORD + " n/lab t/easy t/cs2103T";

    private final Logger logger = LogsCenter.getLogger(FindTaskCommand.class);

    /**
     * Predicate to test if a task matches all the search criteria.
     */
    private final FindTaskCriteria findTaskCriteria;

    /**
     * Creates and initialises a new FindTaskCommand object.
     *
     * @param findTaskCriteria FindTaskCriteria that encapsulates a list of predicates to test a task with.
     */
    public FindTaskCommand(FindTaskCriteria findTaskCriteria) {
        requireNonNull(findTaskCriteria);
        logger.info("Executing FindTaskCommand");
        this.findTaskCriteria = findTaskCriteria;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredTodoList(findTaskCriteria.getFindTaskPredicate());
        logger.info("The result of executing the find task command has been displayed");
        return new CommandResult(
                String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, model.getFilteredTodoList().size()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof FindTaskCommand // instanceof handles nulls
                && findTaskCriteria.equals(((FindTaskCommand) other).findTaskCriteria)); // state check
    }

}
