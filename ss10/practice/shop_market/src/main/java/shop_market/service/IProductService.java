package shop_market.service;

import shop_market.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> displayAll();

    public Product findById(int id);

    public void save(Product product);
}
