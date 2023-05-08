package farm.tomato.repository.Impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import farm.tomato.domain.Field;
import farm.tomato.domain.Member;
import farm.tomato.domain.QField;
import farm.tomato.repository.custom.FieldRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static farm.tomato.domain.QField.*;


@Repository
public class FieldRepositoryImpl implements FieldRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public FieldRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Field> findField(Optional<Member> member) {
        return queryFactory.selectFrom(field)
                .where(field.member.id.eq(member.get().getId())).fetch();
    }
}
