package farm.tomato.domain.item;

import farm.tomato.domain.Member;
import farm.tomato.exception.NotEnoughStockException;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    public Item(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void removeStock() {
        int stock = this.stockQuantity - 1;
        if(stock < 0) throw new NotEnoughStockException();
        this.stockQuantity--;
    }

}
