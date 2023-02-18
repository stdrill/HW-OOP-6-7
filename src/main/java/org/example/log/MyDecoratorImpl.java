package org.example.log;

public class MyDecoratorImpl implements MyDecorator{
    private Loggerable logger;

    public MyDecoratorImpl(String nameFile) {
        logger = new LoggerToFile(nameFile);
    }

    @Override
    public void readAllNotes() {
        logger.logg(String.format("Read list notes"));

    }

    @Override
    public void changeNote(String note) {
        logger.logg(String.format("Change note %s", note));

    }

    @Override
    public void deleteNote(String note) {
        logger.logg(String.format("Delete note %s", note));

    }

    @Override
    public void createNote(String note) {
        logger.logg(String.format("Create note %s", note));
    }
}
