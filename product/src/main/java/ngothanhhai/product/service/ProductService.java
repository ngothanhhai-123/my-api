package ngothanhhai.product.service;

import ngothanhhai.product.dto.request.ProductCreationRequest;
import ngothanhhai.product.dto.request.ProductUpdateRequest;
import ngothanhhai.product.entity.Product;
import ngothanhhai.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {
    @Autowired
    private ProductRepository userRepository;
    // Inject ProductRepository để thao tác với DB

    // Tạo mới một sản phẩm từ dữ liệu request
    public Product createProduct(ProductCreationRequest request){
        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        return userRepository.save(product);
    }
    // Cập nhật thông tin sản phẩm theo ID
    public Product updateProduct(String productId, ProductUpdateRequest request){
        Product product = getProduct(productId);
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        return userRepository.save(product);
    }
    // Xóa sản phẩm theo Id
    public void deleteProduct(String productId){
        userRepository.deleteById(productId);
    }
    // Lấy danh sách tất cả sản phẩm
    public List<Product> getProducts(){
        return userRepository.findAll();
    }
    // Lấy một sản phẩm theo ID, nếu không có thì báo lỗi
    public Product getProduct(String id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
