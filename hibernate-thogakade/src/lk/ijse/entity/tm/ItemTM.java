package lk.ijse.entity.tm;

import javafx.scene.control.Button;

public class ItemTM {
    private int id;

    private String name;

    private String description;

    private String qtyOnHand;

    private Button button;

    public ItemTM() {
    }

    public ItemTM(int id, String name, String description, String qtyOnHand, Button button) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
        this.button = button;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(String qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "ItemTM{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", qtyOnHand='" + qtyOnHand + '\'' +
                ", button=" + button +
                '}';
    }
}
