package edu.sdccd.cisc191.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


//Server class
public class Server {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private StudentWarehouse warehouse;

    public void start(int port) throws Exception {
        this.warehouse = new StudentWarehouse();
        serverSocket = new ServerSocket(port);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String inputLine;
        while (true) {
            while ((inputLine = in.readLine()) != null) {
                try {
                    //if searching for student in warehouse
                    StudentRequest request = StudentRequest.fromJSON(inputLine);System.out.println( request.toString());
                    Student foundStudent = this.warehouse.findStudentByName(request.getFirstName());
                    StudentResponse response = new StudentResponse(foundStudent.getStudentName(), foundStudent.getGradeLevel(), foundStudent.getHomeAddress(), foundStudent.getPhoneNumber());
                    out.println(StudentResponse.toJSON(response));
                } catch (Exception e) {
                    //if uploading student to warehouse
                    StudentUploadRequest request = StudentUploadRequest.fromJSON(inputLine);
                    System.out.println( request.toString());
                    this.warehouse.insertStudent(new Student(request.getStudentName(), request.getGradeLevel(), request.getHomeAddress(), request.getPhoneNumber()));
                    StudentResponse response = new StudentResponse(request.getStudentName(), request.getGradeLevel(), request.getHomeAddress(), request.getPhoneNumber());
                    out.println(StudentResponse.toJSON(response));
                }

            }
        }
    }
    //stops server

    public void stop() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
        serverSocket.close();
    }
    //starts server

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.start(4444);
            server.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}