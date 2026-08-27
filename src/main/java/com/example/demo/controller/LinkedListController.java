package com.example.demo.controller;

import com.example.demo.model.LinkedListLogic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LinkedListController {

    private final LinkedListLogic linkedList = new LinkedListLogic();

    @GetMapping("/linked-list")
    public String showPage(Model model) {
        // Korrektur: addAttribute statt ergebnis
        model.addAttribute("ergebnis", linkedList.getListAsString());
        return "linked-list";
    }

    @PostMapping("/linked-list/operation")
    public String handleOperation(@RequestParam(value = "wert", required = false) String wert,
                                  @RequestParam("aktion") String aktion,
                                  Model model) {

        switch (aktion) {
            case "append":
                if (wert != null && !wert.trim().isEmpty()) {
                    linkedList.append(wert);
                }
                break;
            case "prepend":
                if (wert != null && !wert.trim().isEmpty()) {
                    linkedList.prepend(wert);
                }
                break;
            case "delete":
                if (wert != null && !wert.trim().isEmpty()) {
                    linkedList.delete(wert);
                }
                break;
        }

        model.addAttribute("ergebnis", linkedList.getListAsString());
        return "linked-list";
    }
}