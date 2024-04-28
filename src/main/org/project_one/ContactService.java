package org.project_one;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private final Map<String, Contact> contacts;

    public ContactService() {
        this.contacts = new HashMap<>();
    }

    public Contact addContact(String firstName, String lastName, String phone, String address) {
        Contact contact = new Contact(firstName, lastName, phone, address);
        String contactId = contact.getId();
        contacts.put(contactId, contact);
        return contact;
    }

    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String fieldToUpdate, String newValue) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact with ID " + contactId + " not found.");
        }

        Contact contact = contacts.get(contactId);
        switch (fieldToUpdate.toLowerCase()) {
            case "firstname":
                contact.setFirstName(newValue);
                break;
            case "lastname":
                contact.setLastName(newValue);
                break;
            case "phone":
                contact.setPhone(newValue);
                break;
            case "address":
                contact.setAddress(newValue);
                break;
            default:
                throw new IllegalArgumentException("Invalid field to update: " + fieldToUpdate);
        }
    }
}
