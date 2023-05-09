package farm.tomato.repository.Impl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import farm.tomato.domain.QField;
import farm.tomato.domain.QPest;
import farm.tomato.domain.QTomato;
import farm.tomato.domain.Tomato;
import farm.tomato.domain.dto.QTomatoDTO;
import farm.tomato.domain.dto.TomatoDTO;
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
}
