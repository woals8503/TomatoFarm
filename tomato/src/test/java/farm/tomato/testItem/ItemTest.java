package farm.tomato.testItem;

import farm.tomato.domain.Field;
import farm.tomato.domain.Member;
import farm.tomato.domain.Tomato;
import farm.tomato.domain.item.Item;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
@Transactional
public class ItemTest {

    @PersistenceContext
    EntityManager em;

    @Test
    @Transactional(readOnly = false)
    @Rollback(value = false)
    void ItemTest() {
        Item item1 = new Item("농약", 20000, 50);
        Item item2 = new Item("영양제", 20000, 50);
        Item item3 = new Item("해충 박멸", 20000, 50);

        em.persist(item1);
        em.persist(item2);
        em.persist(item3);

        Field field = new Field();
        em.persist(field);

        Member member = new Member();
        member.setName("농부1");
        member.createField(field);
        em.persist(member);

        List<Item> items = member.getItems();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        em.flush();
        em.clear();

        List<Item> items1 = member.getItems();
        for (Item item : items1) {
            System.out.println("item = " + item.getName());
        }
    }

    @Test
    @Rollback(value = false)
    @Transactional(readOnly = false)
    void itemTest2() {
        Item item = new Item("영양제", 20000, 50);
        em.persist(item);

        Tomato tomato1 = new Tomato(1, 0, 3);
        Tomato tomato2 = new Tomato(1, 15, 3);
        Tomato tomato3 = new Tomato(1, 20, 3);
        em.persist(tomato1);
        em.persist(tomato2);
        em.persist(tomato3);

        Field field = new Field();
        em.persist(field);

        Member member = new Member();
        member.setName("농부1");
        member.createField(field);
        member.createItem(item);
        em.persist(member);

        List<Tomato> tomatoes = field.getTomatoes();
        tomatoes.add(tomato1);
        tomatoes.add(tomato2);
        tomatoes.add(tomato3);

        for (Tomato tomato : tomatoes) {
            tomato.levelUp();
        }

        item.removeStock();

    }



}
