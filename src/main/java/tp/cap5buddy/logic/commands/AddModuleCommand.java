package tp.cap5buddy.logic.commands;

import tp.cap5buddy.contacts.ContactList;
import tp.cap5buddy.modules.Module;
import tp.cap5buddy.modules.ModuleList;

/**
 * Represents the AddModuleCommand class.
 */
public class AddModuleCommand extends Command {
    private static final String SUCCESS_MESSAGE = " has been added successfully!";
    private final String name;
    private final String link;

    /**
     * Represents the constructor to making the AddModuleCommand object.
     *
     * @param info array of tokenised info.
     */
    public AddModuleCommand(String[] info) {
        this.name = info[0];
        this.link = info[1];
    }

    /**
     * Executes the main function of this command, to create a new module.
     *
     * @return ResultCommand ResultCommand object.
     */
    public CommandResult execute(ModuleList modules, ContactList contacts) {
        if (this.link == null) {
            Module mod = new Module(this.name);
            modules.addModule(mod);
        } else {
            Module mod = new Module(this.name, this.link);
            modules.addModule(mod);
        }
        return new CommandResult(this.name + SUCCESS_MESSAGE, isExit());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
