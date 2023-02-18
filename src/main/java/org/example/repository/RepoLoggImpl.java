package org.example.repository;
import org.example.log.MyDecorator;
public class RepoLoggImpl implements RepoLogg{
    private MyDecorator myDecorator;


    public RepoLoggImpl(MyDecorator myDecorator) {
        this.myDecorator = myDecorator;
    }

    @Override
    public void changeNote(String note) {
        myDecorator.changeNote(note);
    }

    @Override
    public void deleteNote(String note) {
        myDecorator.deleteNote(note);
    }

    @Override
    public void readAllNotes() {
        myDecorator.readAllNotes();
    }

    @Override
    public void createNote(String note) {
        myDecorator.createNote(note);
    }
}
