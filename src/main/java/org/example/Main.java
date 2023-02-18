package org.example;

import org.example.controllers.NoteController;
import org.example.log.MyDecorator;
import org.example.log.MyDecoratorImpl;
import org.example.model.NoteOperable;
import org.example.model.NoteOperationImpl;
import org.example.repository.RepoLogg;
import org.example.repository.RepoLoggImpl;
import org.example.repository.RepoNote;
import org.example.repository.RepoNoteImpl;
import org.example.view.View;

public class Main {
    public static void main(String[] args) {
        NoteOperable fileOperation = new NoteOperationImpl("note.txt");
        MyDecorator myDecorator = new MyDecoratorImpl("logg.txt");
        RepoNote repoNote = new RepoNoteImpl(fileOperation);
        RepoLogg repoLogg = new RepoLoggImpl(myDecorator);
        NoteController controller = new NoteController(repoNote, repoLogg);
        View view = new View(controller);
        view.run();
    }
}