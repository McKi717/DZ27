package learnUp.dz19.entity;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
@Data
public class Orders {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @MapsId
    private Buyer buyers;

    @Column
    private float amountBuy;

    @ManyToOne
    @JoinColumn(name = "orders")
    @Fetch(FetchMode.JOIN)
    private OrderDetails orderDetails;

    @OneToMany(mappedBy = "buyerOrder", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Fetch(FetchMode.JOIN)
    private List<Buyer> buyerList;

}
