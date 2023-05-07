package farm.tomato.controller;

import farm.tomato.service.Impl.FieldServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class FieldController {

    @Autowired
    private FieldServiceImpl gameService;

    @GetMapping("/game/start")
    public String start(Model model) {
        gameService.createField();

        return "field";
    }

}
