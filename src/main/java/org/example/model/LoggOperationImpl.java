package org.example.model;
import java.io.FileWriter;
import java.io.IOException;
public class LoggOperationImpl implements LoggOperation{
    private String fileName;

    public LoggOperationImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void saveLogg(String text) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.append(text);
            writer.append('\n');
            writer.flush();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
