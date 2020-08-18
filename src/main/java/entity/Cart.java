package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="CARTS")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String cardUser;


    @OneToMany(mappedBy="cart")
    private Set<Item> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardUser() {
        return cardUser;
    }

    public void setCardUser(String cardUser) {
        this.cardUser = cardUser;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", cardUser='" + cardUser + '\'' +
                ", items=" + items +
                '}';
    }
}