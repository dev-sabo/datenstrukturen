package com.example.demo.controller;

import com.example.demo.model.GraphLogic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GraphController {

    private final GraphLogic graph = new GraphLogic();

    @GetMapping("/graph")
    public String showPage(Model model) {
        model.addAttribute("ergebnis", graph.getGraphAsString());
        // Dein HTML File muss exakt "graph.html" heißen
        return "graph";
    }

    @PostMapping("/graph/operation")
    public String handleOperation(@RequestParam(value = "node", required = false) String node,
                                  @RequestParam(value = "fromNode", required = false) String fromNode,
                                  @RequestParam(value = "toNode", required = false) String toNode,
                                  @RequestParam("aktion") String aktion,
                                  Model model) {

        switch (aktion) {
            case "addNode":
                if (node != null && !node.trim().isEmpty()) {
                    graph.addNode(node.trim());
                }
                break;

            case "addEdge":
                if (fromNode != null && !fromNode.trim().isEmpty() &&
                        toNode != null && !toNode.trim().isEmpty()) {
                    graph.addEdge(fromNode.trim(), toNode.trim());
                }
                break;
        }

        model.addAttribute("ergebnis", graph.getGraphAsString());
        return "graph";
    }
}
