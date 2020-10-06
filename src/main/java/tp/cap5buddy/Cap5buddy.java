package tp.cap5buddy;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import tp.cap5buddy.contacts.ContactList;
import tp.cap5buddy.logic.LogicManager;
import tp.cap5buddy.logic.commands.CommandResult;
import tp.cap5buddy.logic.commands.exception.CommandException;
import tp.cap5buddy.logic.parser.exception.ParseException;
import tp.cap5buddy.modules.ModuleList;
import tp.cap5buddy.storage.JsonContactListStorage;
import tp.cap5buddy.storage.JsonModuleListStorage;
import tp.cap5buddy.storage.StorageManager;
import tp.cap5buddy.ui.Ui;



/**
 * Represents the cap5buddy program.
 */
public class Cap5buddy {

    /**
     * Represents the main body of the program.
     */
    public static void main(String[] args) throws ParseException, CommandException {
        // Start up, create the UI object
        Ui userInterface = new Ui();
        userInterface.startScanner(); // creates the scanner
        run(userInterface);
    }

    private static void run(Ui ui) throws ParseException, CommandException {
        boolean isExit = false;
        Path contactsSaveDir = Paths.get(".\\data\\contactList.json");
        Path modulesSaveDir = Paths.get(".\\data\\moduleList.json");
        JsonModuleListStorage moduleStorageList = new JsonModuleListStorage(modulesSaveDir);
        JsonContactListStorage contactStorageList = new JsonContactListStorage(contactsSaveDir);
        StorageManager storage = new StorageManager(moduleStorageList, contactStorageList);
        ModuleList moduleList;
        ContactList contactList;
        try {
            Optional<ModuleList> optionalModuleList = moduleStorageList.readModuleList();
            if (optionalModuleList.isEmpty()) {
                moduleList = new ModuleList(new ArrayList<>());
            } else {
                moduleList = moduleStorageList.readModuleList().get();
            }
            Optional<ContactList> optionalContactList = contactStorageList.readContactList();
            if (optionalContactList.isEmpty()) {
                contactList = new ContactList(new ArrayList<>());
            } else {
                contactList = contactStorageList.readContactList().get();
            }
        } catch (DataConversionException e) {
            System.out.println(e.getMessage());
            moduleList = new ModuleList(new ArrayList<>());
            contactList = new ContactList(new ArrayList<>());
        }
        LogicManager lm = new LogicManager(storage, moduleList, contactList);
        while (!isExit) {
            String current = ui.getInput();
            CommandResult res = lm.execute(current);
            isExit = res.getExit();
            ui.printResult(res.getMessage());
        }
        ui.closeScanner();
    }
}
