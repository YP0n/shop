package ua.ypon.domain;

import javax.persistence.*;
import java.util.List;

/*
Замовлення
 */

@Entity
@Table(name = "zakaz")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "order")
    private List<ProductInOrder> productInOrderList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<ProductInOrder> getProductInOrderList() {
        return productInOrderList;
    }

    public void setProductInOrderList(List<ProductInOrder> productInOrderList) {
        this.productInOrderList = productInOrderList;
    }
}
