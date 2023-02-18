package org.example.repository;

import org.example.model.Mapper;
import org.example.model.Note;
import org.example.model.NoteOperable;

import java.util.ArrayList;
import java.util.List;


public class RepoNoteImpl implements RepoNote{
    private Mapper mapper;
    private NoteOperable noteOperable;

    public RepoNoteImpl(NoteOperable noteOperable) {
        this.noteOperable = noteOperable;
        mapper = new Mapper() {
            @Override
            public String mapToString(Note note) {
                return null;
            }

            @Override
            public Note mapToNote(String line) {
                return null;
            }
        };
    }

    @Override
    public List<Note> getAllNotes() {
        List<Note> listNotes = new ArrayList<>();
        List<String> listStrings = noteOperable.readAllLines();
        for (String string : listStrings) {
            listNotes.add(mapper.mapToNote(string));
        }
        return listNotes;
    }

    @Override
    public void allChangeNote(List<Note> list) {
        List<String> listString = new ArrayList<>();
        for (Note note : list) {
            listString.add(mapper.mapToString(note));
        }
        noteOperable.saveAllLines(listString);
    }
}
