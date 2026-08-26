package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatenstrukturController {

    private StackLogik meinStack = new StackLogik();

    // (Später kommen hier noch die Instanzen für die anderen hin, z.B.:)
    // private QueueLogik meineQueue = new QueueLogik();


    // 2. Das GetMapping ist nur dafür da, die Seite im Browser anzuzeigen
    @GetMapping("/stack")
    public String zeigeStack(Model model) {
        // Hier greift die Methode auf deine Instanz zu und gibt die Daten an HTML weiter
        model.addAttribute("stackInhalt", meinStack.getElemente());
        return "stack";
    }

    @GetMapping("/stack")
    public String zeigeStack() { return "stack"; }

    @GetMapping("/queue")
    public String zeigeQueue() { return "queue"; }

    @GetMapping("/linked-list")
    public String zeigeLinkedList() { return "linked-list"; }

    @GetMapping("/binary-tree")
    public String zeigeBinaryTree() { return "binary-tree"; }

    @GetMapping("/hash-table")
    public String zeigeHashTable() { return "hash-table"; }

    @GetMapping("/graph")
    public String zeigeGraph() { return "graph"; }
}
