package farm.tomato.controller;

import farm.tomato.domain.Member;
import farm.tomato.service.FieldService;
import farm.tomato.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;
    private final MemberService memberService;

    @GetMapping("/fieldDetail")
    public String fieldDetail(
            @RequestParam(value = "id") Long fieldId,
            Model model) {
        fieldService.findFieldInfo(fieldId);
        return "field";
    }

    @GetMapping("/selectfield")
    public String selectField(Model model) {
        //1. 먼저 회원이 가지고있는 필드의 정보를 모두 불러온다.
        Optional<Member> member = memberService.findMember();
        model.addAttribute("field", fieldService.findAllField(member));
        return "selectfield";
    }

}
