package product_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import product_management.entity.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
}
