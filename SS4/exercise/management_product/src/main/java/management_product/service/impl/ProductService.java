package management_product.service.impl;

import management_product.model.Product;
import management_product.repository.IProductRepo;
import management_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    public IProductRepo repoProduct;

    @Override
    public List<Product> displayAll() {
        return repoProduct.displayAll();
    }

    @Override
    public void create(Product product) {
        repoProduct.create(product);
    }

    @Override
    public void remove(Product product) {
        repoProduct.remove(product);
    }

    @Override
    public Product findById(int id) {
        return repoProduct.findById(id);
    }

    @Override
    public void update(Product product) {
        repoProduct.update(product);
    }

    @Override
    public List<Product> searchProduct(String searchName) {
        return repoProduct.searchProduct(searchName);
    }
}
