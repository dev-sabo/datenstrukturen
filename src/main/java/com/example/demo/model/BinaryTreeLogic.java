package com.example.demo.model;

public class BinaryTreeLogic {

    // Die innere Klasse für einen Knoten im Baum
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private Node root;
    private String lastMessage = "";

    // Methode zum Setzen von Fehlermeldungen (z.B. wenn keine Zahl eingegeben wird)
    public void setErrorMessage(String msg) {
        this.lastMessage = "<span style='color: red;'>" + msg + "</span>";
    }

    // Fügt eine neue Zahl ein
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            lastMessage = "<span style='color: green;'>Wert " + value + " als Wurzel eingefügt.</span>";
        } else {
            if (insertRecursive(root, value)) {
                lastMessage = "<span style='color: green;'>Wert " + value + " erfolgreich eingefügt.</span>";
            } else {
                lastMessage = "<span style='color: orange;'>Wert " + value + " existiert bereits im Baum.</span>";
            }
        }
    }

    private boolean insertRecursive(Node current, int value) {
        if (value == current.value) {
            return false; // Wert existiert schon, wir fügen nichts doppelt ein
        }

        if (value < current.value) { // Kleiner -> nach links
            if (current.left == null) {
                current.left = new Node(value);
                return true;
            }
            return insertRecursive(current.left, value);
        } else { // Größer -> nach rechts
            if (current.right == null) {
                current.right = new Node(value);
                return true;
            }
            return insertRecursive(current.right, value);
        }
    }

    // Sucht nach einer Zahl
    public void search(int value) {
        if (searchRecursive(root, value)) {
            lastMessage = "<span style='color: blue;'>Gefunden: Der Wert " + value + " ist im Baum vorhanden!</span>";
        } else {
            lastMessage = "<span style='color: red;'>Nicht gefunden: Der Wert " + value + " existiert im Baum nicht.</span>";
        }
    }

    private boolean searchRecursive(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (value == current.value) {
            return true;
        }
        // Rekursiv weiter suchen: links oder rechts
        return value < current.value
                ? searchRecursive(current.left, value)
                : searchRecursive(current.right, value);
    }

    // Baut das HTML für die Anzeige zusammen
    public String getTreeAsString() {
        StringBuilder sb = new StringBuilder();

        if (!lastMessage.isEmpty()) {
            sb.append(lastMessage).append("<br><br>");
        }

        sb.append("<strong>Visuelle Struktur des Baumes:</strong><br>");

        if (root == null) {
            sb.append("<em>Der Baum ist aktuell leer.</em>");
        } else {
            // Wir zeichnen den Baum mit einer monospace-Schriftart, damit die Striche passen
            sb.append("<pre style='font-family: monospace; background: #eee; padding: 10px; border-radius: 4px; overflow-x: auto;'>");
            buildTreeVisual(root, "", true, sb);
            sb.append("</pre>");

            sb.append("<br><strong>In-Order Traversal (automatisch sortiert):</strong><br>");
            sb.append("<span style='color: #2980b9;'>").append(getInOrder(root).trim()).append("</span>");
        }

        return sb.toString();
    }

    // Hilfsmethode, um den Baum wie eine Ordnerstruktur zu zeichnen
    private void buildTreeVisual(Node node, String indent, boolean last, StringBuilder sb) {
        if (node != null) {
            sb.append(indent).append(last ? "└── " : "├── ").append(node.value).append("\n");
            indent += last ? "    " : "│   ";
            buildTreeVisual(node.left, indent, node.right == null, sb);
            buildTreeVisual(node.right, indent, true, sb);
        }
    }

    // Gibt die sortierte Reihenfolge der Zahlen aus
    private String getInOrder(Node node) {
        if (node == null) return "";
        return getInOrder(node.left) + node.value + " " + getInOrder(node.right);
    }
}
