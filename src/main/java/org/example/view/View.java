package org.example.view;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import org.example.controllers.NoteController;
import org.example.model.Note;
public class View {
    private NoteController myController;
    Scanner sc;

    public View(NoteController controller) {
        this.myController = controller;
    }

    public void run() {
        while (true) {
            int command = menu();
            if (command == 5) {
                sc.close();
                break;
            }
            switch (command) {
                case 1:
                    showListNotes();
                    break;
                case 2:
                    createNewNote();
                    break;
                case 3:
                    changeNote();
                    break;
                case 4:
                    deleteNote();
                    break;
                default:
                    break;
            }
        }
    }

    private void deleteNote() {
        int idNote = scannerInt("Введите номер заметки: ");
        if (myController.checkNoteOnId(idNote)) {
            myController.deleteNote(idNote);
            System.out.printf("Заметка №%d удалена.\n", idNote);
        } else {
            System.out.printf("Заметка под номером %d не найдена.\n", idNote);
        }
    }

    private void changeNote() {
        int idNote = scannerInt("Введите номер заметки: ");
        if (myController.checkNoteOnId(idNote)) {

            while (true) {
                int command = scannerInt(
                        "Введите команду: ИЗМЕНИТЬ ЗАГОЛОВОК - 1, ИЗМЕНИТЬ ТЕКСТ ЗАМЕТКИ - 2, ВЫЙТИ ИЗ РЕДАКТИРОВАНИЯ - 3");

                if (command == 3)
                    break;
                switch (command) {
                    case 1:
                        String newHeading = scannerString("Введите новый заголовок: ");
                        if (!checkString(newHeading)) {
                            varningStringNull();
                            continue;
                        }
                        myController.changeHeadingNote(idNote, newHeading);
                        System.out.println("Заголовок успешно изменен!");
                        break;
                    case 2:
                        String newText = scannerString("Введите новый текст заметки: ");
                        if (!checkString(newText)) {
                            varningStringNull();
                            continue;
                        }
                        myController.changeTextNote(idNote, newText);
                        System.out.println("Текст заметки успешно изменен!");
                        break;
                    default:
                        break;
                }
            }
        } else {
            System.out.printf("Заметка под номером %d не найдена.\n", idNote);
        }
    }

    private void createNewNote() {
        String heading = "";
        String text = "";
        while (true) {
            heading = scannerString("Введите заголовок: ");
            if (!checkString(heading)) {
                varningStringNull();
                continue;
            }
            break;
        }
        while (true) {
            text = scannerString("Введите тект заметки: ");
            if (!checkString(text)) {
                varningStringNull();
                continue;
            }
            break;
        }
        myController.createNewNote(heading, text);
        System.out.printf("Заметка %s сохранена\n", heading);
    }

    private void varningStringNull() {
        System.out.println("Заголовок/текст заметки не может быть пустым!");
    }

    private int menu() {
        try {
            int data = scannerInt(
                    "Введите команду: СПИСОК ЗАМЕТОК - 1, СОЗДАТЬ ЗАМЕТКУ - 2, РЕДАКТИРОВАТЬ ЗАМЕТКУ - 3, УДАЛИТЬ ЗАМЕТКУ - 4, ВЫХОД - 5");
            return data;
        } catch (InputMismatchException е) {
            System.out.println("Неверная команда, введите число.");
        }
        return 0;
    }

    private void showListNotes() {
        List<Note> list = myController.listNotes();
        if (list.size() == 0) {
            System.out.println("Список заметок пуст! Создайте заметку.");
        } else {
            for (Note note : list) {
                System.out.println(note);
            }
        }
    }

    private String scannerString(String message) {
        sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    private int scannerInt(String message) {
        sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextInt();
    }

    private boolean checkString(String string) {
        if (string.equals("") || string.equals(" "))
            return false;
        return true;
    }
}
