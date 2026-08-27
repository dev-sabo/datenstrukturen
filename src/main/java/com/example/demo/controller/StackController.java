package com.example.demo.controller;

import com.example.demo.model.StackLogik;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StackController {

    private StackLogik meinStack = new StackLogik();

    // 1. Zeigt die Stack-Seite an und übergibt die aktuellen Elemente
    @GetMapping("/stack")
    public String zeigeStack(Model model) {
        model.addAttribute("stackInhalt", meinStack.getElemente());
        return "stack";
    }

    // 2. Wird aufgerufen, wenn du den "Push"-Button drückst
    @PostMapping("/stack/push")
    public String stackPush(@RequestParam("wert") String wert) {
        if (wert != null && !wert.trim().isEmpty()) {
            meinStack.push(wert);
        }
        return "redirect:/stack";
    }

    // 3. Wird aufgerufen, wenn du den "Pop"-Button drückst
    @PostMapping("/stack/pop")
    public String stackPop() {
        meinStack.pop();
        return "redirect:/stack";
    }
}