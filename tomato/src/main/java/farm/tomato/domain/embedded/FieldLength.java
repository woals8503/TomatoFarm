package farm.tomato.domain.embedded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor
public class FieldLength {
    private int width;
    private int height;

    public FieldLength(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
