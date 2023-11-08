import java.time.LocalDate;

class Book {
    String author;
    String title;
    int id;
    LocalDate dueDate;

    public Book(String author, String title, int id) {
        this.author = author;
        this.title = title;
        this.id = id;
    }

    void display() {
        System.out.println("ID: " + id + " | Book: '" + title + "' by Author: '" + author + "'");
    }

    void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    LocalDate getDueDate() {
        return dueDate;
    }
}
