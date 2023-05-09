package farm.tomato.domain;

import farm.tomato.domain.embedded.FieldLength;
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

    @Embedded
    private FieldLength fieldLength;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "field")
    private List<Tomato> tomatoes = new LinkedList<>();



    public void plantSeed(Tomato tomato) {
        tomatoes.add(tomato);
    }


}
