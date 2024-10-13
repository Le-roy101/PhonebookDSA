import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddContactGUI {
    private final PhoneBook phoneBook;

    // List of towns in Namibia
    private static final String[] NAMIBIA_TOWNS = {
        "Windhoek", "Swakopmund", "Walvis Bay", "Oshakati", "Rundu",
        "Omaha", "Lüderitz", "Keetmanshoop", "Tsumeb", "Outjo",
        "Henties Bay", "Grootfontein", "Otjiwarongo", "Okahandja", "Mariental"
    };

    public AddContactGUI(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        JFrame frame = new JFrame("Add Contact");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        JPanel buttonPanel = new JPanel();

        // Input fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone Number:");
        JTextField phoneField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel townLabel = new JLabel("Select Town:");
        JComboBox<String> townDropdown = new JComboBox<>(NAMIBIA_TOWNS);

        // Add input components to inputPanel
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneLabel);
        inputPanel.add(phoneField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(townLabel);
        inputPanel.add(townDropdown);

        // Add Contact Button
        JButton addButton = new JButton("Add Contact");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phone = phoneField.getText();
                String email = emailField.getText();
                String town = (String) townDropdown.getSelectedItem();

                if (name.isEmpty() || phone.isEmpty() || email.isEmpty() || town == null) {
                    JOptionPane.showMessageDialog(frame, "All fields must be filled!", "Input Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                phoneBook.insertContact(new Contact(name, phone, email + " - " + town));
                JOptionPane.showMessageDialog(frame, "Contact Added!");
                clearFields();
            }

            private void clearFields() {
                nameField.setText("");
                phoneField.setText("");
                emailField.setText("");
                townDropdown.setSelectedIndex(0);
            }
        });

        buttonPanel.add(addButton);

        // Add panels to frame
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
