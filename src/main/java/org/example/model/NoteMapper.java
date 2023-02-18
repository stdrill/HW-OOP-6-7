package org.example.model;

public class NoteMapper implements Mapper{
    @Override
    public String mapToString(Note note) {
        return String.format("%s|%s|%s", note.getId(), note.getHeadingOfTheNote(), note.getTextOfTheNote());
    }

    @Override
    public Note mapToNote(String line) {
        String[] lines = line.split("\\|");
        return new Note(Integer.parseInt(lines[0]), lines[1], lines[2]);
    }
}
