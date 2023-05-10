package farm.tomato.service;

import farm.tomato.domain.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    List<ItemDTO> findAllItem();

    void changePercentage(Long fieldId, Long itemId);

    void removePest(Long fieldId, Long itemId);
}
