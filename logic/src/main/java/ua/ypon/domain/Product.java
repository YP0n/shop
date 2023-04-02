package ua.ypon.domain;

import javax.persistence.*;
import java.util.List;

/*
Речі
 */

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int quantity;

    @OneToMany(mappedBy = "product")
    private List<ProductInOrder> productInOrderList;

    public List<ProductInOrder> getProductInOrderList() {
        return productInOrderList;
    }

    public void setProductInOrderList(List<ProductInOrder> productInOrderList) {
        this.productInOrderList = productInOrderList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
