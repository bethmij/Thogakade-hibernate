package lk.ijse.entity;

import lk.ijse.embaded.OrderDetails;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @CreationTimestamp
    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total_price")
    private BigDecimal orderTotal;

    @ElementCollection
    @CollectionTable(name = "order_details",
            joinColumns = @JoinColumn(name = "order_id"))
    private List<OrderDetails> orderDetail = new ArrayList<>();

    /*@ManyToMany(mappedBy = "orderList")
    private List<Item> order = new ArrayList<>();

    @OneToMany (mappedBy = "order")
    private List<OrderDetail> orderDetails = new ArrayList<>();*/

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetailArrayList = new ArrayList<>();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @ManyToOne
    private Customer customer;

   /* @OneToMany(mappedBy = "orderList")
    private List<OrderDetail> orderDetails = new ArrayList<>();*/

    /*@Transient
    List<OrderDetail> orderDetaisList;*/

    public Order() {
    }

    public Order(int orderId, LocalDate orderDate, BigDecimal orderTotal) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
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

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(BigDecimal orderTotal) {
        this.orderTotal = orderTotal;
    }


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
