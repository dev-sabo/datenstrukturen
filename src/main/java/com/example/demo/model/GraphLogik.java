package com.example.demo.model; // oder im passenden Paket

import java.util.ArrayList;
import java.util.List;

public class StackLogik {
    private List<String> elemente = new ArrayList<>();

    public void push(String wert) {
        elemente.add(wert);
    }

    public String pop() {
        if (elemente.isEmpty()) {
            return "Stack ist leer!";
        }
        return elemente.remove(elemente.size() - 1);
    }

    public List<String> getElemente() {
        return new ArrayList<>(elemente);
    }
}
