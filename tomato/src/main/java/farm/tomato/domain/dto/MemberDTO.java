package farm.tomato.domain.dto;

import farm.tomato.domain.MyItem;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Getter @Setter
@NoArgsConstructor
public class MemberDTO {
    private Long id;
    private int amount;
    private List<MyItemDTO> myItemList;

    @Builder
    public MemberDTO(Long id, int amount, List<MyItem> myItemList) {
        this.id = id;
        this.amount = amount;
        this.myItemList = myItemList.stream()
                .map(o -> MyItemDTO.builder()
                        .id(o.getId())
                        .name(o.getName())
                        .quantity(o.getQuantity())
                        .build()).collect(Collectors.toList());
    }
}
