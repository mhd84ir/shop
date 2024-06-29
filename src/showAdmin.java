import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class showAdmin extends JFrame implements ActionListener {
    static JFrame frame = new JFrame("Shop");

    static Product product = new Product();

    //Fonts
    static Font fontEnglishText = new Font("Times New Roman", Font.BOLD, 15);
    static Font fontEnglishButton = new Font("Times New Roman", Font.ITALIC, 19);


    //main panel
    static JPanel mainPanel = new JPanel();
    static JButton homeButton  = new JButton("Home");
    static JButton addButton  = new JButton("Add product");
    static JButton productListButton = new JButton("product list");
    static JButton userListButton = new JButton("Users List");
    static JButton propertyButton = new JButton("Property");
    static JButton storeButton = new JButton("Store");


    // this is for picture
    JLabel imageLabel;
    JFileChooser fileChooser = new JFileChooser();
    File file;
    ImageIcon imageIcon;


    //add panel
    static JPanel addPanel = new JPanel();

    //text fields
    static JTextField nameField = new JTextField();
    static JTextField priceField = new JTextField();
    static JTextField stockField = new JTextField();

    //labels
    static JLabel nameLabel = new JLabel("name :");
    static JLabel priceLabel = new JLabel("Price :");
    static JLabel stockLabel = new JLabel("Stock :");

    //buttons
    static JButton addNewProductButton  = new JButton("Add");
    static JButton addPhoto  = new JButton("Add photo");


    //productList panel
    static JPanel productListPanel = new JPanel();

    //users list panel
    static JPanel userListPanel = new JPanel();



    //property panel
    static JPanel propertyPanel = new JPanel();
    static JLabel sellingAmount = new JLabel("Overall property is : 454534$");



    public showAdmin() {

        Dimension frameSize = new Dimension(1200,700);
        frame.setSize(frameSize);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(null);

        homeButton.addActionListener(this);
        addButton.addActionListener(this);
        productListButton.addActionListener(this);
        userListButton.addActionListener(this);
        propertyButton.addActionListener(this);
        storeButton.addActionListener(this);
        addNewProductButton.addActionListener(this);
        addPhoto.addActionListener(this);


        mainPanel();

        frame.setResizable(false);
        frame.setVisible(true);


    }


    public void mainPanel(){
        mainPanel.setSize(1200,700);
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(null);

        //buttons
        homeButton.setBounds(0, 0, 200, 134);
        homeButton.setFont(fontEnglishButton);
        frame.add(homeButton);

        addButton.setBounds(0, 134, 200, 134);
        addButton.setFont(fontEnglishButton);
        frame.add(addButton);

        productListButton.setBounds(0, 264, 200, 134);
        productListButton.setFont(fontEnglishButton);
        frame.add(productListButton);

        userListButton.setBounds(0, 394, 200, 134);
        userListButton.setFont(fontEnglishButton);
        frame.add(userListButton);

        propertyButton.setBounds(0, 524, 200, 134);
        propertyButton.setFont(fontEnglishButton);
        frame.add(propertyButton);


        //pictures

//        JLabel imageLabel = new JLabel(new ImageIcon("/Users/mhd84.ir/uni/Shop-Project/src/photos/adminPic.png"));

        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\adminPic.png"));
        imageLabel.setBounds(500,60,500,500);
        mainPanel.add(imageLabel);


        //Action listeners
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showProduct showProduct = new showProduct();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
                addPanel();
                frame.repaint();
                frame.revalidate();
            }
        });

        productListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
                productListPanel();
                frame.repaint();
                frame.revalidate();
            }
        });

        userListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
                userListPanel();
                frame.repaint();
                frame.revalidate();
            }
        });

        propertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
                propertyPanel();
                frame.repaint();
                frame.revalidate();
            }
        });

        addNewProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                product.setProductName(nameField.getText());
                product.setPrice(Double.parseDouble(priceField.getText()));
                product.setStock(Integer.parseInt(stockField.getText()));
                product.setPicture(file);

                if (product.addProductToDB()) {
                    JOptionPane.showMessageDialog(frame, "Information send successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "Error to send");
                }
            }
        });



        mainPanel.setVisible(true);
        frame.add(mainPanel);
    }

    //add panel
    public void addPanel(){

        addPanel.setSize(1200,700);
        addPanel.setBackground(Color.LIGHT_GRAY);
        addPanel.setLayout(null);

        //fields

        nameField.setBounds(350,100,300,60);
        nameField.setFont(fontEnglishText);
        addPanel.add(nameField);

        priceField.setBounds(350,230,300,60);
        priceField.setFont(fontEnglishText);
        addPanel.add(priceField);

        stockField.setBounds(350,360,300,60);
        stockField.setFont(fontEnglishText);
        addPanel.add(stockField);

        //labels

        nameLabel.setBounds(300, 80, 200, 100);
        nameLabel.setFont(fontEnglishText);
        addPanel.add(nameLabel);

        priceLabel.setBounds(300, 210, 200, 100);
        priceLabel.setFont(fontEnglishText);
        addPanel.add(priceLabel);

        stockLabel.setBounds(300, 340, 200, 100);
        stockLabel.setFont(fontEnglishText);
        addPanel.add(stockLabel);

        //Buttons

        addNewProductButton.setBounds(400, 450, 200, 50);
        addNewProductButton.setFont(fontEnglishButton);
        addPanel.add(addNewProductButton);

        addPhoto.setBounds(800, 450, 200, 50);
        addPhoto.setFont(fontEnglishButton);
        addPanel.add(addPhoto);

        //picture

        this.imageLabel = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p3.jpg"));
        this.imageLabel.setBounds(700,100,400,400);
        addPanel.add(this.imageLabel);

        //Action Listeners

        propertyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(addPanel);
                propertyPanel();
                frame.repaint();
                frame.revalidate();
            }
        });


        addPanel.setVisible(true);
        frame.add(addPanel);

    }


    private void productListPanel(){
        productListPanel.setSize(1200,700);
        productListPanel.setBackground(Color.LIGHT_GRAY);
        productListPanel.setLayout(null);

        // Create a JPanel to hold the grid
        JPanel panel = new JPanel(new GridLayout(101, 5));

        // Adding headers to the first row
        String[] headers = {"ID", "Name", "Price", "Stock", "Edit"};
        for (String header : headers) {
            panel.add(new JLabel(header));
        }

        // Add 100 rows of 8 JTextFields and 1 JButton
        for (int row = 0; row < 100; row++) {
            for (int col = 0; col < 4; col++) {
                panel.add(new JTextField());
            }
            JButton button = new JButton("Button " + (row + 1)); // To differentiate buttons
            panel.add(button);
        }

        // Add the panel to the JFrame
        add(new JScrollPane(panel));

        // Set the size of the JFrame
        setSize(1000, 500);
        // Set the visibility of the JFrame
        setVisible(true);

    }



    public void userListPanel(){
        userListPanel.setSize(1200,700);
        userListPanel.setBackground(Color.LIGHT_GRAY);
        userListPanel.setLayout(null);

        // Create a JPanel to hold the grid
        JPanel panel = new JPanel(new GridLayout(101, 9));

        // Adding headers to the first row
        String[] headers = {"ID", "Username", "Name", "Phone number", "Email", "Address", "Credit", "Role", "Edit"};
        for (String header : headers) {
            panel.add(new JLabel(header));
        }

        // Add 100 rows of 8 JTextFields and 1 JButton
        for (int row = 0; row < 100; row++) {
            for (int col = 0; col < 8; col++) {
                panel.add(new JTextField());
            }
            JButton button = new JButton("Button " + (row + 1)); // To differentiate buttons
            panel.add(button);
        }

        // Add the panel to the JFrame
        add(new JScrollPane(panel));

        // Set the size of the JFrame
        setSize(1000, 500);
        // Set the visibility of the JFrame
        setVisible(true);


    }




    public void propertyPanel(){
        propertyPanel.setSize(1200,700);
        propertyPanel.setBackground(Color.LIGHT_GRAY);
        propertyPanel.setLayout(null);

        //labels
        sellingAmount.setBounds(500, 80, 500, 100);
        sellingAmount.setFont(fontEnglishText);
        propertyPanel.add(sellingAmount);

        //pictures
        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p2.jpg"));
        imageLabel.setBounds(500,60,500,500);
        propertyPanel.add(imageLabel);

        //Action listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(propertyPanel);
                addPanel();
                frame.repaint();
                frame.revalidate();
            }
        });

        propertyPanel.setVisible(true);
        frame.add(propertyPanel);

    }



    public void chooseFileImage(){



        fileChooser.setAcceptAllFileFilterUsed(false);

        int option = fileChooser.showOpenDialog(frame);
        if (option == JFileChooser.APPROVE_OPTION)
        {
            file = fileChooser.getSelectedFile();
            imageIcon = new ImageIcon(new ImageIcon (String.valueOf(file)).getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT));
            this.imageLabel.setIcon(imageIcon);
        }

        try {
            Image image = ImageIO.read(file);
            Image scaledImage = image.getScaledInstance(this.imageLabel.getWidth(), this.imageLabel.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imageIcon = new ImageIcon(scaledImage);
            imageLabel.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    public static void main(String[] args) {
        product.getInfoDB(1);
        new showAdmin();

    }


    //Action listeners
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addPhoto)
        {
            chooseFileImage();
        }

    }
}



