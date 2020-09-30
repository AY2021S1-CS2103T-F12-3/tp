package tp.cap5buddy.logic.parser;

import tp.cap5buddy.logic.commands.AddModuleCommand;
import tp.cap5buddy.logic.commands.Command;
import tp.cap5buddy.logic.commands.ResultCommand;
import tp.cap5buddy.logic.commands.ViewModuleCommand;

/**
 * Represents the parser that handles View Module command.
 */
public class ViewModuleParser extends Parser {

    public Command parse(String userInput) {
        Tokenizer token = new Tokenizer(userInput);
        String[] mod = token.getWords();
        return new ViewModuleCommand(mod);
    }

}
