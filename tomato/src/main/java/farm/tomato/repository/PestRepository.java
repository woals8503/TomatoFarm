package farm.tomato.repository;

import farm.tomato.domain.Pest;
import farm.tomato.repository.custom.PestRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PestRepository extends JpaRepository<Pest, Long>, PestRepositoryCustom {
}
