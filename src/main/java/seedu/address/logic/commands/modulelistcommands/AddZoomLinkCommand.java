package seedu.address.logic.commands.modulelistcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ZOOM_LINK;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_MODULES;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.module.Module;
import seedu.address.model.module.ZoomLink;

/**
 * Adds a zoom link to a module.
 */
public class AddZoomLinkCommand extends Command {

    public static final String COMMAND_WORD = "addzoom";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a zoom link to the module. "
            + "Parameters: " + "INDEX (must be a positive integer) "
            + PREFIX_NAME + "MODULE LESSON TYPE"
            + PREFIX_ZOOM_LINK + "ZOOM LINK "
            + "Example: " + COMMAND_WORD + " "
            + "1" + PREFIX_NAME + "lecture"
            + PREFIX_ZOOM_LINK + "https://nus-sg.zoom.us/j/uasoihd637bf";

    public static final String MESSAGE_ADD_ZOOM_SUCCESS = "Added Zoom link: %1$s";

    private final Index targetIndex;
    private final ZoomLink zoomLink;
    private final String moduleLessonType;

    /**
     * Creates and initialises a new AddZoomLinkCommand object.
     *
     * @param targetIndex Index object representing the index of the module in the module list.
     * @param moduleLessonType String representing the type of module lesson.
     * @param zoomLink ZoomLink object representing the zoom link to be added
     *                 to a module for a specific lesson type.
     */
    public AddZoomLinkCommand(Index targetIndex, String moduleLessonType, ZoomLink zoomLink) {
        this.targetIndex = targetIndex;
        this.moduleLessonType = moduleLessonType;
        this.zoomLink = zoomLink;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Module> lastShownList = model.getFilteredModuleList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_MODULE_DISPLAYED_INDEX);
        }

        Module moduleToAddZoom = lastShownList.get(targetIndex.getZeroBased());
        model.addZoom
        model.commitModuleList();
        return new CommandResult(String.format(MESSAGE_ADD_ZOOM_SUCCESS, zoomLink));
    }


    /**
     * Indicates if the application session has ended.
     *
     * @return False since the sessions has not been terminated.
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
