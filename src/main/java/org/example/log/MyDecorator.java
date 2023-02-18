package org.example.log;

public interface MyDecorator {
    public void changeNote(String note);
    public void createNote(String note);
    public void deleteNote (String note);
    public void readAllNotes ();
}
