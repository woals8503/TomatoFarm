package farm.tomato.domain;

import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;

import java.util.SplittableRandom;

import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.*;

@Getter @Setter
@Entity
@NoArgsConstructor(access = PROTECTED)
public class Pest {
    @Id @GeneratedValue
    @Column(name = "pest_id")
    private Long id;
    private int damage;
    private boolean existence;
    private int percentage;
    private String imagePath;

    public Pest(int damage, boolean existence, int percentage, String imagePath) {
        this.damage = damage;
        this.existence = existence;
        this.percentage = percentage;
        this.imagePath = imagePath;
    }

    public void changeStatus() {
        this.existence = true;
    }
}