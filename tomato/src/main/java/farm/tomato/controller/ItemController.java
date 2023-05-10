package farm.tomato.controller;

import farm.tomato.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("item", itemService.findAllItem());
        return "shop";
    }

    @ResponseBody
    @PostMapping("/item/pesticide")
    public String pesticide(
            @RequestParam("fieldId") Long fieldId,
            @RequestParam("itemId") Long itemId) {
        itemService.changePercentage(fieldId, itemId);
        return String.valueOf(fieldId);
    }

    @ResponseBody
    @PostMapping("/item/exterminate")
    public String exterminate(
            @RequestParam("fieldId") Long fieldId,
            @RequestParam("itemId") Long itemId) {
        itemService.removePest(fieldId, itemId);
        return String.valueOf(fieldId);
    }
}
