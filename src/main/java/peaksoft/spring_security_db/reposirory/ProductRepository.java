package peaksoft.spring_security_db.reposirory;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.spring_security_db.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}