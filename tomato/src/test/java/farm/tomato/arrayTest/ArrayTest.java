package farm.tomato.arrayTest;

import farm.tomato.domain.Field;
import farm.tomato.domain.Tomato;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;

@SpringBootTest
@Transactional
public class ArrayTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional(readOnly = false)
    @Rollback(value = false)
    void arrayTest() {
        Tomato tomato1 = new Tomato(1, 0, 3);
        em.persist(tomato1);
        Tomato tomato2 = new Tomato(1, 1, 3);
        em.persist(tomato1);
        Tomato tomato3 = new Tomato(1, 2, 3);
        em.persist(tomato1);

        Field field = new Field();
        List<Tomato> tomatoes = field.getTomatoes();


        tomatoes.add(tomato1);
        tomatoes.add(tomato2);
        tomatoes.add(tomato3);
        em.persist(field);
    }


}
