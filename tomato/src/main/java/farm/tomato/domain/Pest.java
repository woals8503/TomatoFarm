package farm.tomato.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Pest {
    private int damage;
    private boolean existence;

    public Pest(int damage, boolean existence) {
        this.damage = damage;
        this.existence = existence;
    }

}
