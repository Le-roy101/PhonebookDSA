
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();

            // Display login dialog and check if login is successful
            boolean isLoggedIn = LoginDialog.showLoginDialog(frame);
            if (isLoggedIn) {
                PhoneBook phoneBook = new PhoneBook();
                phoneBook.loadContactsFromFile("contacts.csv");
                new MainMenu(phoneBook); // Open main menu after login

                // Save contacts to file on exit
                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    phoneBook.saveContactsToFile("contacts.csv");
                }));
            } else {
                System.out.println("Login failed. Exiting...");
                System.exit(0);
            }
        });
    }
}
