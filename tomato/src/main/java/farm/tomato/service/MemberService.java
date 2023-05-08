package farm.tomato.service;

import farm.tomato.domain.Member;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findMember();
}
