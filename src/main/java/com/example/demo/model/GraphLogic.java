package com.example.demo.model;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class GraphLogic {
    // Speichert den Graphen als Adjazenzliste
    private final Map<String, Set<String>> adjacencyList = new LinkedHashMap<>();
    private String lastMessage = "";

    public void addNode(String node) {
        if (adjacencyList.containsKey(node)) {
            lastMessage = "<span style='color: orange;'>Knoten '" + node + "' existiert bereits.</span>";
        } else {
            adjacencyList.put(node, new LinkedHashSet<>());
            lastMessage = "<span style='color: green;'>Knoten '" + node + "' erfolgreich hinzugefügt.</span>";
        }
    }

    public void addEdge(String from, String to) {
        // Prüfen, ob beide Knoten existieren
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            lastMessage = "<span style='color: red;'>Fehler: Beide Knoten müssen existieren, bevor eine Kante erstellt wird.</span>";
            return;
        }

        // Kante in beide Richtungen hinzufügen (ungerichteter Graph)
        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
        lastMessage = "<span style='color: green;'>Kante zwischen '" + from + "' und '" + to + "' erfolgreich erstellt.</span>";
    }

    public String getGraphAsString() {
        StringBuilder sb = new StringBuilder();

        if (!lastMessage.isEmpty()) {
            sb.append(lastMessage).append("<br><br>");
        }

        sb.append("<strong>Aktuelle Struktur des Graphen:</strong><br>");

        if (adjacencyList.isEmpty()) {
            sb.append("<em>Der Graph ist aktuell leer.</em>");
        } else {
            for (Map.Entry<String, Set<String>> entry : adjacencyList.entrySet()) {
                sb.append("<strong>").append(entry.getKey()).append("</strong>: ");

                if (entry.getValue().isEmpty()) {
                    sb.append("<em>(keine Verbindungen)</em>");
                } else {
                    sb.append(String.join(", ", entry.getValue()));
                }
                sb.append("<br>");
            }
        }

        return sb.toString();
    }
}
