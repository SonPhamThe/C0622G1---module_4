package product_cart.service;

import product_cart.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> displayAll();

    public Optional<Product> findById(int id);

    public void save(Product product);
}
