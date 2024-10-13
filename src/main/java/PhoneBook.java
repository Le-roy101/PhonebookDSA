import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clive
 */
public class PhoneBook {
    private final List<Contact> contacts = new ArrayList<>();

    // Insert a new contact

    /**
     *
     * @param contact
     */
    public void insertContact(Contact contact) {
        contacts.add(contact);
    }

    // Search for a contact by name

    /**
     *
     * @param name
     * @return
     */
    public Contact searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    // Save contacts to a CSV file

    /**
     *
     * @param fileName
     */
    public void saveContactsToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Contact contact : contacts) {
                writer.write(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    // Load contacts from a CSV file

    /**
     *
     * @param fileName
     */
    public void loadContactsFromFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Contacts file not found. A new file will be created.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");
                if (details.length == 3) {
                    contacts.add(new Contact(details[0], details[1], details[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }

    // Get all contacts as a List

    /**
     *
     * @return
     */
    public List<Contact> getAllContacts() {
        return contacts;
    }
}
