import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class showProduct extends JFrame {
    static JFrame frame = new JFrame("Shop");

    static ArrayList<Product> products = new ArrayList<Product>();

    static int start = 0 , end = 3;
    static Product product = new Product();


    //Fonts
    static Font fontEnglishText = new Font("Times New Roman", Font.BOLD, 15);
    static Font fontEnglishButton = new Font("Times New Roman", Font.ITALIC, 19);

    //3 main Buttons
    static JButton profileButton = new JButton("My Profile");;
    static JButton cartButton = new JButton("Cart");
    static JButton homeButton = new JButton("Home");




    //Home panel
    static JPanel homePanel = new JPanel();
    //fields
    static JTextField searchField = new JTextField();
    //Buttons
    static JButton productdetails3 = new JButton("Details");
    static JButton productdetails1 = new JButton("Details");
    static JButton productdetails2 = new JButton("Details");
    static JButton showMoreButton = new JButton("More");




    //cart panel
    static JPanel cartPanel = new JPanel();
    //buttons
    static JButton addButton = new JButton("+");
    static JButton addButton1 = new JButton("+");
    static JButton addButton2 = new JButton("+");
    static JButton removeButton = new JButton("-");
    static JButton removeButton1 = new JButton("-");
    static JButton removeButton2 = new JButton("-");
    static JButton buyButton = new JButton("Buy :)");
    //labels
    static JLabel productName1 = new JLabel("Name :");
    static JLabel productName2 = new JLabel("Name :");
    static JLabel productName3 = new JLabel("Name :");
    static JLabel productPriceLabel1 = new JLabel("Price :");
    static JLabel productPriceLabel2 = new JLabel("Price :");
    static JLabel productPriceLabel3 = new JLabel("Price :");
    static JLabel nameExample1 = new JLabel("Pink");
    static JLabel nameExample2 = new JLabel("Green");
    static JLabel nameExample3 = new JLabel("Blue");
    static JLabel priceExample1 = new JLabel("1000");
    static JLabel priceExample2 = new JLabel("1500");
    static JLabel priceExample3 = new JLabel("2000");



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
    static JPanel productDetailsPanel = new JPanel();
    //labels
    static JLabel name = new JLabel("Name :");
    static JLabel price = new JLabel("Price :");
    static JLabel numberOfProducts = new JLabel("Stock :");
    static JLabel addToCart = new JLabel("Add to cart :");
    //Buttons
    static JButton addToCartButton = new JButton("Click");



    //change Password Panel
    static JPanel changePasswordPanel = new JPanel();
    //text filed
    static JTextField oldPassword = new JTextField();
    static JTextField newPassword = new JTextField();
    //buttons
    static JButton changePassword = new JButton("Change");
    //labels
    static JLabel oldPass = new JLabel("Old password :");
    static JLabel newPass = new JLabel("New password :");




    //Deposit panel
    static JPanel depositPanel = new JPanel();
    //labels
    static JLabel amount = new JLabel("How much you want to add to your credit ?");
    //text field
    static JTextField amountField = new JTextField();
    //Buttons
    static JButton addToCreditButton = new JButton("Add");



    //previous purchase panel
    static JPanel previousPurchasePanel = new JPanel();



    public showProduct() {


        products = product.getAllProductFromDB();



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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        home();

        frame.setResizable(false);
        frame.setVisible(true);
    }


    private static void home()
    {
        //get products from db

        Product [] products1 = new Product[3];
        for (int i = 0; i < 3; i++) {
            products1[i] = new Product();
        }
        int j = 0;
        for (int i = start; i < end; i++) {

            products1[j] = products.get(i);
            j++;
        }


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

        productdetails1.setBounds(170, 450, 100, 30);
        productdetails1.setFont(fontEnglishButton);
        homePanel.add(productdetails1);

        productdetails2.setBounds(550, 450, 100, 30);
        productdetails2.setFont(fontEnglishButton);
        homePanel.add(productdetails2);

        productdetails3.setBounds(930, 450, 100, 30);
        productdetails3.setFont(fontEnglishButton);
        homePanel.add(productdetails3);

        showMoreButton.setBounds(1100, 300, 100, 100);
        showMoreButton.setFont(fontEnglishButton);
        homePanel.add(showMoreButton);


        //pictures

        JLabel imageLabel1 = new JLabel(products1[0].getImageIcon());
        imageLabel1.setBounds(40,150,350,250);
        homePanel.add(imageLabel1);

        JLabel imageLabel2 = new JLabel(products1[1].getImageIcon());
        imageLabel2.setBounds(425,150,350,250);
        homePanel.add(imageLabel2);

        JLabel imageLabel3 = new JLabel(products1[2].getImageIcon());
        imageLabel3.setBounds(810,150,350,250);
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

        productdetails1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel imageLabel1 = new JLabel(products1[0].getImageIcon());


                frame.remove(homePanel);
                productDetails(products1[0].getProductName(), products1[0].getPrice(), products1[0].getStock(), imageLabel1);
                frame.repaint();
                frame.revalidate();
            }
        });

        productdetails2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel imageLabel2 = new JLabel(products1[1].getImageIcon());


                frame.remove(homePanel);
                productDetails(products1[1].getProductName(), products1[1].getPrice(), products1[1].getStock(), imageLabel2);
                frame.repaint();
                frame.revalidate();

            }
        });

        productdetails3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel imageLabel3 = new JLabel(products1[2].getImageIcon());

                frame.remove(homePanel);
                productDetails(products1[2].getProductName(), products1[2].getPrice(), products1[2].getStock(), imageLabel3);
                frame.repaint();
                frame.revalidate();

            }
        });

        showMoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                showMoreProduct();
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

        //Buttons

        addButton.setBounds(815, 300, 50, 50);
        addButton.setFont(fontEnglishButton);
        cartPanel.add(addButton);

        addButton1.setBounds(430, 300, 50, 50);
        addButton1.setFont(fontEnglishButton);
        cartPanel.add(addButton1);


        addButton2.setBounds(50, 300, 50, 50);
        addButton2.setFont(fontEnglishButton);
        cartPanel.add(addButton2);


        removeButton.setBounds(815, 350, 50, 50);
        removeButton.setFont(fontEnglishButton);
        cartPanel.add(removeButton);

        removeButton1.setBounds(430, 350, 50, 50);
        removeButton1.setFont(fontEnglishButton);
        cartPanel.add(removeButton1);


        removeButton2.setBounds(50, 350, 50, 50);
        removeButton2.setFont(fontEnglishButton);
        cartPanel.add(removeButton2);

        buyButton.setBounds(520, 450, 150, 40);
        buyButton.setFont(fontEnglishButton);
        cartPanel.add(buyButton);

        //Labels

        productName1.setBounds(815, 150, 50, 50);
        productName1.setFont(fontEnglishText);
        cartPanel.add(productName1);


        productName2.setBounds(430, 150, 50, 50);
        productName2.setFont(fontEnglishText);
        cartPanel.add(productName2);


        productName3.setBounds(50, 150, 50, 50);
        productName3.setFont(fontEnglishText);
        cartPanel.add(productName3);


        productPriceLabel1.setBounds(815, 220, 50, 50);
        productPriceLabel1.setFont(fontEnglishText);
        cartPanel.add(productPriceLabel1);


        productPriceLabel2.setBounds(430, 220, 50, 50);
        productPriceLabel2.setFont(fontEnglishText);
        cartPanel.add(productPriceLabel2);


        productPriceLabel3.setBounds(50, 220, 50, 50);
        productPriceLabel3.setFont(fontEnglishText);
        cartPanel.add(productPriceLabel3);


        nameExample1.setBounds(815, 180, 50, 50);
        nameExample1.setFont(fontEnglishText);
        cartPanel.add(nameExample1);


        nameExample2.setBounds(430, 180, 50, 50);
        nameExample2.setFont(fontEnglishText);
        cartPanel.add(nameExample2);


        nameExample3.setBounds(50, 180, 50, 50);
        nameExample3.setFont(fontEnglishText);
        cartPanel.add(nameExample3);


        priceExample1.setBounds(815, 250, 50, 50);
        priceExample1.setFont(fontEnglishText);
        cartPanel.add(priceExample1);


        priceExample2.setBounds(430, 250, 50, 50);
        priceExample2.setFont(fontEnglishText);
        cartPanel.add(priceExample2);


        priceExample3.setBounds(50, 250, 50, 50);
        priceExample3.setFont(fontEnglishText);
        cartPanel.add(priceExample3);

        //Pictures


        JLabel imageLabel1 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p5.jpg"));
        imageLabel1.setBounds(40,150,350,250);
        cartPanel.add(imageLabel1);

        JLabel imageLabel2 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p2.jpg"));
        imageLabel2.setBounds(425,150,350,250);
        cartPanel.add(imageLabel2);

        JLabel imageLabel3 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p6.jpg"));
        imageLabel3.setBounds(810,150,350,250);
        cartPanel.add(imageLabel3);

        //Action Listeners
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(cartPanel);
                home();
                frame.repaint();
                frame.revalidate();

            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(cartPanel);
                profile();
                frame.repaint();
                frame.revalidate();

            }
        });


        frame.add(cartPanel);


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
        userNameField.setEditable(false);
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
        JLabel imageLabel = new JLabel(new ImageIcon("/Users/mhd84.ir/uni/Shop-Project/src/photos/Screenshot 2024-06-27 203609.png"));

//        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\Screenshot 2024-06-27 203609.png"));
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

        editInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                user.setName(nameField.getText());
                user.setAddress(addressField.getText());
                user.setPhoneNumber(phoneNumberField.getText());
                user.setEmail(emailField.getText());

                if (user.editProfile())
                {
                    JOptionPane.showMessageDialog(frame, "Information edited successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Error editing information");
                }

            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(profilePanel);
                changePassword();
                frame.repaint();
                frame.revalidate();

            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(profilePanel);
                deposit();
                frame.repaint();
                frame.revalidate();

            }
        });

        PreviousPurchasesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(profilePanel);
                previousPurchase();
                frame.repaint();
                frame.revalidate();
            }
        });



        frame.add(profilePanel);

    }

    private static void productDetails(String Name, double Price, int Stock ,JLabel imageLabel )
    {

        productDetailsPanel.setSize(1200,700);
        productDetailsPanel.setBackground(Color.LIGHT_GRAY);
        productDetailsPanel.setLayout(null);

        //labels

        name.setBounds(50, 0, 100, 100);
        name.setFont(fontEnglishText);
        name.setText(Name);
        productDetailsPanel.add(name);

        price.setBounds(50, 100, 100, 100);
        price.setFont(fontEnglishText);
        price.setText(Double.toString(Price));
        productDetailsPanel.add(price);

        numberOfProducts.setBounds(50, 200, 100, 100);
        numberOfProducts.setFont(fontEnglishText);
        numberOfProducts.setText(Integer.toString(Stock));
        productDetailsPanel.add(numberOfProducts);

        addToCart.setBounds(50, 300, 100, 100);
        addToCart.setFont(fontEnglishText);
        productDetailsPanel.add(addToCart);



        imageLabel.setBounds(810,150,350,250);
        productDetailsPanel.add(imageLabel);

        //buttons

        addToCartButton.setBounds(150, 330, 150, 35);
        addToCartButton.setFont(fontEnglishButton);
        productDetailsPanel.add(addToCartButton);





        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(productDetailsPanel);
                home();
                frame.repaint();
                frame.revalidate();


            }
        });

        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(productDetailsPanel);
                cart();
                frame.repaint();
                frame.revalidate();

            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(productDetailsPanel);
                profile();
                frame.repaint();
                frame.revalidate();

            }
        });



        frame.add(productDetailsPanel);

    }



    private static void changePassword(){
        changePasswordPanel.setSize(1200,700);
        changePasswordPanel.setBackground(Color.LIGHT_GRAY);
        changePasswordPanel.setLayout(null);

        //text fields
        oldPassword.setBounds(380, 170, 400, 40);
        oldPassword.setFont(fontEnglishText);
        changePasswordPanel.add(oldPassword);

        newPassword.setBounds(380, 270, 400, 40);
        newPassword.setFont(fontEnglishText);
        changePasswordPanel.add(newPassword);

        //Buttons
        changePassword.setBounds(530, 400, 100, 50);
        changePassword.setFont(fontEnglishButton);
        changePasswordPanel.add(changePassword);

        //text labels
        oldPass.setBounds(250, 170, 100, 40);
        oldPass.setFont(fontEnglishText);
        changePasswordPanel.add(oldPass);

        newPass.setBounds(250, 270, 200, 40);
        newPass.setFont(fontEnglishText);
        changePasswordPanel.add(newPass);

        //Action listeners
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(changePasswordPanel);
                home();
                frame.repaint();
                frame.revalidate();


            }
        });

        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(changePasswordPanel);
                cart();
                frame.repaint();
                frame.revalidate();

            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(changePasswordPanel);
                profile();
                frame.repaint();
                frame.revalidate();

            }
        });

        changePassword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (user.changePassword(oldPassword.getText(), newPassword.getText()))
                {
                    JOptionPane.showMessageDialog(frame, "Password changed successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Error changing password");
                }
            }
        });


        frame.add(changePasswordPanel);

    }

    private static void deposit(){
        depositPanel.setSize(1200,700);
        depositPanel.setBackground(Color.LIGHT_GRAY);
        depositPanel.setLayout(null);

        //text labels
        amount.setBounds(450, 200, 500, 40);
        amount.setFont(fontEnglishText);
        depositPanel.add(amount);

        //text field
        amountField.setBounds(380, 300, 400, 40);
        amountField.setFont(fontEnglishText);
        depositPanel.add(amountField);

        //Buttons
        addToCreditButton.setBounds(530, 400, 100, 50);
        addToCreditButton.setFont(fontEnglishButton);
        depositPanel.add(addToCreditButton);

        //Action listeners
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(depositPanel);
                home();
                frame.repaint();
                frame.revalidate();


            }
        });

        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(depositPanel);
                cart();
                frame.repaint();
                frame.revalidate();

            }
        });

        profileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(depositPanel);
                profile();
                frame.repaint();
                frame.revalidate();

            }
        });


        frame.add(depositPanel);

    }


    private static void previousPurchase(){
        //new frame
        JFrame previousPurchaseFrame = new JFrame();

        previousPurchasePanel.setSize(1200,700);
        previousPurchasePanel.setBackground(Color.LIGHT_GRAY);
        previousPurchasePanel.setLayout(null);

        // Create a JPanel to hold the grid
        JPanel panel = new JPanel(new GridLayout(50 , 4));

        // Adding headers to the first row
        String[] headers = {"ID","Name","Price"};
        for (String header : headers) {
            panel.add(new JLabel(header));
        }

//         Add 100 rows of 8 JTextFields and 1 JButton
        for (int row = 0; row < 50; row++) {
            for (int col = 0; col < 2; col++) {
                panel.add(new JTextField());

            }
        }

//        // Add all users of 8 JTextFields and 1 JButton
//        for (User user : users) {
//            panel.add(new JTextField(String.valueOf(user.getID())));
//            panel.add(new JTextField(user.getUserName()));
//            panel.add(new JTextField(user.getName()));
//            panel.add(new JTextField(user.getPhoneNumber()));
//            panel.add(new JTextField(user.getEmail()));
//            panel.add(new JTextField(user.getAddress()));
//            panel.add(new JTextField(String.valueOf(user.getCredit())));
//            panel.add(new JTextField(user.getRole()));
//            JButton button = new JButton("Edit");
//            panel.add(button);
//        }

        previousPurchaseFrame.add(panel);

        // Add the panel to the JFrame
        previousPurchaseFrame.add(new JScrollPane(panel));

        // Set the size of the JFrame
        previousPurchaseFrame.setSize(1000, 500);
        // Set the visibility of the JFrame
        previousPurchaseFrame.setVisible(true);


    }

    public static void showMoreProduct(){

    }



    public static void main(String[] args) {
        new showProduct();
    }

}