package farm.tomato.service.Impl;

import farm.tomato.domain.Item;
import farm.tomato.domain.MyItem;
import farm.tomato.domain.Tomato;
import farm.tomato.domain.dto.ItemDTO;
import farm.tomato.domain.dto.PestTureTomatoDTO;
import farm.tomato.repository.ItemRepository;
import farm.tomato.repository.MyItemRepository;
import farm.tomato.repository.PestRepository;
import farm.tomato.repository.TomatoRepository;
import farm.tomato.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final TomatoRepository tomatoRepository;
    private final MyItemRepository myItemRepository;
    private final PestRepository pestRepository;

    @Override
    public List<ItemDTO> findAllItem() {
        List<ItemDTO> item = itemRepository.findAllItem();
        return item;
    }

    @Override
    @Transactional(readOnly = false)
    public void changePercentage(Long fieldId, Long itemId) {
        MyItem myItem = myItemRepository.findById(itemId).get();

        myItem.checkQuantity();

        //해충 생성 확률 감소
        tomatoRepository.findAllTomato(fieldId).stream()
                .forEach(o -> o.getPest().setPercentage(201));

    }

    @Override
    @Transactional(readOnly = false)
    public void removePest(Long fieldId, Long itemId) {
        MyItem myItem = myItemRepository.findById(itemId).get();

        myItem.checkQuantity();

        List<PestTureTomatoDTO> pestTomato = tomatoRepository.findPestTomato(fieldId);
        for (PestTureTomatoDTO tomato : pestTomato) {
            if(tomato.getTomatoes().getLevel() == 2) {
                tomato.getTomatoes().setImagePath("smalltomato.PNG");
            }else if(tomato.getTomatoes().getLevel() == 3)
                tomato.getTomatoes().setImagePath("tomato.PNG");

            tomato.getPest().setExistence(false);
        }


//                .stream().forEach(o -> {
//                    o.getPest().setExistence(false);
//                    if(o.getTomatoes().getLevel() == 2)
//                        o.getTomatoes().setImagePath("smalltomato.PNG");
//                    else if(o.getTomatoes().getLevel() == 3)
//                        o.getTomatoes().setImagePath("tomato.PNG");
//                });

//                .forEach(o -> { o.getPest().setExistence(false);
//                                if(o.getLevel() == 2)
//                                    o.setImagePath("smalltomato.PNG");
//                                else if(o.getLevel() == 3)
//                                    o.setImagePath("tomato.PNG");
//                });
    }
}
