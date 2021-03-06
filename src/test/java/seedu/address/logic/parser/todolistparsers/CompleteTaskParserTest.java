package seedu.address.logic.parser.todolistparsers;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TASK;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_TASK;
import static seedu.address.testutil.TypicalIndexes.INDEX_THIRD_TASK;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.todolistcommands.CompleteTaskCommand;

public class CompleteTaskParserTest {

    private CompleteTaskParser parser = new CompleteTaskParser();

    @Test
    public void parse_validArgs_returnsCompleteTaskCommand() {
        assertParseSuccess(parser, "1", new CompleteTaskCommand(INDEX_FIRST_TASK));

        assertParseSuccess(parser, "2", new CompleteTaskCommand(INDEX_SECOND_TASK));

        assertParseSuccess(parser, "3", new CompleteTaskCommand(INDEX_THIRD_TASK));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            CompleteTaskCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "#", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            CompleteTaskCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "-100", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            CompleteTaskCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "0", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            CompleteTaskCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "one", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            CompleteTaskCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "1.1", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            CompleteTaskCommand.MESSAGE_USAGE));

        assertParseFailure(parser, "1/2", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            CompleteTaskCommand.MESSAGE_USAGE));
    }
}
