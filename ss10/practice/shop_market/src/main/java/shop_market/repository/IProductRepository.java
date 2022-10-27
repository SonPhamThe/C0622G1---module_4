package shop_market.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop_market.model.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {
}
