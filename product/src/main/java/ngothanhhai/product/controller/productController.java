package ngothanhhai.product.controller;

import ngothanhhai.product.dto.request.ProductCreationRequest;
import ngothanhhai.product.dto.request.ProductUpdateRequest;
import ngothanhhai.product.entity.Product;
import ngothanhhai.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
// Ánh xạ base path cho toàn bộ controller là "/products"
@RequestMapping("/products")
public class productController {
    @Autowired
    // Tự động inject đối tượng ProductService
    private ProductService productService;
    // API POST để tạo sản phẩm mới
    @PostMapping()
    Product createProduct(@RequestBody ProductCreationRequest request) {
        return productService.createProduct(request);
    }
    // API GET để lấy danh sách tất cả sản phẩm
    @GetMapping
    List<Product> getProducts(){
        return productService.getProducts();
    }
    // API GET để lấy thông tin chi tiết một sản phẩm theo ID
    @GetMapping("/{productId}")
    Product getUser(@PathVariable("productId") String productId){//map thong tin vao 1 bien dung Pathvariable
        return productService.getProduct(productId);
    }
    // API PUT để cập nhật thông tin sản phẩm theo ID
    @PutMapping("/{productId}")
    Product updateProduct(@PathVariable String productId,@RequestBody ProductUpdateRequest request){
        return productService.updateProduct(productId,request);
    }
    // API DELETE để xoá sản phẩm theo ID
    @DeleteMapping("/{productId}")
    String deleteUser(@PathVariable String productId){
        productService.deleteProduct(productId);
        return "Product has been deleted";
    }
}
