package farm.tomato.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import farm.tomato.domain.Tomato;
import farm.tomato.domain.dto.TomatoDTO;
import farm.tomato.repository.custom.TomatoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TomatoRepository extends JpaRepository<Tomato, Long>, TomatoRepositoryCustom {
}
