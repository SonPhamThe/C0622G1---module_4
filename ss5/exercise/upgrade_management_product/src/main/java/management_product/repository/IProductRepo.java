package management_product.repository;

import management_product.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> displayAll();
}
