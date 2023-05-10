package farm.tomato.repository.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import farm.tomato.domain.QItem;
import farm.tomato.domain.dto.ItemDTO;
import farm.tomato.domain.dto.QItemDTO;
import farm.tomato.repository.custom.ItemRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

import static farm.tomato.domain.QItem.*;

@Repository
public class ItemRepositoryImpl implements ItemRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ItemRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ItemDTO> findAllItem() {
        return queryFactory
                .select(new QItemDTO(item.id, item.name, item.price, item.stockQuantity))
                .from(item)
                .fetch();

    }
}
