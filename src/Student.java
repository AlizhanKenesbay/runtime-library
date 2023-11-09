public class Student extends Person {
    public Student(String name, int id) {
        super(name, id, 14);
    }

    @Override
    public void display() {
        System.out.println("Student: " + name + " | Student ID: " + id);
        super.display();
    }
}