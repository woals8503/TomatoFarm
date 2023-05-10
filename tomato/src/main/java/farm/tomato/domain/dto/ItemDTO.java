package farm.tomato.domain.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ItemDTO {
    private Long id;
    private String name;
    private int price;
    private int stockQuantity;

    @QueryProjection
    public ItemDTO(Long id, String name, int price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
