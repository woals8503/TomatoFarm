package farm.tomato.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class FieldDTO {
    private Long id;
    private String name;

    @Builder
    public FieldDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
