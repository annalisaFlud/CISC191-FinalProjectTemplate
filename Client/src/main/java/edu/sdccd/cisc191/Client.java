package edu.sdccd.cisc191;

import edu.sdccd.cisc191.template.StudentRequest;
import edu.sdccd.cisc191.template.StudentResponse;
import edu.sdccd.cisc191.template.StudentUploadRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    //starts connection
    public void startConnection(String ip, int port) throws IOException {
        //crates socket for connection, and input and output streams
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    //sends a request to find a student
    public StudentResponse sendRequest(String studentName) throws Exception {
        out.println(StudentRequest.toJSON(new StudentRequest(studentName)));
        return StudentResponse.fromJSON(in.readLine());
    }

    //sends request to add student
    public StudentResponse sendUploadRequest(StudentUploadRequest uploadRequest) throws Exception {
        out.println(StudentUploadRequest.toJSON(uploadRequest));
        return StudentResponse.fromJSON(in.readLine());
    }

    //stops connection
    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}
