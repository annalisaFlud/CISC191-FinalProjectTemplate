package edu.sdccd.cisc191.template;

public class Student {


    private String studentName;
    private int gradeLevel;
    private String homeAddress;
    private String phoneNumber;

    public Student(){}

    //class Student constructor
    public Student (String studentName, int gradeLevel, String homeAddress, String phoneNumber){
        this.studentName = studentName;
        this.gradeLevel = gradeLevel;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
    }

    //returns fields as strings for database
    @Override
    public String toString() {
        return String.format(
                "Student[studentName='%s', gradeLevel='%d', homeAddress='%s', phoneNumber='%s']",
                studentName, gradeLevel, homeAddress, phoneNumber);
    }

    //methods accessing fields- student name, grade level, home address, phone number
    public String getStudentName() {
        return this.studentName;
    }
    public int getGradeLevel(){ return this.gradeLevel; }
    public String getHomeAddress(){ return this.homeAddress; }
    public String getPhoneNumber() { return this.phoneNumber; }
}
