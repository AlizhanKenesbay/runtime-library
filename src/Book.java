import java.time.LocalDate;

public class Book {
    String author;
    String title;
    int id;
    LocalDate dueDate;

    public Book(String author, String title, int id) {
        this.author = author;
        this.title = title;
        this.id = id;
    }

    public void display() {
        System.out.println("ID: " + id + " | Book: '" + title + "' by Author: '" + author + "'");
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }
}