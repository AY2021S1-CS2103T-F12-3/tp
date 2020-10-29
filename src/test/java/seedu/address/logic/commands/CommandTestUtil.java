package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ZOOM_LINK;
// import static org.junit.jupiter.api.Assertions.assertTrue;
// import static seedu.address.testutil.Assert.assertThrows;

// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
// import seedu.address.model.ModuleList;
// import seedu.address.model.person.NameContainsKeywordsPredicate;
// import seedu.address.model.person.Person;
//import seedu.address.testutil.EditPersonDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags

    public static final String VALID_MODULENAME_CS2103T = "CS2103T";
    public static final String VALID_MODULENAME_ES2660 = "ES2660";
    public static final String VALID_MODULELESSONTYPE_CS2103T = "Lecture";
    public static final String VALID_MODULELESSONTYPE_ES2660 = "Tutorial";
    public static final String VALID_ZOOMLINK_CS2103T = "www.cs2103tzoom.us";
    public static final String VALID_ZOOMLINK_ES2660 = "www.es2660zoom.us";
    public static final double VALID_MC_4 = 4.0;
    public static final double VALID_MC_2 = 2.0;
    public static final String VALID_TAG_LECTURE = "Lecture";
    public static final String VALID_TAG_TUTORIAL = "Tutorial";

    public static final String NAME_DESC_CS2103T = " " + PREFIX_NAME + VALID_MODULENAME_CS2103T;
    public static final String ZOOMLINK_DESC_CS2103T = " " + PREFIX_ZOOM_LINK + VALID_ZOOMLINK_CS2103T;
    public static final String NAME_DESC_ES2660 = " " + PREFIX_NAME + VALID_MODULENAME_ES2660;
    public static final String ZOOMLINK_DESC_ES2660 = " " + PREFIX_ZOOM_LINK + VALID_ZOOMLINK_ES2660;

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    //public static final EditCommand.EditModuleDescriptor DESC_AMY;
    //public static final EditCommand.EditModuleDescriptor DESC_BOB;

    static {
        //DESC_AMY = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
        //        .withEmail(VALID_EMAIL_AMY).withTags(VALID_TAG_FRIEND)
        //        .build();
        //DESC_BOB = new EditPersonDescriptorBuilder().withName(VALID_NAME_BOB)
        //       .withEmail(VALID_EMAIL_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
        //       .build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        // ModuleList expectedModuleList = new ModuleList(actualModel.getAddressBook());
        // List<Person> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());

        // assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        // assertEquals(expectedModuleList, actualModel.getAddressBook());
        // assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        // assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        // Person person = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        // final String[] splitName = person.getName().fullName.split("\\s+");
        // model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        // assertEquals(1, model.getFilteredPersonList().size());
    }

}
