package farm.tomato.controller;

import farm.tomato.domain.Member;
import farm.tomato.domain.dto.MemberDTO;
import farm.tomato.service.FieldService;
import farm.tomato.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;
    private final MemberService memberService;

    @GetMapping("/fieldDetail/{id}")
    public String fieldDetail(
            @PathVariable("id") Long fieldId,
            Model model) {
        model.addAttribute("field", fieldService.findFieldInfo(fieldId));
        model.addAttribute("member", memberService.findMember());
        return "field";
    }

    @GetMapping("/selectfield")
        public String selectField(
                Model model) {
            //1. 먼저 회원이 가지고있는 필드의 정보를 모두 불러온다.
            MemberDTO member = memberService.findMember();
            model.addAttribute("field", fieldService.findAllField(member.getId()));
            model.addAttribute("member", member);
            return "selectfield";
    }

    @GetMapping("/field/create")
    public String createField() {
        fieldService.createField();
        return "redirect:/selectfield";
    }

}
