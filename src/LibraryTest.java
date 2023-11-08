public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Leo Tolstoy", "War and Peace", 1);
        Book book2 = new Book("Mike", "Life", 2);
        Book book3 = new Book("Leon Das", "Sweet Store", 3);
        Book book4 = new Book("Ashley Van", "History of Japan", 4);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        Student student1 = new Student("John", 12345);
        Student student2 = new Student("Akka", 332);

        Teacher teacher1 = new Teacher("Mrs. Smith", 1001, "Math");
        Teacher teacher2 = new Teacher("Ms. Johnson", 1002, "History");


        library.lendBook(teacher1, "2018-11-11");
        library.lendBook(teacher1, "2018-11-12");
        library.lendBook(teacher1, "2018-11-15");

        teacher1.display();

        library.acceptBook(teacher1, "2018-12-15");
        library.acceptBook(teacher1, "2018-12-18");
        library.acceptBook(teacher1, "2018-12-20");

        teacher1.display();

        library.lendBook(student1, "2018-11-11");
        library.lendBook(student2, "2018-11-12");
        library.lendBook(teacher1, "2018-11-15");

        library.acceptBook(student1,"2018-11-28");
        library.lendBook(teacher2, "2018-11-30");

        library.acceptBook(teacher1,"2018-12-11");
        library.acceptBook(student2,"2018-12-15");
        library.lendBook(student1, "2018-12-20");

        System.out.println("\nLibrary History:");
        library.viewHistory();
    }
}