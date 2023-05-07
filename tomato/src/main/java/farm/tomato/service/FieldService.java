package farm.tomato.service;

import farm.tomato.domain.dto.FieldDTO;

import java.util.List;

public interface FieldService {

    List<FieldDTO> findAllField();

     void findFieldInfo(Long fieldId);
}
