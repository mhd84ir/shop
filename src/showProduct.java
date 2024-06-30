import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
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
    //labels
    static JLabel productNameExample1 = new JLabel("name1");
    static JLabel productNameExample2 = new JLabel("name2");
    static JLabel productNameExample3 = new JLabel("name3");
    //Buttons
    static JButton addToCartButton1 = new JButton("Add to cart");
    static JButton addToCartButton2 = new JButton("Add to cart");
    static JButton addToCartButton3 = new JButton("Add to cart");
    static JButton showMoreButton = new JButton("More");
    static JButton searchButton = new JButton("search");



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



//    //productDetails panel
//    static JPanel productDetailsPanel = new JPanel();
//    //labels
//    static JLabel name = new JLabel("Name :");
//    static JLabel price = new JLabel("Price :");
//    static JLabel numberOfProducts = new JLabel("Stock :");
//    static JLabel addToCart = new JLabel("Add to cart :");
//    //Buttons
//    static JButton addToCartButton = new JButton("Click");



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

        addToCartButton1.setBounds(130, 450, 150, 30);
        addToCartButton1.setFont(fontEnglishButton);
        homePanel.add(addToCartButton1);

        addToCartButton2.setBounds(520, 450, 150, 30);
        addToCartButton2.setFont(fontEnglishButton);
        homePanel.add(addToCartButton2);

        addToCartButton3.setBounds(910, 450, 150, 30);
        addToCartButton3.setFont(fontEnglishButton);
        homePanel.add(addToCartButton3);

        showMoreButton.setBounds(1100, 300, 100, 100);
        showMoreButton.setFont(fontEnglishButton);
        homePanel.add(showMoreButton);

        searchButton.setBounds(910, 25, 100, 50);
        searchButton.setFont(fontEnglishButton);
        homePanel.add(searchButton);

        //labels
        productNameExample1.setBounds(180, 400, 150, 30);
        productNameExample1.setFont(fontEnglishText);
        homePanel.add(productNameExample1);

        productNameExample2.setBounds(570, 400, 150, 30);
        productNameExample2.setFont(fontEnglishText);
        homePanel.add(productNameExample2);

        productNameExample3.setBounds(960, 400, 150, 30);
        productNameExample3.setFont(fontEnglishText);
        homePanel.add(productNameExample3);


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
                showCartProducts();
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

        addToCartButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //TODO
                addToCart(frame,products1[0].getID(), products1[0].getStock());

            }
        });

        addToCartButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                addToCart(frame,products1[1].getID(), products1[1].getStock());


            }
        });

        addToCartButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO
                addToCart(frame,products1[2].getID(), products1[2].getStock());


            }
        });

        showMoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMoreProduct();
//                frame.repaint();
//                frame.revalidate();

            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                search(searchField.getText());


            }
        });



        frame.add(homePanel);

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
        creditLabel.setText("your credit is : " + Double.toString(user.getCredit()));
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
                showCartProducts();
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

        //pics
        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\images.jpg"));
        imageLabel.setBounds(725,80,400,330);
        changePasswordPanel.add(imageLabel);


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
                showCartProducts();
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

        //pics
        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\wonder.png"));
        imageLabel.setBounds(725,80,400,330);
        depositPanel.add(imageLabel);



        addToCreditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setCredit(user.getCredit() + Double.parseDouble(amountField.getText()));
                if (user.editProfile())
                {
                    JOptionPane.showMessageDialog(frame, "Credit added successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Error adding credit");
                    user.setCredit(user.getCredit() - Double.parseDouble(amountField.getText()));
                }
            }
        });

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
                showCartProducts();
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


    //show cart products
    private static void showCartProducts() {

        //read from cart.txt and split by ,
        String[] ids = new String[0];
        try {
            FileReader reader = new FileReader("cart.txt");
            BufferedReader reader1 = new BufferedReader(reader);
            String line = reader1.readLine();
            ids = line.split(",");
            reader1.close();
        } catch (IOException e) {
            System.out.println("error open");
        }

        ArrayList<Integer> ids1 = new ArrayList<Integer>();

        // convert string array to integer array


        for (String id : ids) {
            ids1.add(Integer.parseInt(id));
        }

        // get products from database from cart class
        Cart cart = new Cart();
        ArrayList<Product> products = cart.getProducts(ids1);
        products = cart.getProducts(ids1);



        JFrame frame2 = new JFrame();
        frame2.setTitle("Your Cart List");
        frame2.setSize(800, 600);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setLocationRelativeTo(null);



        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        for (Product p : products) {
            mainPanel.add(createCartPanel(p), gbc);
            gbc.gridx++;
            if (gbc.gridx % 3 == 0) {
                gbc.gridx = 0;
                gbc.gridy++;
            }
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        frame2.add(scrollPane, BorderLayout.CENTER);



        frame2.setVisible(true);

        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    static private JPanel createCartPanel(Product product) {
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BorderLayout(10, 10));
        productPanel.setPreferredSize(new Dimension(200, 300));

        // نمایش تصویر محصول
        JLabel imageLabel = new JLabel();
        ImageIcon originalIcon = product.getImageIcon();
        Image scaledImage = originalIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        productPanel.add(imageLabel, BorderLayout.CENTER);

        // نمایش نام محصول


        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 1));

        JLabel nameLabel = new JLabel("Name: " +product.getProductName(), JLabel.CENTER);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        productPanel.add(nameLabel,BorderLayout.NORTH);

        JLabel priceLabel = new JLabel("Price: " + product.getPrice(), JLabel.CENTER);
        priceLabel.setFont(new Font("Serif", Font.BOLD, 12));

        JLabel stockLabel = new JLabel("Stock: " + product.getStock(), JLabel.CENTER);
        stockLabel.setFont(new Font("Serif", Font.BOLD, 12));

        infoPanel.add(priceLabel);
        infoPanel.add(stockLabel);


        // دکمه "Add to Cart"
        JButton buy = new JButton("buy");
        buy.addActionListener(e -> {
            products.add(product);
            if (e.getSource() == buy)
            {
                if (user.getCredit()>=product.getPrice() && product.getStock() > 0)
                {
                    user.setCredit(user.getCredit() - product.getPrice());
                    product.setStock(product.getStock() - 1);
                    user.editProfile();
                    product.updateProduct(product.getID());
                    Balance balance = new Balance();
                    balance.setBalance(balance.getBalance() + product.getPrice());
                    balance.update(1);
                }

            }
        });
        infoPanel.add(buy, BorderLayout.SOUTH);

        productPanel.add(infoPanel, BorderLayout.SOUTH);
        return productPanel;
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

        previousPurchaseFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    public static void showMoreProduct(){

        ProductDisplayFrame();
    }


    static JFrame frame1 = new JFrame();
    static public void ProductDisplayFrame() {

        frame1.setTitle("Product List");
        frame1.setSize(800, 600);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLocationRelativeTo(null);



        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        for (Product p : products) {
            mainPanel.add(createProductPanel(p), gbc);
            gbc.gridx++;
            if (gbc.gridx % 3 == 0) {
                gbc.gridx = 0;
                gbc.gridy++;
            }
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        frame1.add(scrollPane, BorderLayout.CENTER);



        frame1.setVisible(true);

        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    static private JPanel createProductPanel(Product product) {
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BorderLayout(10, 10));
        productPanel.setPreferredSize(new Dimension(200, 300));

        // نمایش تصویر محصول
        JLabel imageLabel = new JLabel();
        ImageIcon originalIcon = product.getImageIcon();
        Image scaledImage = originalIcon.getImage().getScaledInstance(180, 180, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        productPanel.add(imageLabel, BorderLayout.CENTER);

        // نمایش نام محصول


        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 1));

        JLabel nameLabel = new JLabel("Name: " +product.getProductName(), JLabel.CENTER);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        productPanel.add(nameLabel,BorderLayout.NORTH);

        JLabel priceLabel = new JLabel("Price: " + product.getPrice(), JLabel.CENTER);
        priceLabel.setFont(new Font("Serif", Font.BOLD, 12));

        JLabel stockLabel = new JLabel("Stock: " + product.getStock(), JLabel.CENTER);
        stockLabel.setFont(new Font("Serif", Font.BOLD, 12));

        infoPanel.add(priceLabel);
        infoPanel.add(stockLabel);


        // دکمه "Add to Cart"
        JButton addToCartButton = new JButton("Add to Cart");
        addToCartButton.addActionListener(e -> {
            products.add(product);
            if (e.getSource() == addToCartButton)
            {
                addToCart(frame1,product.getID(),product.getStock());
            }
        });
        infoPanel.add(addToCartButton, BorderLayout.SOUTH);

        productPanel.add(infoPanel, BorderLayout.SOUTH);
        return productPanel;
    }

    public static void addToCart(JFrame frame, int Id , int stock){

        if (stock>0) {

            try {
                FileWriter writer = new FileWriter("cart.txt", true);
                BufferedWriter writer1 = new BufferedWriter(writer);
                writer1.write(Id + ",");
                writer1.close();

                JOptionPane.showMessageDialog(frame, "added to cart");


            } catch (IOException ee) {
                System.out.println("error");
                JOptionPane.showMessageDialog(frame, "Error to add");

            }
        }


        else
        {
            JOptionPane.showMessageDialog(frame, "product is not available");
        }

    }


    public static void search(String text){
        Product product1 = new Product();


        if (product1.search(text) == true) {


            JFrame frame2 = new JFrame("Product Details");
            frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame2.setSize(400, 500);
            frame2.setLocationRelativeTo(null);

            JPanel panel = createProductDetailPanel(product1);
            frame2.add(panel);

            frame2.setVisible(true);

        }

        else
        {
            JOptionPane.showMessageDialog(frame, "product is not found");
        }

    }

     public static JPanel createProductDetailPanel(Product product) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));

        // نمایش تصویر محصول
        JLabel imageLabel = new JLabel();
        ImageIcon originalIcon = product.getImageIcon();
        Image scaledImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaledImage));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(imageLabel, BorderLayout.NORTH);

        // نمایش مشخصات محصول
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel("Name: " + product.getProductName(), JLabel.CENTER);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(nameLabel);

        JLabel priceLabel = new JLabel("Price: $" + product.getPrice(), JLabel.CENTER);
        priceLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(priceLabel);

        JLabel stockLabel = new JLabel("Stock: " + product.getStock(), JLabel.CENTER);
        stockLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        stockLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsPanel.add(stockLabel);

        JButton addToCard = new JButton("add to card");
         addToCard.setFont(new Font("Serif", Font.PLAIN, 14));
         addToCard.setAlignmentX(Component.CENTER_ALIGNMENT);
         detailsPanel.add(addToCard);


        mainPanel.add(detailsPanel, BorderLayout.CENTER);

        return mainPanel;
    }






    public static void main(String[] args) {
        new showProduct();
    }

}