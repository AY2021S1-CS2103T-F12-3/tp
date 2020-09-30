package tp.cap5buddy.logic.commands;

import tp.cap5buddy.modules.Module;
import tp.cap5buddy.modules.ModuleList;

import java.util.ArrayList;

/**
 * Represents the AddModuleCommand class.
 */
public class ViewModuleCommand extends Command {
    private static final String SUCCESS_MESSAGE = "Module details have been displayed successfully!";
    private ArrayList<Module> modules;
    private String moduleName;
    //need a storage system
    public ViewModuleCommand(String[] moduleName) {
        this.moduleName = moduleName[2];
    }

    /**
     * Executes the main function of this command, to create a new module.
     * @return String success message.
     */
    public ResultCommand execute(ModuleList modules) {
        Module moduleToBeDisplayed = modules.getModule(moduleName);
        return new ResultCommand(moduleToBeDisplayed.toString() + "\n" +
                SUCCESS_MESSAGE, isExit());
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