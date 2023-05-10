package farm.tomato.service;

import farm.tomato.domain.Member;
import farm.tomato.domain.dto.MemberDTO;

import java.util.Optional;

public interface MemberService {

    MemberDTO findMember();
}
