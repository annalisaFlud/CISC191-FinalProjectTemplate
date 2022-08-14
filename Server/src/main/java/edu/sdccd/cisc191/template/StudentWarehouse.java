package edu.sdccd.cisc191.template;

import java.util.ArrayList;

public class StudentWarehouse {
    private ArrayList<Student> students;

    public StudentWarehouse() {
        //adds a few students
        this.students = new ArrayList<Student>();
        Student student1 = new Student("Andy", 3, "12222 margarit lane", "312-697-7878");
        Student student2 = new Student("Essie", 3, "48392075 williams drive", "312-890-5768");
        Student student3 = new Student("Isa", 5, "91189 oliver drive", "210-678-9876");
        Student student4 = new Student("jane", 5, "1234 old st", "123123");

        this.students.add(student1);
        this.students.add(student2);
        this.students.add(student3);
        this.students.add(student4);
    }

    //searches for student by first name
    public Student findStudentByName(String firstName) {
        for (Student student : this.students) {
            if (student.getStudentName().equalsIgnoreCase(firstName)) {
                return student;
            }
        }
        return new Student();
    }

    //adds student to warehouse
    public void insertStudent(Student student) {
        this.students.add(student);
    }



}
