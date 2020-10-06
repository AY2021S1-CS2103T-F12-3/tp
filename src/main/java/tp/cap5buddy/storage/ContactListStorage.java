package tp.cap5buddy.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import tp.cap5buddy.contacts.ContactList;

/**
 * Represents a storage for {@link tp.cap5buddy.contacts.ContactList}.
 */
public interface ContactListStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getContactListFilePath();

    /**
     * Returns ContactList data as a {@link ContactList}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ContactList> readContactList() throws DataConversionException, IOException;

    /**
     * @see #getContactListFilePath()
     */
    Optional<ContactList> readContactList(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ContactList} to the storage.
     * @param contactList cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveContactList(ContactList contactList) throws IOException;

    /**
     * @see #saveContactList(ContactList)
     */
    void saveContactList(ContactList contactList, Path filePath) throws IOException;

}
