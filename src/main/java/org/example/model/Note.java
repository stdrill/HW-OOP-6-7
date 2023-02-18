package org.example.model;

public class Note {
    private int id;
    private String headingOfTheNote;
    private String textOfTheNote;

    public Note(int id, String headingOfTheNote, String textOfTheNote) {
        this.id = id;
        this.headingOfTheNote = headingOfTheNote;
        this.textOfTheNote = textOfTheNote;
    }

    public int getId() {
        return id;
    }

    public String getHeadingOfTheNote() {
        return headingOfTheNote;
    }

    public String getTextOfTheNote() {
        return textOfTheNote;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeadingOfTheNote(String headingOfTheNote) {
        this.headingOfTheNote = headingOfTheNote;
    }

    public void setTextOfTheNote(String textOfTheNote) {
        this.textOfTheNote = textOfTheNote;
    }

    @Override
    public String toString() {
        return String.format(" Заметка №%s\n **%s**\n %s\n -----------------", getId(), getHeadingOfTheNote(), getTextOfTheNote());
    }
}
