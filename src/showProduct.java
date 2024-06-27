import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class showProduct {
    static JFrame frame = new JFrame("Shop");

    //Fonts
    static Font fontEnglishText = new Font("Times New Roman", Font.BOLD, 15);
    static Font fontEnglishButton = new Font("Times New Roman", Font.ITALIC, 19);


    //3 main Buttons
    static JButton profileButton = new JButton("My Profile");;
    static JButton cartButton = new JButton("Cart");
    static JButton homeButton = new JButton("Home");


    //Home panel
    static JPanel homePanel = new JPanel();
    static JTextField searchField = new JTextField();
    static JButton productdetails = new JButton("Details");
    static JButton productdetails1 = new JButton("Details");
    static JButton productdetails2 = new JButton("Details");




    //cart panel
    static JPanel cartPanel = new JPanel();





    static User user = new User();


    //Profile panel
    static JPanel profilePanel = new JPanel();

    //text fields
    static JTextField nameField = new JTextField();
    static JTextField userNameField = new JTextField();
    static JTextField addressField = new JTextField();
    static JTextField phoneNumberField = new JTextField();
    static JTextField emailField = new JTextField();
    static JLabel creditLabel = new JLabel("your credit is : " + Double.toString(user.getCredit()) );

    //labels
//    static JLabel creditLabel = new JLabel("your credit is : " );
    static JLabel nameLabel = new JLabel("Name    :");
    static JLabel userNameLabel = new JLabel("Username:");
    static JLabel addressLabel = new JLabel("Address :");
    static JLabel phoneNumberLabel = new JLabel("Number :");
    static JLabel emailLabel = new JLabel("Email    :");

    //buttons
    static JButton depositButton = new JButton("Deposit");
    static JButton PreviousPurchasesButton = new JButton("Previous purchases");
    static JButton changePasswordButton = new JButton("Change password");
    static JButton editInfoButton = new JButton("Edit");


    //productDetails panel
    static JPanel productDetails = new JPanel();

    //labels
    static JLabel name = new JLabel("Name :");
    static JLabel price = new JLabel("Price :");
    static JLabel numberOfProduct = new JLabel(" :");
    static JLabel addToCart = new JLabel("Add to cart");

    //Buttons

    static JButton addToCartButton = new JButton("Click");


    public showProduct() {


        String[] info = new String[2];

        try {
            FileReader reader = new FileReader(new File("data.txt"));
            BufferedReader reader1 = new BufferedReader(reader);
            String line = reader1.readLine();



            info = line.split(",");

            reader1.close();
        }
        catch (IOException e)
        {
            System.out.println("error open");
        }

        user.getInfoDB(Integer.parseInt(info[0]),info[1]);



        Dimension frameSize = new Dimension(1200,700);
        frame.setSize(frameSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        home();

        frame.setResizable(false);
        frame.setVisible(true);
    }


    private static void home()
    {
        homePanel.setSize(1200,700);
        homePanel.setBackground(Color.LIGHT_GRAY);
        homePanel.setLayout(null);

        //fields

        searchField.setBounds(300, 25, 600, 50);
        searchField.setFont(fontEnglishText);
        homePanel.add(searchField);

        //buttons

        profileButton.setBounds(100, 600, 200, 50);
        profileButton.setFont(fontEnglishButton);
        frame.add(profileButton);

        cartButton.setBounds(500, 600, 200, 50);
        cartButton.setFont(fontEnglishButton);
        frame.add(cartButton);

        homeButton.setBounds(900, 600, 200, 50);
        homeButton.setFont(fontEnglishButton);
        frame.add(homeButton);

        productdetails.setBounds(170, 450, 100, 30);
        productdetails.setFont(fontEnglishButton);
        frame.add(productdetails);

        productdetails1.setBounds(530, 450, 100, 30);
        productdetails1.setFont(fontEnglishButton);
        frame.add(productdetails1);

        productdetails2.setBounds(890, 450, 100, 30);
        productdetails2.setFont(fontEnglishButton);
        frame.add(productdetails2);

        //pictures

        JLabel imageLabel1 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p5.jpg"));
        imageLabel1.setBounds(40,150,350,250);
        homePanel.add(imageLabel1);

        JLabel imageLabel2 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p2.jpg"));
        imageLabel2.setBounds(400,150,350,250);
        homePanel.add(imageLabel2);

        JLabel imageLabel3 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p6.jpg"));
        imageLabel3.setBounds(760,150,350,250);
        homePanel.add(imageLabel3);



        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                cart();
                frame.repaint();
                frame.revalidate();

            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                profile();
                frame.repaint();
                frame.revalidate();

            }
        });

        productdetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                productDetails();
                frame.repaint();
                frame.revalidate();

            }
        });

        productdetails1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                productDetails();
                frame.repaint();
                frame.revalidate();

            }
        });

        productdetails2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                productDetails();
                frame.repaint();
                frame.revalidate();

            }
        });



        frame.add(homePanel);

    }

    private static void cart()
    {
        cartPanel.setSize(1200,700);
        cartPanel.setBackground(Color.LIGHT_GRAY);
        cartPanel.setLayout(null);

        //TODO

    }

    private static void profile()
    {
        profilePanel.setSize(1200,700);
        profilePanel.setBackground(Color.LIGHT_GRAY);
        profilePanel.setLayout(null);

        //fields

        nameField.setBounds(150, 25, 500, 40);
        nameField.setFont(fontEnglishText);
        nameField.setText(user.getName());
        profilePanel.add(nameField);

        userNameField.setBounds(150,125,500,40);
        userNameField.setFont(fontEnglishText);
        userNameField.setText(user.getUserName());
        profilePanel.add(userNameField);

        addressField.setBounds(150, 225, 500, 40);
        addressField.setFont(fontEnglishText);
        addressField.setText(user.getAddress());
        profilePanel.add(addressField);

        phoneNumberField.setBounds(150, 325, 500, 40);
        phoneNumberField.setFont(fontEnglishText);
        phoneNumberField.setText(user.getPhoneNumber());
        profilePanel.add(phoneNumberField);

        emailField.setBounds(150, 425, 500, 40);
        emailField.setFont(fontEnglishText);
        emailField.setText(user.getEmail());
        profilePanel.add(emailField);

        //labels

        creditLabel.setBounds(750, 5, 200, 100);
        creditLabel.setFont(fontEnglishText);
        profilePanel.add(creditLabel);

        nameLabel.setBounds(50, 0, 100, 100);
        nameLabel.setFont(fontEnglishText);
        profilePanel.add(nameLabel);

        userNameLabel.setBounds(50,100 , 100, 100);
        userNameLabel.setFont(fontEnglishText);
        profilePanel.add(userNameLabel);

        addressLabel.setBounds(50, 200, 100, 100);
        addressLabel.setFont(fontEnglishText);
        profilePanel.add(addressLabel);

        phoneNumberLabel.setBounds(50, 300, 300, 100);
        phoneNumberLabel.setFont(fontEnglishText);
        profilePanel.add(phoneNumberLabel);

        emailLabel.setBounds(50, 400, 100, 100);
        emailLabel.setFont(fontEnglishText);
        profilePanel.add(emailLabel);

        //buttons

        depositButton.setBounds(1000, 43, 100, 30);
        depositButton.setFont(fontEnglishButton);
        profilePanel.add(depositButton);

        PreviousPurchasesButton.setBounds(700, 425, 190, 50);
        PreviousPurchasesButton.setFont(fontEnglishButton);
        profilePanel.add(PreviousPurchasesButton);

        changePasswordButton.setBounds(950, 425, 190, 50);
        changePasswordButton.setFont(fontEnglishButton);
        profilePanel.add(changePasswordButton);

        editInfoButton.setBounds(350, 500, 100, 30);
        editInfoButton.setFont(fontEnglishButton);
        profilePanel.add(editInfoButton);



        //pictures
//        JLabel imageLabel = new JLabel(new ImageIcon("/Users/mhd84.ir/uni/Shop-Project/src/photos/Screenshot 2024-06-27 203609.png"));

        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\Screenshot 2024-06-27 203609.png"));
        imageLabel.setBounds(725,80,400,330);
        profilePanel.add(imageLabel);


        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(profilePanel);
                home();
                frame.repaint();
                frame.revalidate();

            }
        });

        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(profilePanel);
                cart();
                frame.repaint();
                frame.revalidate();

            }
        });

        frame.add(profilePanel);


    }

    private static void productDetails()
    {
        profilePanel.setSize(1200,700);
        profilePanel.setBackground(Color.LIGHT_GRAY);
        profilePanel.setLayout(null);







    }

    public static void main(String[] args) {
        new showProduct();
    }

}