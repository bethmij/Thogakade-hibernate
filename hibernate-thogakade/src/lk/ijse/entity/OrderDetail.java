package lk.ijse.entity;

import lk.ijse.embaded.OrderDetailsID;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_detail")
public class OrderDetail {


    @Column(name = "quantity")
    private int qty;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @EmbeddedId
    private OrderDetailsID orderDetailsID;

    @ManyToOne
    @MapsId("item_id")
    private Item item;

    @ManyToOne
    @MapsId("order_id")
    private Order order;

    public OrderDetail() {
    }


    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                //"orderID=" + orderID +
                //", itemCode=" + itemCode +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
