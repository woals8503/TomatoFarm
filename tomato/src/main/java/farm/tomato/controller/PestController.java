package farm.tomato.controller;

import farm.tomato.service.PestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PestController {
    private final PestService pestService;
}
