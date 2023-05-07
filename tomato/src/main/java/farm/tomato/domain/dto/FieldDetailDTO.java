package farm.tomato.domain.dto;

import farm.tomato.domain.Tomato;
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
    private List<TomatoDTO> tomatoes;
    private boolean[][] fieldLength;

    @Builder
    public FieldDetailDTO(Long id, List<TomatoDTO> tomatoes, FieldLength fieldLength) {
        this.id = id;
        this.tomatoes = tomatoes;
        this.fieldLength = new boolean[fieldLength.getHeight()][fieldLength.getWidth()];
        //토마토는 3 15 번호 일때 값을 넣고 아니면
        int index = 1;
        //필드값 삽입
        for(int i=0; i<fieldLength.getHeight(); i++) {
            for(int j=0; j<fieldLength.getWidth(); j++) {
                if(index == tomatoes.get(index-1).getListIndex())
                    this.fieldLength[i][j] = true;
                else this.fieldLength[i][j] = false;
                index++;
            }
        }
    }
}
