package com.example.demo.controller;

import com.example.demo.model.HashTableLogic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HashTableController {

    private final HashTableLogic hashTable = new HashTableLogic();

    @GetMapping("/hash-table")
    public String showPage(Model model) {
        model.addAttribute("ergebnis", hashTable.getTableAsString());
        // WICHTIG: Stelle sicher, dass deine HTML-Datei genau "hash-table.html" heißt!
        return "hash-table";
    }

    @PostMapping("/hash-table/operation")
    public String handleOperation(@RequestParam(value = "key", required = false) String key,
                                  @RequestParam(value = "value", required = false) String value,
                                  @RequestParam("aktion") String aktion,
                                  Model model) {

        // Wir brauchen für jede Aktion zumindest einen Key
        if (key != null && !key.trim().isEmpty()) {
            switch (aktion) {
                case "put":
                    if (value != null && !value.trim().isEmpty()) {
                        hashTable.put(key, value);
                    }
                    break;
                case "get":
                    hashTable.get(key);
                    break;
                case "remove":
                    hashTable.remove(key);
                    break;
            }
        }

        model.addAttribute("ergebnis", hashTable.getTableAsString());
        return "hash-table";
    }
}
