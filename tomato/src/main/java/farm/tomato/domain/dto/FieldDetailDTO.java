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
    private FieldLength fieldLength;

    @Builder
    public FieldDetailDTO(Long id, List<TomatoDTO> tomatoes, FieldLength fieldLength) {
        this.id = id;
        this.tomatoes = tomatoes;
        this.fieldLength = fieldLength;
    }
}
