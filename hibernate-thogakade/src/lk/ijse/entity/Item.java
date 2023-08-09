package lk.ijse.entity;

import lk.ijse.embaded.OrderDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_code")
    private int id;

    /*@OneToMany(mappedBy = "orderList")
    private List<OrderDetail> orderDetails = new ArrayList<> ();

    @ManyToMany
    @JoinTable(name = "order_details",
        joinColumns = { @JoinColumn (name = "itemId")},
        inverseJoinColumns = { @JoinColumn (name = "orderId")})
    private List<Order> orderList = new ArrayList<>();*/

    @Column(name = "item_name")
    private String name;

    @Column(name = "item_description")
    private String description;

    @Column(name = "qty_on_hand")
    private String qtyOnHand;

   /* @ElementCollection
    @CollectionTable(name = "order_details",
            joinColumns = @JoinColumn(name = "item_code"))
    private List<OrderDetails> orderDetail = new ArrayList<>();*/

    /*@ManyToMany
    @JoinTable(name = "order_details", joinColumns = {@JoinColumn(name = "item_code")}, inverseJoinColumns = {@JoinColumn(name = "order_id")})
    private List<Order> orderList = new ArrayList<>();*/

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetailArrayList = new ArrayList<>();

    public Item() {
    }

    public Item(int id, String name, String description, String qtyOnHand) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.qtyOnHand = qtyOnHand;
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

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", qtyOnHand='" + qtyOnHand + '\'' +
                '}';
    }
}
