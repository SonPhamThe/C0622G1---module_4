package management_product.service.impl;

import management_product.model.Product;
import management_product.repository.IRepoProduct;
import management_product.service.IServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceProduct implements IServiceProduct {
    @Autowired
    public IRepoProduct repoProduct;

    @Override
    public List<Product> displayAll() {
        return repoProduct.displayAll();
    }

    @Override
    public void create(Product product) {
        repoProduct.create(product);
    }

    @Override
    public void remove(int id) {
        repoProduct.remove(id);
    }

    @Override
    public Product findById(int id) {
        return repoProduct.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        repoProduct.update(id, product);
    }

    @Override
    public List<Product> searchProduct(String searchName) {
        return repoProduct.searchProduct(searchName);
    }
}
