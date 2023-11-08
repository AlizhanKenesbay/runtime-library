import java.util.ArrayList;

class Teacher extends Person {
    String subject;
    ArrayList<Book> teacherBooks = new ArrayList<>();

    public Teacher(String name, int id, String subject) {
        super(name, id, 30);
        this.subject = subject;
    }

    void addBookToTeacher(Book book) {
        teacherBooks.add(book);
    }

    @Override
    void display() {
        System.out.println("Teacher: " + name + " | ID: " + id + " | Subject: " + subject);
        super.display();
        System.out.println("Teacher's Books:");
        for (Book book : teacherBooks) {
            book.display();
        }
    }
}
