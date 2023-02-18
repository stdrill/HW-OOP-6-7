package org.example.repository;

public interface RepoLogg {
    public void changeNote(String note);
    public void deleteNote (String note);
    public void readAllNotes ();
    public void createNote(String note);
}
