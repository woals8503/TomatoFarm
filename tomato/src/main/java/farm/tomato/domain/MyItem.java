package farm.tomato.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MyItem {
    @Id @GeneratedValue
    @Column(name = "myItem_id")
    private Long id;

    private String name;
    private int quantity;

    public void checkQuantity() {
        if(this.quantity <= 0)
            throw new IllegalStateException("수량이 부족합니다.");
        this.quantity -= 1;
    }
}
