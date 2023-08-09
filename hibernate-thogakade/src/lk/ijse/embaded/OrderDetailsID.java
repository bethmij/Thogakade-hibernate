package lk.ijse.embaded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderDetailsID implements Serializable {

    @Column(name = "item_code")
    private int itemId;

    @Column(name = "order_id")
    private int orderId;

    public OrderDetailsID() {
    }

    public OrderDetailsID(int itemId, int orderId) {
        this.itemId = itemId;
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "PlaceOrderDetails{" +
                "itemId=" + itemId +
                ", orderId=" + orderId +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        OrderDetailsID that = (OrderDetailsID) o;
        return Objects.equals(itemId, that.itemId) &&
                Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, orderId);
    }
}
