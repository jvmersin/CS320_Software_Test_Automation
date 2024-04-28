import org.project_one.Contact;
import org.project_one.ContactService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    @Test
    @DisplayName("should add a new contact into the contact service")
    public void testAddContact() {
        ContactService service = new ContactService();

        String firstName = "James";
        String lastName = "Ehrenberg";
        String phone = "1234567890";
        String address = "123 Main St";

        Contact contact = service.addContact(firstName, lastName, phone, address);

        assertNotNull(contact);
        assertEquals(10, contact.getId().length());
        assertEquals(firstName, contact.getFirstName());
        assertEquals(lastName, contact.getLastName());
        assertEquals(phone, contact.getPhone());
        assertEquals(address, contact.getAddress());
    }

    @Test
    @DisplayName("should delete a contact from the contact service")
    public void testDeleteContact() {
        ContactService service = new ContactService();

        String firstName = "James";
        String lastName = "Ehrenberg";
        String phone = "1234567890";
        String address = "123 Main St";

        Contact contact = service.addContact(firstName, lastName, phone, address);
        String contactId = contact.getId();

        service.deleteContact(contactId);

        assertThrows(IllegalArgumentException.class, () -> service.updateContact(contactId, "firstName", "Updated Name"));
    }

    @Test
    @DisplayName("should update first name by contact id")
    public void testUpdateContact_FirstName() {
        ContactService service = new ContactService();

        String firstName = "James";
        String lastName = "Ehrenberg";
        String phone = "1234567890";
        String address = "123 Main St";

        Contact contact = service.addContact(firstName, lastName, phone, address);
        String contactId = contact.getId();

        String updatedFirstName = "Jane";
        service.updateContact(contactId, "firstName", updatedFirstName);

        assertEquals(updatedFirstName, contact.getFirstName());
    }

    @Test
    @DisplayName("should update last name by contact id")
    public void testUpdateContact_LastName() {
        ContactService service = new ContactService();

        String firstName = "James";
        String lastName = "Ehrenberg";
        String phone = "1234567890";
        String address = "123 Main St";

        Contact contact = service.addContact(firstName, lastName, phone, address);
        String contactId = contact.getId();

        String updatedLastName = "Gagliardi";
        service.updateContact(contactId, "lastName", updatedLastName);

        assertEquals(updatedLastName, contact.getLastName());
    }

    @Test
    @DisplayName("should update phone number by contact id")
    public void testUpdateContact_Phone() {
        ContactService service = new ContactService();

        String firstName = "James";
        String lastName = "Ehrenberg";
        String phone = "1234567890";
        String address = "123 Main St";

        Contact contact = service.addContact(firstName, lastName, phone, address);
        String contactId = contact.getId();

        String updatedPhone = "0987654321";
        service.updateContact(contactId, "phone", updatedPhone);

        assertEquals(updatedPhone, contact.getPhone());
    }

    @Test
    @DisplayName("should update address by contact id")
    public void testUpdateContact_Address() {
        ContactService service = new ContactService();

        String firstName = "James";
        String lastName = "Ehrenberg";
        String phone = "1234567890";
        String address = "123 Main St";

        Contact contact = service.addContact(firstName, lastName, phone, address);
        String contactId = contact.getId();

        String updatedAddress = "678 Main St";
        service.updateContact(contactId, "address", updatedAddress);

        assertEquals(updatedAddress, contact.getAddress());
    }

    @Test
    @DisplayName("should throw an error for updating invalid field")
    public void testUpdateContact_InvalidField() {
        ContactService service = new ContactService();

        String firstName = "James";
        String lastName = "Ehrenberg";
        String phone = "1234567890";
        String address = "123 Main St";

        Contact contact = service.addContact(firstName, lastName, phone, address);
        String contactId = contact.getId();

        assertThrows(IllegalArgumentException.class, () -> service.updateContact(contactId, "invalidField", "Some Value"));
    }

    @Test
    @DisplayName("should throw an error for invalid contact id")
    public void testUpdateContact_NonexistentId() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.updateContact("invalidId", "firstName", "Updated Name"));
    }
}
