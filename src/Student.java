class Student extends Person {
    public Student(String name, int studentID) {
        super(name, studentID, 14);
    }

    @Override
    void display() {
        System.out.println("Student: " + name + " | Student ID: " + id);
        super.display();
    }
}
