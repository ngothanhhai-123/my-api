package ngothanhhai.product.controller;

import ngothanhhai.product.dto.request.ProductCreationRequest;
import ngothanhhai.product.dto.request.ProductUpdateRequest;
import ngothanhhai.product.dto.response.ProductResponse;
import ngothanhhai.product.entity.Product;
import ngothanhhai.product.mapper.ProductMapper;
import ngothanhhai.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
// Ánh xạ base path cho toàn bộ controller là "/products"
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    // API POST để tạo sản phẩm mới
    @PostMapping
    public ProductResponse createProduct(@RequestBody ProductCreationRequest request) {
        return productService.createProduct(request);
    }
    // API GET để lấy danh sách tất cả sản phẩm
    @GetMapping
    public List<ProductResponse> getProducts(){
        return productService.getProducts()
                .stream()
                // Chuyển đổi từng Product thành ProductResponse
                .collect(Collectors.toList());
    }
    // API GET để lấy thông tin chi tiết một sản phẩm theo ID
    @GetMapping("/{productId}")
    public ProductResponse getProduct(@PathVariable("productId") Long productId){//map thong tin vao 1 bien dung Pathvariable
        return productService.getProductById(productId);// Chuyển đổi từ Product sang ProductResponse
    }
    // API PUT để cập nhật thông tin sản phẩm theo ID
    @PutMapping("/{productId}")
    public ProductResponse updateProduct(@PathVariable Long productId,@RequestBody ProductUpdateRequest request){
        return productService.updateProduct(productId,request);
    }
    // API DELETE để xoá sản phẩm theo ID
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
        return "Product has been deleted";
    }
}
