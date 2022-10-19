package management_product.repository.impl;

import management_product.model.Product;
import management_product.repository.IProductRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Repository
public class ProductRepo implements IProductRepo {
//    private static final Map<Integer, Product> products = new LinkedHashMap<>();
//
//    static {
//        products.put(1, new Product(1, "Iphone11", 50000, "vip pro", "IP"));
//        products.put(2, new Product(2, "Nokia abc", 65000, "pro", "Nokia"));
//        products.put(3, new Product(3, "Samsung", 25000, "medium", "ss"));
//        products.put(4, new Product(4, "Vertu", 30000, "chicken", "vt"));
//        products.put(5, new Product(5, "Xiaomi", 40000, "oke", "xiaomi"));
//        products.put(6, new Product(6, "Burberry", 80000, "nice", "burberrry"));
//    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> displayAll() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p", Product.class);
        return query.getResultList();
    }

    @Override
    public void create(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void remove(Product product) {
        entityManager.remove(entityManager.merge(product));
    }

    //
    @Override
    public Product findById(int id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void update(Product product) {
       entityManager.merge(product);
    }

    @Override
    public List<Product> searchProduct(String searchName) {
        TypedQuery<Product> query = entityManager
                .createQuery("select s from Product as s where s.name like :nameInput", Product.class)
                .setParameter("nameInput", "%" + searchName + "%");
        return query.getResultList();
    }
}
