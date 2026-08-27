package com.example.demo.model;

public class LinkedListLogic {
    private Node head;

    public LinkedListLogic() {
        this.head = null;
    }

    // Hinten anfügen (Append)
    public void append(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    // Vorne anfügen (Prepend)
    public void prepend(String data) {
        Node newNode = new Node(data);
        newNode.setNext(head);
        head = newNode;
    }

    // Element löschen (entfernt das erste Vorkommen des Werts)
    public void delete(String data) {
        if (head == null) return;

        if (head.getData().equals(data)) {
            head = head.getNext();
            return;
        }

        Node current = head;
        while (current.getNext() != null) {
            if (current.getNext().getData().equals(data)) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    // Gibt die Liste als lesbaren String zurück (z.B. "A -> B -> C -> null")
    public String getListAsString() {
        if (head == null) {
            return "Die Liste ist leer.";
        }
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.getData());
            if (current.getNext() != null) {
                sb.append(" -> ");
            }
            current = current.getNext();
        }
        return sb.toString();
    }
}