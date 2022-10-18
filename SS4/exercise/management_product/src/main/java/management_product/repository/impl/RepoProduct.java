package management_product.repository.impl;

import management_product.model.Product;
import management_product.repository.IRepoProduct;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RepoProduct implements IRepoProduct {
    private static final Map<Integer, Product> products = new LinkedHashMap<>();

    static {
        products.put(1, new Product(1, "Iphone11", 50000, "vip pro", "IP"));
        products.put(2, new Product(2, "Nokia abc", 65000, "pro", "Nokia"));
        products.put(3, new Product(3, "Samsung", 25000, "medium", "ss"));
        products.put(4, new Product(4, "Vertu", 30000, "chicken", "vt"));
        products.put(5, new Product(5, "Xiaomi", 40000, "oke", "xiaomi"));
        products.put(6, new Product(6, "Burberry", 80000, "nice", "burberrry"));
    }

    @Override
    public List<Product> displayAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void create(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public List<Product> searchProduct(String searchName) {
//        List<Product> productList = displayAll();
        List<Product> productList = new ArrayList();

        for (Product product : products.values()) {
            if (product.getName().contains(searchName)) {
                productList.add(product);
            }
        }
//        for (int i = 0; i < products.size(); i++) {
//            if (productList.get(i).getName().contains(searchName)) {
//                products.add(productList.get(i));
//            }
//        }
        return productList;
    }
}
