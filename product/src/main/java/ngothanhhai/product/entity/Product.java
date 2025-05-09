package ngothanhhai.product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// Đánh dấu đây là một Entity, sẽ ánh xạ với một bảng trong cơ sở dữ liệu
@Entity//danh dau class la 1 table
public class Product {
    //Đánh dấu trường id là khóa chính của bảng
    @Id//dinh nghia cho id
    @GeneratedValue(strategy = GenerationType.UUID)
    // UUID sẽ đảm bảo mỗi id là duy nhất, ví dụ như "31khrbui1*(&"
    private String id;
    private String name ;
    private String description;
    private Double price;
    private Integer stock;
    //genarate -> getter and setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
