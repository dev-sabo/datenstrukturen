package com.example.demo.controller;

import com.example.demo.model.StackLogik;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StackController {

    private final StackLogik meinStack = new StackLogik();

    @GetMapping("/stack")
    public String zeigeStack(Model model) {
        model.addAttribute("stackInhalt", meinStack.getElemente());
        return "stack";
    }

    @PostMapping("/stack/push")
    public String stackPush(@RequestParam("wert") String wert) {
        if (wert != null && !wert.trim().isEmpty()) {
            meinStack.push(wert);
        }
        return "redirect:/stack";
    }

    @PostMapping("/stack/pop")
    public String stackPop() {
        meinStack.pop();
        return "redirect:/stack";
    }
}
