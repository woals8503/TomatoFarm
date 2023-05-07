package farm.tomato.service.Impl;

import farm.tomato.domain.Member;
import farm.tomato.domain.dto.FieldDTO;
import farm.tomato.repository.FieldRepository;
import farm.tomato.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldRepository fieldRepository;

    @Override
    public void findFieldInfo(Long fieldId) {



//        fieldRepository.findById(fieldId)
//                .map(o -> FieldDetailDTO.builder()
//                        .id(fieldId)
//                        .tomatoes()
//                );
    }

    @Override
    public List<FieldDTO> findAllField(Optional<Member> member) {
        List<FieldDTO> fieldDto = fieldRepository.findField(member).stream()
                .map(o -> FieldDTO.builder()
                        .id(o.getId())
                        .name("밭" + o.getId()).build()
                ).collect(Collectors.toList());
        return fieldDto;
    }
}
