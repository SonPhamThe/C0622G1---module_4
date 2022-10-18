package management_product.service;

import management_product.model.Product;

import java.util.List;

public interface IServiceProduct {
    List<Product> displayAll();

    void create(Product product);

    void remove(int id);

    Product findById(int id);

    void update(int id, Product product);

    List<Product> searchProduct(String searchName);
}
