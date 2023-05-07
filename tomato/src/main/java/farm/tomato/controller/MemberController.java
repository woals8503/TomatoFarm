package farm.tomato.controller;

import farm.tomato.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private MemberService memberService;

}
