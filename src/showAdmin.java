import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showAdmin extends JFrame {
    static JFrame frame = new JFrame("Shop");

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




    public showAdmin() {

        Dimension frameSize = new Dimension(1200,700);
        frame.setSize(frameSize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        mainPanel();

        frame.setResizable(false);
        frame.setVisible(true);


    }


    public void mainPanel(){
        mainPanel.setSize(1200,700);
        mainPanel.setBackground(Color.LIGHT_GRAY);
        mainPanel.setLayout(null);

        //buttons
        homeButton.setBounds(0, 0, 200, 116);
        homeButton.setFont(fontEnglishButton);
        frame.add(homeButton);

        addButton.setBounds(0, 114, 200, 116);
        addButton.setFont(fontEnglishButton);
        frame.add(addButton);

        productListButton.setBounds(0, 225, 200, 116);
        productListButton.setFont(fontEnglishButton);
        frame.add(productListButton);

        userListButton.setBounds(0, 340, 200, 116);
        userListButton.setFont(fontEnglishButton);
        frame.add(userListButton);

        propertyButton.setBounds(0, 453, 200, 116);
        propertyButton.setFont(fontEnglishButton);
        frame.add(propertyButton);

        storeButton.setBounds(0, 552, 200, 116);
        storeButton.setFont(fontEnglishButton);
        frame.add(storeButton);

        //pictures

        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\adminPic.png"));
        imageLabel.setBounds(500,60,500,500);
        mainPanel.add(imageLabel);


        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(mainPanel);
                homePanel();
                frame.repaint();
                frame.revalidate();

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

//        userListButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.remove(mainPanel);
//                cart();
//                frame.repaint();
//                frame.revalidate();
//
//            }
//        });
//
//        propertyButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.remove(mainPanel);
//                cart();
//                frame.repaint();
//                frame.revalidate();
//
//            }
//        });
//
//        propertyButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                frame.remove(mainPanel);
//                cart();
//                frame.repaint();
//                frame.revalidate();
//
//            }
//        });
//

        frame.add(mainPanel);
    }

    //Home panel
    public void homePanel(){
        showProduct homePanel = new showProduct();
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

        JLabel imageLabel = new JLabel(new ImageIcon("C:\\Users\\asus\\Desktop\\java\\AP\\shop\\src\\photos\\p3.jpg"));
        imageLabel.setBounds(600,0,600,600);
        addPanel.add(imageLabel);

        frame.add(addPanel);

    }


    public void productListPanel(){
        productListPanel.setSize(1200,700);
        productListPanel.setBackground(Color.LIGHT_GRAY);
        productListPanel.setLayout(null);

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        model.addColumn("Product");
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Stock");
        model.addColumn("Edit");

        for (int i = 0; i < 100; i++) {
            model.addRow(new Object[]{"Product " + (i + 1), "", "", "", ""});
        }

        table.setRowHeight(60);

        table.getColumnModel().getColumn(1).setHeaderValue("Name");
        table.getColumnModel().getColumn(2).setHeaderValue("Price");
        table.getColumnModel().getColumn(3).setHeaderValue("Stock");
        table.getColumnModel().getColumn(4).setHeaderValue("Edit");


        scrollPane.setBounds(200, 0, 1000, 700);
        productListPanel.add(scrollPane);


        frame.add(productListPanel);
    }

    public static void main(String[] args) {
        new showAdmin();
    }
}



