package farm.tomato.service;

import farm.tomato.domain.Member;
import farm.tomato.domain.dto.FieldDTO;
import farm.tomato.domain.dto.FieldDetailDTO;

import java.util.List;
import java.util.Optional;

public interface FieldService {

    List<FieldDTO> findAllField(Optional<Member> member);

    FieldDetailDTO findFieldInfo(Long fieldId);

    void createField();
}
