package farm.tomato.domain.dto;

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

    public TomatoDTO(String imagePath) {
        this.imagePath = imagePath;
    }

    @Builder
    public TomatoDTO(Long id, int level, int listIndex, int life, boolean existence, String imagePath) {
        this.id = id;
        this.level = level;
        this.listIndex = listIndex;
        this.life = life;
        this.existence = existence;
        this.imagePath = imagePath;
    }
}
