package lk.ijse.embaded;

import javax.persistence.Embeddable;

@Embeddable
public class PlaceOrderDetails {

    private int itemId;

    private int orderId;

    public PlaceOrderDetails() {
    }

    public PlaceOrderDetails(int itemId, int orderId) {
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
}
