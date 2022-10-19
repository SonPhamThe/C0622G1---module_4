package management_product.repository.impl;

import jdk.jfr.Percentage;
import management_product.model.Product;
import management_product.repository.IProductRepo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductRepo implements IProductRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> displayAll() {
        TypedQuery<Product> query = entityManager.createQuery("select p from Product as p", Product.class);
        return query.getResultList();
    }
}
