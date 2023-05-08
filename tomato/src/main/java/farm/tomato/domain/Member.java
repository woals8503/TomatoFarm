package farm.tomato.domain;

import farm.tomato.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private int gold;
    private int amount;

    @OneToMany
    @JoinColumn(name = "member_id")
    List<Item> items = new ArrayList<>();

//    @OneToMany
//    @JoinColumn(name = "member_id")
//    private List<Field> fields =

    @OneToMany(mappedBy = "member")
    private List<Field> fields = new ArrayList<>();

    public void createField(Field field) {
        fields.add(field);
    }

    public void createItem(Item item) {
        items.add(item);
    }

}
