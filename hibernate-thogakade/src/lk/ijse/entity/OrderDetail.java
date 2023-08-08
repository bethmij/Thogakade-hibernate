package lk.ijse.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Column(name = "order_id")
    private int orderID;

    @Column(name = "item_code")
    private int itemCode;

    @Column(name = "quantity")
    private int qty;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    public OrderDetail() {
    }

    public OrderDetail(int orderID, int itemCode, int qty, BigDecimal unitPrice) {
        this.orderID = orderID;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
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
                "orderID=" + orderID +
                ", itemCode=" + itemCode +
                ", qty=" + qty +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
