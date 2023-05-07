package farm.tomato.service;

import farm.tomato.domain.Member;
import farm.tomato.domain.dto.FieldDTO;

import java.util.List;
import java.util.Optional;

public interface FieldService {

    List<FieldDTO> findAllField(Optional<Member> member);

     void findFieldInfo(Long fieldId);
}
