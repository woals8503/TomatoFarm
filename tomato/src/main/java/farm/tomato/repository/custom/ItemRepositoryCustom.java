package farm.tomato.repository.custom;

import farm.tomato.domain.dto.ItemDTO;

import java.util.List;

public interface ItemRepositoryCustom {
    List<ItemDTO> findAllItem();
}
