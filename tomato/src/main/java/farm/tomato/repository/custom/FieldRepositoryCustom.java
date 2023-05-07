package farm.tomato.repository.custom;

import farm.tomato.domain.Field;
import farm.tomato.domain.Member;

import java.util.List;
import java.util.Optional;

public interface FieldRepositoryCustom {
    List<Field> findField(Optional<Member> member);
}
