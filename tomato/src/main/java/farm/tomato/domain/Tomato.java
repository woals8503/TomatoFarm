package farm.tomato.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tomato {
    @Id @GeneratedValue
    @Column(name = "tomato_id")
    private Long id;

    private int level;
    private int listIndex;
    private int life;
    private boolean existence;
    private String imagePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "field_id")
    private Field field;

    @Builder
    public Tomato(int level, int listIndex, int life, boolean existence, String imagePath, Field field) {
        this.level = level;
        this.listIndex = listIndex;
        this.life = life;
        this.existence = existence;
        this.imagePath = imagePath;
        this.field = field;
    }

    public void levelUp() {
        if(this.level < 3 && this.existence == true){
            this.level += 1;
           if(this.level == 2)
               this.imagePath = "smalltomato.PNG";
           else if(this.level == 3)
               this.imagePath = "tomato.PNG";
        }
    }

    public void plant() {
        this.imagePath = "seed.PNG";
        this.existence = true;
    }


    public void harvest() {
        System.out.println("왔다!");
        this.level = 1;
        this.life = 3;
        this.existence = false;
        this.imagePath = "none.PNG";
    }
}