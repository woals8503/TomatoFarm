package farm.tomato.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Tomato {
    @Id @GeneratedValue
    @Column(name = "tomato_id")
    private Long id;

    private int level;

    private int listIndex;

    private int life;

    @Embedded
    private Pest pest;

    public Tomato(int level, int listIndex, int life) {
        this.level = level;
        this.listIndex = listIndex;
        this.life = life;
    }

    public void levelUp() {
        if(this.level < 3)
            this.level++;
        else return;
    }

}
