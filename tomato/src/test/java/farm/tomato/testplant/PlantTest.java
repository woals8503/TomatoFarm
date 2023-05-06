package farm.tomato.testplant;

import farm.tomato.domain.Field;
import farm.tomato.domain.Member;
import farm.tomato.domain.Tomato;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
@Transactional
public class PlantTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional(readOnly = false)
    @Rollback(value = false)
    void plantTest() {

        Tomato tomato1 = new Tomato(1, 0, 3);
        Tomato tomato2 = new Tomato(1, 15, 3);
        Tomato tomato3 = new Tomato(1, 20,3);
        em.persist(tomato1);
        em.persist(tomato2);
        em.persist(tomato3);


        Field field = new Field();
        em.persist(field);

        Member member = new Member();
        member.setName("농부1");
        member.createField(field);
        em.persist(member);

        List<Tomato> tomatoes = field.getTomatoes();
        tomatoes.add(tomato1);
        tomatoes.add(tomato2);
        tomatoes.add(tomato3);

    }

    @Test
    public void harvest() {

    }
}

