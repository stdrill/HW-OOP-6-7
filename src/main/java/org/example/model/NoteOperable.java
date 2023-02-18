package org.example.model;

import java.util.List;

public interface NoteOperable {
    List<String> readAllLines();
    void saveAllLines(List<String> lines);
}
