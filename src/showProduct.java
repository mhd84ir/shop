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

    //fields
    static JTextField searchField = new JTextField();

    //Buttons
    static JButton productdetails3 = new JButton("Details");
    static JButton productdetails1 = new JButton("Details");
    static JButton productdetails2 = new JButton("Details");
    static JButton nextButton = new JButton("=>");



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



    //nextPage panel
    static JPanel nextPagePanel = new JPanel();

    //buttons
    static JButton nextPageButton = new JButton("=>");
    static JButton previousPageButton = new JButton("<=");



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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        productdetails3.setBounds(170, 450, 100, 30);
        productdetails3.setFont(fontEnglishButton);
        homePanel.add(productdetails3);

        productdetails1.setBounds(550, 450, 100, 30);
        productdetails1.setFont(fontEnglishButton);
        homePanel.add(productdetails1);

        productdetails2.setBounds(930, 450, 100, 30);
        productdetails2.setFont(fontEnglishButton);
        homePanel.add(productdetails2);

        nextButton.setBounds(1140, 325, 60, 50);
        nextButton.setFont(fontEnglishButton);
        homePanel.add(nextButton);


        //pictures

        JLabel imageLabel1 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p5.jpg"));
        imageLabel1.setBounds(40,150,350,250);
        homePanel.add(imageLabel1);

        JLabel imageLabel2 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p2.jpg"));
        imageLabel2.setBounds(425,150,350,250);
        homePanel.add(imageLabel2);

        JLabel imageLabel3 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p6.jpg"));
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

        productdetails3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel imageLabel2 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p5.jpg"));
                imageLabel2.setBounds(425,150,350,250);
                productDetailsPanel.add(imageLabel2);

                frame.remove(homePanel);
                productDetails();
                frame.repaint();
                frame.revalidate();
            }
        });

        productdetails1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel imageLabel1 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p2.jpg"));
                imageLabel1.setBounds(40,150,350,250);
                productDetailsPanel.add(imageLabel1);

                frame.remove(homePanel);
                productDetails();
                frame.repaint();
                frame.revalidate();

            }
        });

        productdetails2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel imageLabel3 = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p5.jpg"));
                imageLabel3.setBounds(810,150,350,250);
                productDetailsPanel.add(imageLabel3);

                frame.remove(homePanel);
                productDetails();
                frame.repaint();
                frame.revalidate();

            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(homePanel);
                nextPage();
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

        frame.add(profilePanel);

    }

    private static void productDetails()
    {
        productDetailsPanel.setSize(1200,700);
        productDetailsPanel.setBackground(Color.LIGHT_GRAY);
        productDetailsPanel.setLayout(null);

        //labels

        name.setBounds(50, 0, 100, 100);
        name.setFont(fontEnglishText);
        productDetailsPanel.add(name);

        price.setBounds(50, 100, 100, 100);
        price.setFont(fontEnglishText);
        productDetailsPanel.add(price);

        numberOfProducts.setBounds(50, 200, 100, 100);
        numberOfProducts.setFont(fontEnglishText);
        productDetailsPanel.add(numberOfProducts);

        addToCart.setBounds(50, 300, 100, 100);
        addToCart.setFont(fontEnglishText);
        productDetailsPanel.add(addToCart);


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

    private static void nextPage(){
        nextPagePanel.setSize(1200,700);
        nextPagePanel.setBackground(Color.LIGHT_GRAY);
        nextPagePanel.setLayout(null);

        //Buttons
        nextPageButton.setBounds(1140, 325, 60, 50);
        nextPageButton.setFont(fontEnglishButton);
        nextPagePanel.add(nextPageButton);

        previousPageButton.setBounds(0, 325, 60, 50);
        previousPageButton.setFont(fontEnglishButton);
        nextPagePanel.add(previousPageButton);

        //Action listeners
        previousPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(nextPagePanel);
                home();
                frame.repaint();
                frame.revalidate();

            }
        });

        frame.add(nextPagePanel);

    }

    public static void main(String[] args) {
        new showProduct();
    }

}