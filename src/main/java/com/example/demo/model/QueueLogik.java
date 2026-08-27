package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class QueueLogik<T> {

    private List<T> elements = new ArrayList<>();

    // Element am Ende hinzufügen (Enqueue)
    public void enqueue(T item) {
        elements.add(item);
    }

    // Das vorderste Element entfernen und zurückgeben (Dequeue)
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Die Queue ist leer!");
        }
        return elements.remove(0);
    }

    // Das vorderste Element ansehen, ohne es zu entfernen (Peek)
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Die Queue ist leer!");
        }
        return elements.get(0);
    }

    // Prüfen, ob die Queue leer ist
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Größe der Queue abrufen
    public int size() {
        return elements.size();
    }

    // Gesamte Queue als Liste abrufen (praktisch für die Thymeleaf-Anzeige)
    public List<T> getElements() {
        return new ArrayList<>(elements);
    }
}
