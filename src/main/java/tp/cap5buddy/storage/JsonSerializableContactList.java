package tp.cap5buddy.storage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.commons.exceptions.IllegalValueException;
import tp.cap5buddy.contacts.Contact;
import tp.cap5buddy.contacts.ContactList;


/**
 * An Immutable ContactList that is serializable to JSON format.
 */
@JsonRootName(value = "addressbook")
class JsonSerializableContactList {

    public static final String MESSAGE_DUPLICATE_PERSON = "Contacts list contains duplicate module(s).";

    private final List<JsonAdaptedContact> contacts = new ArrayList<>();

    /**
     * Constructs a {@code JsonSerializableContactList} with the given contacts.
     */
    @JsonCreator
    public JsonSerializableContactList(@JsonProperty("contacts") List<JsonAdaptedContact> contacts) {
        this.contacts.addAll(contacts);
    }

    /**
     * Converts a given {@code ContactList} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableContactList}.
     */
    public JsonSerializableContactList(ContactList source) {
        contacts.addAll(source.getContactList().stream().map(JsonAdaptedContact::new).collect(Collectors.toList()));
    }

    /**
     * Converts this contact list into the model's {@code ContactList} object.
     *
     * @throws IllegalValueException if there were any data constraints violated.
     */
    public ContactList toModelType() throws IllegalValueException {
        ContactList contactList = new ContactList();
        for (JsonAdaptedContact jsonAdaptedContact: contacts) {
            Contact contact = jsonAdaptedContact.toModelType();
            contactList.addContact(contact);
        }
        return contactList;
    }

}
