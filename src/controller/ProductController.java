package controller;

import model.ProductDAO;
import model.Product;
import java.util.ArrayList;

public class ProductController {

    private final ProductDAO dao = new ProductDAO();

    public void addProduct(Product p) {
        dao.addProduct(p);
    }

    public void updateProduct(Product p) {
        dao.updateProduct(p);
    }

    public void deleteProduct(int id) {
        dao.deleteProduct(id);
    }

    public ArrayList<Product> getProducts() {
        return dao.getAllProducts();
    }

    public ArrayList<Product> search(String keyword) {
        return dao.searchProduct(keyword);
    }

    public ArrayList<Product> getLowStockProducts() {
        return dao.getLowStockProducts(10);
    }
}
