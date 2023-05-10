package farm.tomato.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import farm.tomato.domain.Pest;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter
@NoArgsConstructor
public class TomatoDTO {
    private Long id;
    private int level;
    private int listIndex;
    private int life;
    private boolean existence;
    private String imagePath;
    private Pest pest;

    public TomatoDTO(String imagePath) {
        this.imagePath = imagePath;
    }

    @QueryProjection
    @Builder
    public TomatoDTO(Long id, int level, int listIndex, int life, boolean existence, String imagePath, Pest pest) {
        this.id = id;
        this.level = level;
        this.listIndex = listIndex;
        this.life = life;
        this.existence = existence;
        this.imagePath = imagePath;
        this.pest = pest;
    }
}
