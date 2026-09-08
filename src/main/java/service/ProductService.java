package service;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public class ProductService {

    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product("1", "86 (the band) - True Life Songs and Pictures", 14.95));
        products.add(new Product("2", "Paddlefoot - The first CD", 12.95));
        products.add(new Product("3", "Paddlefoot - The second CD", 14.95));
        products.add(new Product("4", "Joe Rut - Genuine Wood Grained Finish", 14.95));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(String id) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }
}