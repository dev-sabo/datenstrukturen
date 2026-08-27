package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class HashTableLogic {
    private final Map<String, String> map = new HashMap<>();
    private String lastMessage = ""; // Speichert die Rückmeldung der letzten Aktion

    public void put(String key, String value) {
        map.put(key, value);
        lastMessage = "<span style='color: green;'>Erfolgreich eingefügt: [" + key + " &rarr; " + value + "]</span>";
    }

    public void get(String key) {
        if (map.containsKey(key)) {
            lastMessage = "<span style='color: blue;'>Gefunden: Der Wert für '" + key + "' ist '" + map.get(key) + "'</span>";
        } else {
            lastMessage = "<span style='color: red;'>Nicht gefunden: Der Schlüssel '" + key + "' existiert nicht.</span>";
        }
    }

    public void remove(String key) {
        if (map.remove(key) != null) {
            lastMessage = "<span style='color: orange;'>Erfolgreich gelöscht: Schlüssel '" + key + "'</span>";
        } else {
            lastMessage = "<span style='color: red;'>Löschen fehlgeschlagen: Schlüssel '" + key + "' nicht gefunden.</span>";
        }
    }

    public String getTableAsString() {
        StringBuilder sb = new StringBuilder();

        if (!lastMessage.isEmpty()) {
            sb.append(lastMessage).append("<br><br>");
        }

        sb.append("<strong>Gesamter Inhalt der Tabelle:</strong><br>");

        if (map.isEmpty()) {
            sb.append("<em>Die Tabelle ist aktuell leer.</em>");
        } else {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                sb.append("[").append(entry.getKey()).append("] &rarr; ").append(entry.getValue()).append("<br>");
            }
        }

        return sb.toString();
    }
}
