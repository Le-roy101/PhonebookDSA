import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private final PhoneBook phoneBook;

    public MainMenu(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
        JFrame frame = new JFrame("Main Menu");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1)); // Four buttons in a vertical grid layout

        JButton addContactButton = new JButton("Add Contact");
        JButton searchContactButton = new JButton("Search Contact");
        JButton displayContactsButton = new JButton("Display All Contacts");
        JButton exitButton = new JButton("Exit");

        // Add button actions
        addContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddContactGUI(phoneBook); // Open add contact window
            }
        });

        searchContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchContactGUI(phoneBook); // Open search contact window
            }
        });

        displayContactsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisplayContactsGUI(phoneBook); // Open display contacts window
            }
        });

        exitButton.addActionListener(e -> System.exit(0)); // Exit application

        // Add buttons to frame
        frame.add(addContactButton);
        frame.add(searchContactButton);
        frame.add(displayContactsButton);
        frame.add(exitButton);
        frame.setVisible(true);
    }
}
