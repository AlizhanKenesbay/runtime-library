import java.time.LocalDate;

public class LibraryHistory {
    Book book;
    Person person;
    boolean isBorrowed;
    LocalDate date;
    LocalDate dueDate;
    int fine;

    public LibraryHistory(Book book, Person person, boolean isBorrowed, LocalDate date, LocalDate dueDate) {
        this.book = book;
        this.person = person;
        this.isBorrowed = isBorrowed;
        this.date = date;
        this.dueDate = dueDate;
        fine = 0;
    }

    public void displayDetails() {
        String action = isBorrowed ? "borrowed" : "returned";
        System.out.println(date + ": " + person.name + " " + action + " the book '" + book.title + "'");
        if (isBorrowed) {
            System.out.println("Due Date: " + dueDate);
        } else {
            System.out.println("Fine: " + fine + "тг");
        }
    }

    public void calculateFine(LocalDate returnDate) {
        if (returnDate.isAfter(dueDate)) {
            long daysOverdue = dueDate.until(returnDate).getDays();
            fine = (int) (daysOverdue * 100);
        }
    }
}