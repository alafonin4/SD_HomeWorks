package alafonin4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 8080);
        var input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        var scanner = new Scanner(System.in)) {
            var output = new PrintWriter(socket.getOutputStream(), true);
            ClientThread clientThread = new ClientThread(socket);
            clientThread.start();
            String userInput, clientName = null, password;
            while (true) {
                if (clientName == null) {
                    System.out.print("Enter your username: ");
                    clientName = scanner.nextLine();
                    output.println(clientName + " joined the chat");
                } else {
                    //System.out.print(clientName + ": ");
                    userInput = scanner.nextLine();
                    output.println(clientName + ": " + userInput);
                }
            }
        } catch (Exception e) {
            System.out.println("Error in client main" + e);
        }
    }
}
