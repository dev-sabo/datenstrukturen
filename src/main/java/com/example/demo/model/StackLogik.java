package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class StackLogik {
    private List<String> elemente = new ArrayList<>();

    // Push: Element oben auf den Stack legen
    public void push(String wert) {
        elemente.add(wert);
    }

    // Pop: Oberstes Element entfernen und zurückgeben
    public String pop() {
        if (elemente.isEmpty()) {
            return "Stack ist leer!";
        }
        return elemente.remove(elemente.size() - 1);
    }

    // Aktuellen Zustand abrufen
    public List<String> getElemente() {
        return new ArrayList<>(elemente);
    }
}
