import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingupForm extends JFrame implements ActionListener {
    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public SingupForm() {
        // Create a new JFrame
        frame = new JFrame("Signup Form");
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create a panel for the form with padding
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Create labels and text fields for username and password
        JLabel titleLabel = new JLabel("Signup Form", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField();
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField();
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(confirmPasswordLabel, gbc);

        confirmPasswordField = new JPasswordField();
        gbc.gridx = 1;
        panel.add(confirmPasswordField, gbc);

        // Create a signup button
        JButton signupButton = new JButton("Sign Up");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        signupButton.addActionListener(this);
        panel.add(signupButton, gbc);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Set the frame to be visible
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        // Simple validation to check if passwords match
        if (password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(frame, "Signup successful!");
        } else {
            JOptionPane.showMessageDialog(frame, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new SingupForm();
    }
}
