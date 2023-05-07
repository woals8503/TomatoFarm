package farm.tomato.service.Impl;

import farm.tomato.domain.Member;
import farm.tomato.repository.MemberRepository;
import farm.tomato.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member findMember() {
        List<Member> findMember = memberRepository.findAll();
        return null;
    }
}
