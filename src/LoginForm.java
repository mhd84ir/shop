import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signupButton;
    private JLabel dontHaveAccount;

    public LoginForm() {
        // Setting up the frame
        setTitle("Login Form");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Creating left panel for login form
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        JLabel dontHaveAccount = new JLabel("Don't have an account?");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        signupButton = new JButton("Sign Up");

        gbc.gridx = 0;
        gbc.gridy = 0;
        leftPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        leftPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        leftPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        leftPanel.add(passwordField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        leftPanel.add(loginButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        leftPanel.add(dontHaveAccount, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        leftPanel.add(signupButton, gbc);

        // Adding action listeners
        loginButton.addActionListener(this);
        signupButton.addActionListener(this);

        // Creating right panel for image
        JPanel rightPanel = new JPanel();
        //Your file's name should  be based on your own OS
        JLabel imageLabel = new JLabel(new ImageIcon("/Users/mhd84.ir/uni/Shop-Project/src/photos/pexels-photo-3593865.png"));
//        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\pexels-photo-3593865.png"));
        rightPanel.add(imageLabel);

        // Adding panels to frame
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.CENTER);

        //to disable resizable option
        this.setResizable(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Placeholder for actual authentication logic
            if (new Signin().checkUsernameAndPassword(username,password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                new showProduct();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == signupButton) {
            JOptionPane.showMessageDialog(this, "Sign Up button clicked!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }
}
