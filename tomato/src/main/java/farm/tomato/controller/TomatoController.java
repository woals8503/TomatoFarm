package farm.tomato.controller;

import farm.tomato.service.TomatoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TomatoController {
    private final TomatoService tomatoService;

    @ResponseBody
    @PostMapping("/tomato/plant")
    public String plantSeed(@RequestParam("tomatoId") Long tomatoId,
                            @RequestParam("fieldId") String fieldId) {
        tomatoService.createTomato(tomatoId);
        return fieldId;
    }

    @ResponseBody
    @PostMapping("/tomato/water")
    public String water(@RequestParam("tomatoId") Long tomatoId,
                            @RequestParam("fieldId") String fieldId) {
        tomatoService.water(tomatoId);
        return fieldId;
    }

    @ResponseBody
    @PostMapping("/tomato/harvest")
    public String harvest(@RequestParam("tomatoId") Long tomatoId,
                        @RequestParam("fieldId") Long fieldId) {
        tomatoService.harvest(tomatoId, fieldId);
        return String.valueOf(fieldId);
    }
}
