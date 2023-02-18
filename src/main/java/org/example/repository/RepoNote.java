package org.example.repository;

import org.example.model.Note;

import java.util.List;
public interface RepoNote {
    List<Note> getAllNotes();
    void allChangeNote(List<Note> list);
}
