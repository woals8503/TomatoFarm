package farm.tomato.repository;

import farm.tomato.domain.Tomato;
import farm.tomato.repository.custom.TomatoRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TomatoRepository extends JpaRepository<Tomato, Long>, TomatoRepositoryCustom {
}
