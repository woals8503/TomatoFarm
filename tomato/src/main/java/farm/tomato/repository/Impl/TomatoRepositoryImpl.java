package farm.tomato.repository.Impl;


import com.querydsl.jpa.impl.JPAQueryFactory;

import farm.tomato.domain.Tomato;
import farm.tomato.domain.dto.PestTureTomatoDTO;
import farm.tomato.domain.dto.QPestTureTomatoDTO;
import farm.tomato.repository.custom.TomatoRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

import static farm.tomato.domain.QField.*;
import static farm.tomato.domain.QPest.*;
import static farm.tomato.domain.QTomato.*;

@Repository
public class TomatoRepositoryImpl implements TomatoRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public TomatoRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }


    @Override
    public List<Tomato> findAllTomato(Long fieldId) {
        return queryFactory
                .select(tomato)
                .from(tomato)
                .where(tomato.field.id.eq(fieldId))
                .fetch();

    }

    @Override
    public List<PestTureTomatoDTO> findPestTomato(Long fieldId) {
        return queryFactory
                .select(new QPestTureTomatoDTO(tomato, pest))
                .from(tomato)
                .innerJoin(pest)
                .on(tomato.pest.id.eq(pest.id))
                .where(tomato.field.id.eq(fieldId)
                        .and(pest.existence.eq(true))
                )
                .fetch();
    }

}
