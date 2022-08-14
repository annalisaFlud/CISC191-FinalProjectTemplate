package edu.sdccd.cisc191.template;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StudentRequest {
    private String firstName;

    @JsonIgnore
    //serialization methods for requesting a student
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static String toJSON(StudentRequest customer) throws Exception {
        return objectMapper.writeValueAsString(customer);

    }
    public static StudentRequest fromJSON(String input) throws Exception{
        return objectMapper.readValue(input, StudentRequest.class);
    }
    protected StudentRequest() {}

    public StudentRequest(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return String.format(
                "Student[firstName=%s]",
                this.firstName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}