package farm.tomato.repository;

import farm.tomato.domain.MyItem;
import farm.tomato.repository.custom.MyItemRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyItemRepository extends JpaRepository<MyItem, Long>, MyItemRepositoryCustom {
}
