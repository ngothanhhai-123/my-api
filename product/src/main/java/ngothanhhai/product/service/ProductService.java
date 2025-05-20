package ngothanhhai.product.service;

import jakarta.transaction.Transactional;
import ngothanhhai.product.dto.request.ProductCreationRequest;
import ngothanhhai.product.dto.request.ProductUpdateRequest;
import ngothanhhai.product.dto.response.ProductResponse;
import ngothanhhai.product.entity.Product;
import ngothanhhai.product.exception.ProductNotFoundException;
import ngothanhhai.product.mapper.ProductMapper;
import ngothanhhai.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    // Inject ProductRepository để thao tác với DB
    // Tạo mới một sản phẩm từ dữ liệu request
    public ProductResponse createProduct(ProductCreationRequest request){
        Product product = new Product();

        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        Product saved = productRepository.save(product);
        return ProductMapper.mapToResponse(saved);
    }
    @Transactional
    // Cập nhật thông tin sản phẩm theo ID
    public ProductResponse updateProduct(Long productId, ProductUpdateRequest request){
        Product product = getProduct(productId);
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());

        Product saved = productRepository.save(product);
        return ProductMapper.mapToResponse(saved);
    }
    // Xóa sản phẩm theo Id
    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }
    // Lấy danh sách tất cả sản phẩm
    public List<ProductResponse> getProducts(){
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::mapToResponse)
                .collect(Collectors.toList());
    }
    // Lấy một sản phẩm theo ID
    public ProductResponse getProductById(Long id){
        Product product = getProduct(id);
        return ProductMapper.mapToResponse(product);
    }
    // Hàm private hỗ trợ lấy product entity
    private Product getProduct(Long id){
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }
}
