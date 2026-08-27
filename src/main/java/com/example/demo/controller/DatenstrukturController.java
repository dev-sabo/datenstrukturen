package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatenstrukturController {

   /* @GetMapping("/stack")
    public String zeigeStack() { return "stack"; } */

   /* @GetMapping("/queue")
    public String zeigeQueue() { return "queue"; }*/

   /* @GetMapping("/linked-list")
    public String zeigeLinkedList() { return "linked-list"; } */

    @GetMapping("/binary-tree")
    public String zeigeBinaryTree() { return "binary-tree"; }

    /*@GetMapping("/hash-table")
    public String zeigeHashTable() { return "hash-table"; } */

    @GetMapping("/graph")
    public String zeigeGraph() { return "graph"; }
}
