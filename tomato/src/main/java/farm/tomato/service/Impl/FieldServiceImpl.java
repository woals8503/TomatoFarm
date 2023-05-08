package farm.tomato.service.Impl;

import farm.tomato.domain.Member;
import farm.tomato.domain.Tomato;
import farm.tomato.domain.dto.FieldDTO;
import farm.tomato.domain.dto.FieldDetailDTO;
import farm.tomato.domain.dto.TomatoDTO;
import farm.tomato.repository.FieldRepository;
import farm.tomato.repository.TomatoRepository;
import farm.tomato.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldRepository fieldRepository;
    @Autowired
    private TomatoRepository tomatoRepository;

    @Override
    public List<FieldDTO> findAllField(Optional<Member> member) {
        List<FieldDTO> fieldDto = fieldRepository.findField(member).stream()
                .map(o -> FieldDTO.builder()
                        .id(o.getId())
                        .name("밭" + o.getId()).build()
                ).collect(Collectors.toList());
        return fieldDto;
    }

    @Override
    public FieldDetailDTO findFieldInfo(Long fieldId) {
        // 모든 토마토 조회

        List<TomatoDTO> tomatoes = tomatoRepository.findAllTomato(fieldId).stream()
                .map(o -> TomatoDTO.builder()
                        .id(o.getId())
                        .level(o.getLevel())
                        .listIndex(o.getListIndex())
                        .life(o.getLife())
                        .existence(o.isExistence())
                        .imagePath(o.getImagePath())
                        .build()
                ).collect(Collectors.toList());


        FieldDetailDTO field = fieldRepository.findById(fieldId)
                .map(o -> FieldDetailDTO.builder()
                        .id(fieldId)
                        .tomatoes(tomatoes)
                        .fieldLength(o.getFieldLength())
                        .build()).get();

        return field;
    }
}
