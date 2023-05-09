package farm.tomato.domain.dto;

import farm.tomato.domain.embedded.FieldLength;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class FieldDetailDTO {
    private Long id;
    private TomatoDTO[][] field;
    private FieldLength fieldLength;
    private int x;
    private int y;

    @Builder
    public FieldDetailDTO(Long id, List<TomatoDTO> tomatoes, FieldLength fieldLength) {
        this.id = id;
        this.fieldLength = fieldLength;
        x = fieldLength.getHeight();
        y = fieldLength.getWidth();
        this.field = new TomatoDTO[x+1][y];
        insertTomatoIntoField(tomatoes);
    }

    private void insertTomatoIntoField(List<TomatoDTO> tomatoes) {
        //토마토 배열 생성
        int num = 0;
        for(int i=1; i<=x; i++) {
            for(int j=0; j<y; j++) {
                field[i][j] = tomatoes.get(num);
                num++;
            }
        }
    }
}
