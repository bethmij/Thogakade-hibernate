package lk.ijse.entity.tm;

import javafx.scene.control.Button;

public class OrderTM {

    private int orderId;

    private int custId;

    private int itemId;

    private double unitPrice;

    private int quantity;

    private double price;

    private Button button;

    public OrderTM() {
    }

    public OrderTM(int orderId, int custId, int itemId, double unitPrice, int quantity, double price, Button button) {
        this.orderId = orderId;
        this.custId = custId;
        this.itemId = itemId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.price = price;
        this.button = button;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "OrderTM{" +
                "orderId=" + orderId +
                ", custId=" + custId +
                ", itemId=" + itemId +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", price=" + price +
                ", button=" + button +
                '}';
    }
}
