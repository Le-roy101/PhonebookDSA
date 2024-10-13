import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchContactGUI {
    private final PhoneBook phoneBook;

    public SearchContactGUI(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        JFrame frame = new JFrame("Search Contact");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JLabel searchLabel = new JLabel("Enter contact name:");
        JTextField searchField = new JTextField(15);
        JButton searchButton = new JButton("Search");
        
        // Display area
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Search Button Action
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = searchField.getText();
                if (name != null && !name.isEmpty()) {
                    Contact contact = phoneBook.searchContact(name);
                    if (contact != null) {
                        resultArea.setText("Contact Found:\n" +
                                "Name: " + contact.getName() +
                                "\nPhone: " + contact.getPhoneNumber() +
                                "\nEmail: " + contact.getEmail());
                    } else {
                        resultArea.setText("Contact not found.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid name.");
                }
            }
        });

        // Add components to frame
        frame.add(searchLabel);
        frame.add(searchField);
        frame.add(searchButton);
        frame.add(scrollPane);
        frame.setVisible(true);
    }
}
