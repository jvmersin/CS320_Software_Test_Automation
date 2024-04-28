package org.project_one;

import java.util.UUID;

public class Contact {
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;


    public Contact(String firstName, String lastName, String phone, String address) {
        this.id = generateContactId();

        validateName(firstName, "firstName");
        validateName(lastName, "lastName");
        validatePhone(phone);
        validateAddress(address);

        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private void validateName(String name, String fieldName) {
        if (name == null || name.length() > 10) {
            throw new IllegalArgumentException(fieldName + " must be not null and cannot exceed 10 characters.");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("[0-9]+")) {
            throw new IllegalArgumentException("Phone must be not null, exactly 10 digits, and contain only numbers.");
        }
    }

    private void validateAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must be not null and cannot exceed 30 characters.");
        }
    }

    private String generateContactId() {
        return UUID.randomUUID().toString().substring(0, 10);
    }
}
