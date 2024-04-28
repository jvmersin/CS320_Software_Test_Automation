import org.project_one.Contact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    @DisplayName("should create a new contact")
    public void testValidContactCreation() {
        String firstName = "John";
        String lastName = "Doe";
        String phone = "1234567890";
        String address = "123 Main St";

        Contact contact = new Contact(firstName, lastName, phone, address);

        assertNotNull(contact.getId());
        assertEquals(firstName, contact.getFirstName());
        assertEquals(lastName, contact.getLastName());
        assertEquals(phone, contact.getPhone());
        assertEquals(address, contact.getAddress());
    }

    @Test
    @DisplayName("should throw an error for invalid first name length")
    public void testInvalidFirstNameLength() {
        String longName = "JamesEhrenberg";
        String lastName = "Ehrenberg";
        String phone = "1234567890";
        String address = "123 Main St";

        assertThrows(IllegalArgumentException.class, () -> new Contact(longName, lastName, phone, address));
    }

    @Test
    @DisplayName("should throw an error for invalid last name length")
    public void testInvalidLastNameLength() {
        String firstName = "James";
        String longName = "JamesEhrenberg";
        String phone = "1234567890";
        String address = "123 Main St";

        assertThrows(IllegalArgumentException.class, () -> new Contact(firstName, longName, phone, address));
    }

    @Test
    @DisplayName("should throw an error for invalid phone number length")
    public void testInvalidPhoneLength() {
        String firstName = "James";
        String lastName = "Ehrenberg";
        String shortPhone = "1234567";
        String address = "123 Main St";

        assertThrows(IllegalArgumentException.class, () -> new Contact(firstName, lastName, shortPhone, address));
    }

    @Test
    @DisplayName("should throw an error for invalid phone number format")
    public void testInvalidPhoneFormat() {
        String firstName = "John";
        String lastName = "Doe";
        String invalidPhone = "12345abcde";
        String address = "123 Main St";

        assertThrows(IllegalArgumentException.class, () -> new Contact(firstName, lastName, invalidPhone, address));
    }

    @Test
    @DisplayName("should throw an error for invalid address length")
    public void testInvalidAddressLength() {
        String firstName = "John";
        String lastName = "Doe";
        String phone = "1234567890";
        String longAddress = "MyAddressIsVeryVeryLongAndIAmTypingItAllOutHere";

        assertThrows(IllegalArgumentException.class, () -> new Contact(firstName, lastName, phone, longAddress));
    }

    @Test
    @DisplayName("should throw an error for null first name entry")
    public void testNullFirstName() {
        String lastName = "Ehrenberg";
        String phone = "1234567890";
        String address = "123 Main St";

        assertThrows(IllegalArgumentException.class, () -> new Contact(null, lastName, phone, address));
    }

    @Test
    @DisplayName("should throw an error for null last name entry")
    public void testNullLastName() {
        String firstName = "James";
        String phone = "1234567890";
        String address = "123 Main St";

        assertThrows(IllegalArgumentException.class, () -> new Contact(firstName, null, phone, address));
    }

    @Test
    @DisplayName("should throw an error for null phone number entry")
    public void testNullPhone() {
        String firstName = "James";
        String lastName = "Ehrenberg";
        String address = "123 Main St";

        assertThrows(IllegalArgumentException.class, () -> new Contact(firstName, lastName, null, address));
    }

    @Test
    @DisplayName("should throw an error for null address entry")
    public void testNullAddress() {
        String firstName = "James";
        String lastName = "Ehrenberg";
        String phone = "1234567890";

        assertThrows(IllegalArgumentException.class, () -> new Contact(firstName, lastName, phone, null));
    }
}
