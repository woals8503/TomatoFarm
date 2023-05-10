package farm.tomato.domain;

import lombok.*;

import javax.persistence.*;

import java.util.List;
import java.util.SplittableRandom;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = PROTECTED)
public class Tomato {
    @Id @GeneratedValue
    @Column(name = "tomato_id")
    private Long id;

    private int level;
    private int listIndex;
    private int life;
    private boolean existence;
    private String imagePath;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "field_id")
    private Field field;

    @OneToOne(cascade = ALL, fetch = LAZY)
    @JoinColumn(name = "pest_id")
    private Pest pest;

    @Builder
    public Tomato(int level, int listIndex, int life, boolean existence, String imagePath, Field field, Pest pest) {
        this.level = level;
        this.listIndex = listIndex;
        this.life = life;
        this.existence = existence;
        this.imagePath = imagePath;
        this.field = field;
        this.pest = pest;
    }

    public int levelUp() {

        if(this.level < 3 && this.existence == true && !pest.isExistence()){
            this.level += 1;
           if(this.level == 2)
               this.imagePath = "smalltomato.PNG";
           else if(this.level == 3)
               this.imagePath = "tomato.PNG";
        }

        return this.level;
    }

    public void plant() {
        this.imagePath = "seed.PNG";
        this.existence = true;
    }


    public void harvest() {
        if(this.level != 3) {
            throw new IllegalStateException("3레벨 토마토만 수확 가능합니다.");
        }
        this.level = 1;
        this.life = 3;
        this.existence = false;
        this.imagePath = "none.PNG";
    }

    public boolean pestCreateOrNot(Pest pest) {
        SplittableRandom random = new SplittableRandom();
        boolean result = random.nextInt(1, pest.getPercentage()) <= 50;
        return result;
    }

    public void addPest(Pest pest) {
        this.pest = pest;
        this.imagePath = pest.getImagePath();
    }
}