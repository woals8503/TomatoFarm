package farm.tomato.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Pest {
    private int damage;
}