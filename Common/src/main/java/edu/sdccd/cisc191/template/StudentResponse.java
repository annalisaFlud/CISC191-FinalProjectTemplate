package edu.sdccd.cisc191.template;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentResponse {
    private String studentName;
    private int gradeLevel;
    private String homeAddress;
    private String phoneNumber;

    @JsonIgnore
    //serialization methods for responding to a request
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJSON(StudentResponse customer) throws Exception {
        return objectMapper.writeValueAsString(customer);
    }
    public static StudentResponse fromJSON(String input) throws Exception{
        return objectMapper.readValue(input, StudentResponse.class);
    }
    protected StudentResponse() {}

    public StudentResponse (String studentName, int gradeLevel, String homeAddress, String phoneNumber){
        this.studentName = studentName;
        this.gradeLevel = gradeLevel;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format(
                //information stored in database
                "Customer[studentName='%s', gradeLevel='%s', homeAddress='%s',phoneNumber='%s']",
                studentName, gradeLevel, homeAddress, phoneNumber);
    }

    //methods for accessing fields
    public String getStudentName() {
        return this.studentName;
    }
    public int getGradeLevel(){ return this.gradeLevel; }
    public String getHomeAddress(){ return this.homeAddress; }
    public String getPhoneNumber() { return this.phoneNumber; }
}