package farm.tomato.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter @Setter
public class Field {

    @Id @GeneratedValue
    @Column(name = "field_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id")
    private List<Tomato> tomatoes = new LinkedList<>();

    public void plantSeed(Tomato tomato) {
        tomatoes.add(tomato);
    }

}
