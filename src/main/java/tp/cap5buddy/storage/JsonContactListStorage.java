package tp.cap5buddy.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import tp.cap5buddy.contacts.ContactList;



/**
 * A class to access CAP5Buddy data stored as a json file on the hard disk.
 */
public class JsonContactListStorage implements ContactListStorage {
    private static final Logger logger = LogsCenter.getLogger(JsonModuleListStorage.class);
    private Path filePath;

    public JsonContactListStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getContactListFilePath() {
        return filePath;
    }

    public Optional<ContactList> readContactList() throws DataConversionException {
        return readContactList(filePath);
    }

    @Override
    public Optional<ContactList> readContactList(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializableContactList> jsonContactList = JsonUtil.readJsonFile(
                filePath, JsonSerializableContactList.class);
        if (!jsonContactList.isPresent()) {
            return Optional.empty();
        }
        try {
            return Optional.of(jsonContactList.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    @Override
    public void saveContactList(ContactList contactList) throws IOException {
        saveContactList(contactList, filePath);
    }

    /**
     * Similar to {@link #saveContactList(ContactList)}.
     * @param contactList
     * @param filePath
     * @throws IOException
     */
    public void saveContactList(ContactList contactList, Path filePath) throws IOException {
        requireNonNull(contactList);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableContactList(contactList), filePath);
    }

}
