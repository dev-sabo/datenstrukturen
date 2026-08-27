package com.example.demo.controller;

import com.example.demo.model.BinaryTreeLogic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BinaryTreeController {

    private final BinaryTreeLogic binaryTree = new BinaryTreeLogic();

    @GetMapping("/binary-tree")
    public String showPage(Model model) {
        model.addAttribute("ergebnis", binaryTree.getTreeAsString());
        return "binary-tree";
    }

    @PostMapping("/binary-tree/operation")
    public String handleOperation(@RequestParam(value = "value", required = false) String valueStr,
                                  @RequestParam("aktion") String aktion,
                                  Model model) {

        if (valueStr != null && !valueStr.trim().isEmpty()) {
            try {
                // Versuchen, die Eingabe in eine Zahl umzuwandeln
                int value = Integer.parseInt(valueStr.trim());

                switch (aktion) {
                    case "insert":
                        binaryTree.insert(value);
                        break;
                    case "search":
                        binaryTree.search(value);
                        break;
                }
            } catch (NumberFormatException e) {
                // Falls der User "Test" statt "15" eintippt
                binaryTree.setErrorMessage("Fehler: Bitte gib eine gültige Ganzzahl ein (z.B. 15 oder 42)!");
            }
        }

        model.addAttribute("ergebnis", binaryTree.getTreeAsString());
        return "binary-tree";
    }
}