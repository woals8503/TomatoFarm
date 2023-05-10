package farm.tomato.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import farm.tomato.domain.Pest;
import farm.tomato.domain.Tomato;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class PestTureTomatoDTO {
    private Tomato tomatoes;
    private Pest pest;

    @QueryProjection
    public PestTureTomatoDTO(Tomato tomatoes, Pest pest) {
        this.tomatoes = tomatoes;
        this.pest = pest;
    }
}
