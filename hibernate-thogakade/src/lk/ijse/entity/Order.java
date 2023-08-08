package lk.ijse.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total_price")
    private BigDecimal orderTotal;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    private Customer customer;

    /*@Transient
    List<OrderDetail> orderDetaisList;*/

    public Order() {
    }

    public Order(int orderId, LocalDate orderDate, int customerId, BigDecimal orderTotal, List<OrderDetail> orderDetaisList) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        //this.customerId = customerId;
        this.orderTotal = orderTotal;
        //this.orderDetaisList = orderDetaisList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

   /* public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }*/

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }

    /*public List<OrderDetail> getOrderDetaisList() {
        return orderDetaisList;
    }

    public void setOrderDetaisList(List<OrderDetail> orderDetaisList) {
        this.orderDetaisList = orderDetaisList;
    }*/

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                //", customerId=" + customerId +
                ", orderTotal=" + orderTotal +
                //", orderDetaisList=" + orderDetaisList +
                '}';
    }
}
