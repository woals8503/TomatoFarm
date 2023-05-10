package farm.tomato.repository.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import farm.tomato.domain.Pest;
import farm.tomato.repository.custom.PestRepositoryCustom;

import javax.persistence.EntityManager;

import java.util.List;

import static farm.tomato.domain.QPest.*;
import static farm.tomato.domain.QTomato.*;

public class PestRepositoryImpl implements PestRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public PestRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

}
