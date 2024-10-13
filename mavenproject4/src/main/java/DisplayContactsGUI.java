import javax.swing.*;
import java.awt.*;

public class DisplayContactsGUI {
    private final PhoneBook phoneBook;

    public DisplayContactsGUI(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        JFrame frame = new JFrame("Display All Contacts");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);

        StringBuilder allContacts = new StringBuilder();
        for (Contact contact : phoneBook.getAllContacts()) {
            allContacts.append("Name: ").append(contact.getName())
                    .append(", Phone: ").append(contact.getPhoneNumber())
                    .append(", Email: ").append(contact.getEmail()).append("\n");
        }

        displayArea.setText(allContacts.toString());
        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
