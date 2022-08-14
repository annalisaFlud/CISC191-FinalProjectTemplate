package edu.sdccd.cisc191.template;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
public class StudentUploadRequest {
    private String studentName;
    private int gradeLevel;
    private String homeAddress;
    private String phoneNumber;

    @JsonIgnore
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJSON(StudentUploadRequest customer) throws Exception {
        return objectMapper.writeValueAsString(customer);
    }
    public static StudentUploadRequest fromJSON(String input) throws Exception{
        return objectMapper.readValue(input, StudentUploadRequest.class);
    }
    protected StudentUploadRequest() {}

    public StudentUploadRequest (String studentName, int gradeLevel, String homeAddress, String phoneNumber){
        this.studentName = studentName;
        this.gradeLevel = gradeLevel;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[studentName='%s', gradeLevel='%s', homeAddress='%s',phoneNumber='%s']",
                studentName, gradeLevel, homeAddress, phoneNumber);
    }

    public String getStudentName() {
        return this.studentName;
    }
    public int getGradeLevel(){ return this.gradeLevel; }
    public String getHomeAddress(){ return this.homeAddress; }
    public String getPhoneNumber() { return this.phoneNumber; }
}
