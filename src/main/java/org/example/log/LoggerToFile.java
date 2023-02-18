package org.example.log;

import org.example.model.LoggOperation;
import org.example.model.LoggOperationImpl;

import java.time.LocalDateTime;

public class LoggerToFile implements Loggerable{
    private LoggOperation loggOperation;

    public LoggerToFile(String fileNameForLogg) {
        loggOperation = new LoggOperationImpl(fileNameForLogg);
    }

    @Override
    public void logg(String text) {
        loggOperation.saveLogg(LocalDateTime.now() + ": " + text);
    }
}
