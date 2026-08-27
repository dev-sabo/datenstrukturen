package com.example.demo.controller;

import com.example.demo.model.QueueLogik;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QueueController {

    // Instanz der Queue (für ein einfaches Beispiel im Speicher)
    private QueueLogik<String> queue = new QueueLogik<>();

    @GetMapping("/queue")
    public String showQueue(Model model) {
        model.addAttribute("queueElements", queue.getElements());
        return "queue"; // Entspricht deiner queue-view.html
    }

    @PostMapping("/queue/enqueue")
    public String enqueueItem(@RequestParam("item") String item) {
        if (item != null && !item.trim().isEmpty()) {
            queue.enqueue(item);
        }
        return "redirect:/queue";
    }

    @PostMapping("/queue/dequeue")
    public String dequeueItem() {
        if (!queue.isEmpty()) {
            queue.dequeue();
        }
        return "redirect:/queue";
    }
}
