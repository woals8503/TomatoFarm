package farm.tomato.service.Impl;

import com.querydsl.core.Tuple;
import farm.tomato.domain.Field;
import farm.tomato.domain.Member;
import farm.tomato.domain.Pest;
import farm.tomato.domain.Tomato;
import farm.tomato.domain.dto.FieldDTO;
import farm.tomato.domain.dto.FieldDetailDTO;
import farm.tomato.domain.dto.TomatoDTO;
import farm.tomato.domain.embedded.FieldLength;
import farm.tomato.repository.FieldRepository;
import farm.tomato.repository.MemberRepository;
import farm.tomato.repository.PestRepository;
import farm.tomato.repository.TomatoRepository;
import farm.tomato.service.FieldService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FieldServiceImpl implements FieldService {

    @Autowired
    private final FieldRepository fieldRepository;
    @Autowired
    private final TomatoRepository tomatoRepository;
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final PestRepository pestRepository;

    @Override
    public List<FieldDTO> findAllField(Long memberId) {
        List<FieldDTO> fieldDto = fieldRepository.findField(memberId).stream()
                .map(o -> FieldDTO.builder()
                        .id(o.getId())
                        .name("밭" + o.getId()).build()
                ).collect(Collectors.toList());
        return fieldDto;
    }

    @Override
    public FieldDetailDTO findFieldInfo(Long fieldId) {
        // 모든 토마토 조회

        List<TomatoDTO> tomatoes = tomatoRepository.findAllTomato(fieldId)
                .stream()
                .map(o -> TomatoDTO.builder()
                        .id(o.getId())
                        .level(o.getLevel())
                        .listIndex(o.getListIndex())
                        .life(o.getLife())
                        .existence(o.isExistence())
                        .imagePath(o.getImagePath())
                        .pest(o.getPest())
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

    @Override
    @Transactional
    public void createField() {
        //다중 insert문제. 이유 -> save로 Transacional를 두번 하기 때문이다.
        Member member = memberRepository.findById(1l).get();
        FieldLength fieldLength = new FieldLength(5, 5);
        Field field = new Field();
        field.setFieldLength(fieldLength);
        field.setMember(member);
        int num = 1;

        List<Tomato> tomatoes = new LinkedList<>();

        //토마토 생성
        for(int i=1; i<=fieldLength.getHeight(); i++) {
            for(int j=0; j<fieldLength.getWidth(); j++) {
                Pest pest = new Pest(1, false, 101, "pest.PNG");
                Tomato tomato = new Tomato(1, num, 3, false, "none.PNG", field, pest);
                tomatoes.add(tomato);
                num++;
            }
        }
        field.setTomatoes(tomatoes);
        fieldRepository.save(field);
    }
}
