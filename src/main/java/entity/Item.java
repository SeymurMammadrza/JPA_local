package entity;

import javax.persistence.*;

@Entity
@Table(name="ITEMS")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private  String name;
    private  String description;
    private  String count;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;
    //  foreign key(cart_id) referenced by carts(id)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", count='" + count + '\'' +
                ",user = "+getCart().getCardUser()+
                '}';
    }
}