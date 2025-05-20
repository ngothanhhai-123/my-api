package ngothanhhai.product.mapper;

import ngothanhhai.product.dto.response.ProductResponse;
import ngothanhhai.product.entity.Product;

public class ProductMapper {
    public static ProductResponse mapToResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getStock()
        );
    }
}
