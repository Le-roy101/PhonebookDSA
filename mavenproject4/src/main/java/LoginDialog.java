import javax.swing.*;

/**
 *
 * @author clive
 */
public class LoginDialog {
    // Static username and password for simplicity
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";

    // Method to show the login dialog
    public static boolean showLoginDialog(JFrame parentFrame) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Use vertical layout

        // Create an image label
       ImageIcon icon = new ImageIcon("C:\\Users\\clive.DESKTOP-I6DVLAU\\Desktop\\DSA Project\\Phonebook\\resources\\admin.png");
 // Use correct resource path
        JLabel imageLabel = new JLabel(icon);

        // Create username and password fields
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);

        // Add the components to the panel
        panel.add(imageLabel); // Add the image label first
        panel.add(userLabel);
        panel.add(userField);
        panel.add(passLabel);
        panel.add(passField);

        // Show the login dialog
        int option = JOptionPane.showConfirmDialog(parentFrame, panel, "Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Check if the user clicked OK
        if (option == JOptionPane.OK_OPTION) {
            String userInput = userField.getText();               // Get username input
            String passInput = new String(passField.getPassword()); // Get password input

            // Compare the input values with the expected ones
            if (USERNAME.equals(userInput) && PASSWORD.equals(passInput)) {
                return true;  // Login successful
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Invalid username or password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
                return false;  // Login failed
            }
        }
        return false;  // User canceled login
    }
}
