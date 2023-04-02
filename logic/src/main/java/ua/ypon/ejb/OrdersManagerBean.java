package ua.ypon.ejb;

import ua.ypon.domain.Order;
import ua.ypon.domain.Product;
import ua.ypon.domain.ProductInOrder;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Створення замовлень
 */

@Stateless
@LocalBean
public class OrdersManagerBean {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Order createOrder() {
        Order order = new Order();
        entityManager.persist(order);

        return  order;
    }

    public boolean addOrder(long productId, long orderId, int quantity) {
        Product product = entityManager.find(Product.class, productId);
        if(product == null) {
            return false;
        }

        Order order = entityManager.find(Order.class, orderId);
        if(order == null) {
            return false;
        }

        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setOrder(order);
        productInOrder.setProduct(product);
        productInOrder.setQuantity(quantity);
        entityManager.persist(productInOrder);

        return true;
    }

    public List<Product> getProductInOrder(long orderId) {
        Order order = entityManager.find(Order.class, orderId);
        if(order == null) {
            return Collections.emptyList();
        }
        List<ProductInOrder> productInOrderList = order.getProductInOrderList();
        List<Product> result = new ArrayList<>();
        for(ProductInOrder productInOrder : productInOrderList) {
            result.add(productInOrder.getProduct());
        }
        return result;
    }
}
