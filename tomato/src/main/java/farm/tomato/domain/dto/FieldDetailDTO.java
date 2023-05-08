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
        for(int i=1; i<=x; i++) {
            for(int j=0; j<y; j++) {
                field[i][j] = new TomatoDTO("none.PNG");
            }
        }

        /** 이부분 시간복잡도 개선 필요 **/
        for (TomatoDTO tomato : tomatoes) {
            // 인덱스 값이 주어진다.  ex ) 20
            int listIndex = tomato.getListIndex();
            int num = 1;
            for(int i=1; i<=x; i++) {
                for(int j=0; j<y; j++) {
                    if(listIndex == num)
                        field[i][j] = tomato;
                    num++;
                 }
            }
        }

    }

}
