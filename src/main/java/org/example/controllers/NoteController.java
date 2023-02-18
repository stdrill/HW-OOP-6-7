package org.example.controllers;


import org.example.model.Note;
import org.example.repository.RepoLogg;
import org.example.repository.RepoNote;
import java.util.List;


public class NoteController {

    private final RepoNote repoNote;
    private final RepoLogg repoLogg;

    public NoteController(RepoNote repoNote, RepoLogg repoLogg) {
        this.repoNote = repoNote;
        this.repoLogg = repoLogg;
    }

    public List<Note> listNotes() {
        repoLogg.readAllNotes();
        return repoNote.getAllNotes();
    }

    public void createNewNote(String heading, String text) {
        List<Note> list = repoNote.getAllNotes();
        int id = 1;
        for (Note note : list) {
            id = note.getId() + 1;
        }
        list.add(new Note(id, heading, text));
        repoNote.allChangeNote(list);
        repoLogg.createNote(heading);
    }

    public void changeHeadingNote(int id, String newHeading) {
        List<Note> list = listNotes();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.get(i).setHeadingOfTheNote(newHeading);
            }
        }
        repoNote.allChangeNote(list);
        repoLogg.changeNote(Integer.toString(id));
    }

    public void changeTextNote(int id, String newText) {
        List<Note> list = listNotes();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.get(i).setTextOfTheNote(newText);
            }
        }
        repoNote.allChangeNote(list);
        repoLogg.changeNote(Integer.toString(id));
    }

    public boolean checkNoteOnId(int id) {
        List<Note> list = listNotes();
        for (Note note : list) {
            if (note.getId() == id)
                return true;
        }
        return false;
    }

    public void deleteNote(int id) {
        repoLogg.deleteNote(Integer.toString(id));
        List<Note> list = listNotes();
        int defaultId = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setId(defaultId++);
        }

        repoNote.allChangeNote(list);
    }
}
