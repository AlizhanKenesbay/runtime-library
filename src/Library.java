import java.time.LocalDate;
import java.util.ArrayList;

public class Library {
    ArrayList<Book> availableBooks = new ArrayList<>();
    ArrayList<LibraryHistory> libraryHistories = new ArrayList<>();

    public void addBook(Book book) {
        availableBooks.add(book);
    }

    public void lendBook(Person person, String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        Book bookToLend = availableBooks.isEmpty() ? null : availableBooks.remove(0);

        if (bookToLend != null) {
            person.borrowedBook = bookToLend;
            LocalDate returnDate = date.plusDays(person.returnDays);
            person.returnDate = returnDate;
            bookToLend.setDueDate(returnDate);
            recordLendingHistory(bookToLend, person, date, returnDate);

            if (person instanceof Teacher teacher) {
                teacher.addBookToTeacher(bookToLend);
            }
        } else {
            System.out.println("No available books to lend.");
        }
    }


    public void acceptBook(Person person, String dateStr) {
        if (person instanceof Teacher teacher) {
            if (!teacher.teacherBooks.isEmpty()) {
                LocalDate date = LocalDate.parse(dateStr);
                Book returnedBook = teacher.teacherBooks.remove(0);
                person.borrowedBook = null;
                recordReturningHistory(returnedBook, person, date);
                availableBooks.add(returnedBook);
            } else {
                System.out.println(person.name + " doesn't have a borrowed book!");
            }
        } else {
            if (person.borrowedBook != null) {
                LocalDate date = LocalDate.parse(dateStr);
                Book returnedBook = person.borrowedBook;
                person.borrowedBook = null;
                recordReturningHistory(returnedBook, person, date);
                availableBooks.add(returnedBook);
            } else {
                System.out.println(person.name + " doesn't have a borrowed book!");
            }
        }
    }

    public void viewHistory() {
        for (LibraryHistory history : libraryHistories) {
            history.displayDetails();
        }
    }

    private void recordLendingHistory(Book book, Person person, LocalDate date, LocalDate returnDate) {
        libraryHistories.add(new LibraryHistory(book, person, true, date, returnDate));
    }

    private void recordReturningHistory(Book book, Person person, LocalDate date) {
        LocalDate dueDate = book.getDueDate();
        LibraryHistory history = new LibraryHistory(book, person, false, date, dueDate);
        history.calculateFine(date);
        libraryHistories.add(history);
    }
}