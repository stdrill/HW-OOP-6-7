package org.example.model;

public interface Mapper {
    public String mapToString(Note note);
    public Note mapToNote(String line);
}
