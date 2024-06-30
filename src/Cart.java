import java.util.ArrayList;

public class Cart {

    private ArrayList<Integer> IDs = new ArrayList<Integer>();

    public ArrayList<Integer> getIDs() {
        return IDs;
    }

    public void setIDs(ArrayList<Integer> IDs) {
        this.IDs = IDs;
    }

    // get a array of Id and return a arraylist of products from database

    public ArrayList<Product> getProducts(ArrayList<Integer> ids) {
        ArrayList<Product> products = new ArrayList<>();
        for (int id : ids) {
            Product product = new Product();
            if (product.getInfoDB(id)) {
                products.add(product);
            }
        }
        return products;
    }


}
