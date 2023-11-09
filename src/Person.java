import java.time.LocalDate;

public class Person {
    String name;
    int id;
    int returnDays;
    Book borrowedBook;
    LocalDate returnDate;

    public Person(String name, int id, int returnDays) {
        this.name = name;
        this.id = id;
        this.returnDays = returnDays;
    }

    public void display() {
        if (borrowedBook != null) {
            System.out.print("Borrowed Book: ");
            borrowedBook.display();
        } else {
            System.out.println("No book borrowed.");
        }
    }
}