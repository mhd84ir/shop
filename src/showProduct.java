import javax.swing.*;
import java.awt.*;

public class showProduct extends JFrame {

    private JTextField textField;

    public showProduct() {
        setTitle("Bottom Buttons Demo");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(null); // Set layout to null for absolute positioning

        // Text field
        textField = new JTextField();
        textField.setBounds(300, 25, 600, 30); // x, y, width, height
        add(textField);

        // Buttons
        JButton homeButton = new JButton("My Profile");
        homeButton.setBounds(100, 600, 200, 50);
        add(homeButton);

        JButton cartButton = new JButton("Cart");
        cartButton.setBounds(500, 600, 200, 50);
        add(cartButton);

        JButton profileButton = new JButton("Home");
        profileButton.setBounds(900, 600, 200, 50);
        add(profileButton);

        JPanel customPanel = new JPanel();
        customPanel.setBounds(100, 105, 1000, 445);
        customPanel.setBackground(Color.LIGHT_GRAY); // Set background color
        add(customPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(showProduct::new);
    }
}