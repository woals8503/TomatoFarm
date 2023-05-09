package farm.tomato.service.Impl;

import farm.tomato.domain.Member;
import farm.tomato.domain.Tomato;
import farm.tomato.repository.FieldRepository;
import farm.tomato.repository.MemberRepository;
import farm.tomato.repository.TomatoRepository;
import farm.tomato.service.TomatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TomatoServiceImpl implements TomatoService {
    private final TomatoRepository tomatoRepository;
    private final MemberRepository memberRepository;
    private final FieldRepository fieldRepository;

    @Override
    @Transactional(readOnly = false)
    public void createTomato(Long tomatoId) {
        Tomato tomato = tomatoRepository.findById(tomatoId).get();
        //더티체킹
        if(!tomato.isExistence())
            tomato.plant();
    }

    @Override
    @Transactional(readOnly = false)
    public void water(Long tomatoId) {
        Tomato tomato = tomatoRepository.findById(tomatoId).get();
        tomato.levelUp();
    }

    @Override
    @Transactional(readOnly = false)
    public void harvest(Long tomatoId, Long fieldId) {
        //토마토 정보
        Tomato tomato = tomatoRepository.findById(tomatoId).get();
        tomato.harvest();
        //멤버 정보
        Member member = memberRepository.findById(1L).get();
        member.addAmount();
    }

}
