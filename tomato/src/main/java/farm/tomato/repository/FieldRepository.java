package farm.tomato.repository;

import farm.tomato.domain.Field;
import farm.tomato.repository.custom.FieldRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field, Long>, FieldRepositoryCustom {

}
