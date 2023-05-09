package farm.tomato.service.Impl;

import farm.tomato.domain.Member;
import farm.tomato.domain.dto.MemberDTO;
import farm.tomato.repository.MemberRepository;
import farm.tomato.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public MemberDTO findMember() {
        return memberRepository.findById(1L)
                .map(o -> MemberDTO.builder()
                        .id(o.getId())
                        .amount(o.getAmount())
                        .myItemList(o.getMyItems()).build())
                .get();
    }
}
