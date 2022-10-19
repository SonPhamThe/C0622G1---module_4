package management_product.service;

import management_product.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayAll();

    void create(Product product);

    void remove(Product product);

    Product findById(int id);

    void update(Product product);

    List<Product> searchProduct(String searchName);
}
