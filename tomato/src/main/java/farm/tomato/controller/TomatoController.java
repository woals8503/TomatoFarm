package farm.tomato.controller;

import farm.tomato.service.TomatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TomatoController {
    private final TomatoService tomatoService;
}
