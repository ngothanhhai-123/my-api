package ngothanhhai.product.repository;

import ngothanhhai.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
// Đánh dấu interface này là một bean của Spring, để Spring quản lý
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    // Kế thừa từ JpaRepository để có sẵn các phương thức CRUD:
    // - save(), findById(), findAll(), deleteById(), ...
    // - Product là kiểu entity
    // - String là kiểu của khóa chính (id)
}
