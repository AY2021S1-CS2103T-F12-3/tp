package tp.cap5buddy.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import tp.cap5buddy.contacts.ContactList;
import tp.cap5buddy.modules.ModuleList;

/**
 * Manages storage of CAP5Buddy data in local storage.
 */
public class StorageManager implements Storage {

    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private ModuleListStorage moduleListStorage;
    private ContactListStorage contactListStorage;

    /**
     * Creates a {@code StorageManager} with the given {@code ModuleListStorage} and {@code UserPrefStorage}.
     */
    public StorageManager(ModuleListStorage moduleListStorage,
                          ContactListStorage contactListStorage) {
        super();
        this.moduleListStorage = moduleListStorage;
        this.contactListStorage = contactListStorage;
    }
    @Override
    public Path getModuleListFilePath() {
        return moduleListStorage.getModuleListFilePath();
    }

    @Override
    public Optional<ModuleList> readModuleList() throws DataConversionException, IOException {
        return readModuleList(moduleListStorage.getModuleListFilePath());
    }

    @Override
    public Optional<ModuleList> readModuleList(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return moduleListStorage.readModuleList(filePath);
    }

    @Override
    public void saveModuleList(ModuleList moduleList) throws IOException {
        saveModuleList(moduleList, moduleListStorage.getModuleListFilePath());
    }

    @Override
    public void saveModuleList(ModuleList moduleList, Path filePath) throws IOException {
        moduleListStorage.saveModuleList(moduleList, filePath);
    }

    @Override
    public Path getContactListFilePath() {
        return contactListStorage.getContactListFilePath();
    }

    @Override
    public Optional<ContactList> readContactList() throws DataConversionException, IOException {
        return readContactList(contactListStorage.getContactListFilePath());
    }

    @Override
    public Optional<ContactList> readContactList(Path filePath) throws DataConversionException, IOException {
        logger.fine("Attempting to read data from file: " + filePath);
        return contactListStorage.readContactList(filePath);
    }

    @Override
    public void saveContactList(ContactList contactList) throws IOException {
        saveContactList(contactList, contactListStorage.getContactListFilePath());
    }

    @Override
    public void saveContactList(ContactList contactList, Path filePath) throws IOException {
        contactListStorage.saveContactList(contactList, filePath);
    }

}
