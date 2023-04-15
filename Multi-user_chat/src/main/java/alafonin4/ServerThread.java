package alafonin4;

import java.io.*;
import java.net.Socket;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ServerThread extends Thread {
    private final Logger logger = LoggerFactory.getLogger(ServerThread.class);
    private Socket socket;
    private List<ServerThread> threadList;
    private PrintWriter output;
    public ServerThread(Socket socket, List<ServerThread> threads) {
        this.socket = socket;
        threadList = threads;
    }

    @Override
    public void run() {
        try {
            var input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            boolean isFirst = true;
            while (true) {
                String outputString = input.readLine();
                printToAllClients(outputString);
                if (isFirst) {
                    System.out.println("New client connected");
                    isFirst = false;
                }
            }
        } catch (Exception e) {
            logger.error("Error in serverthread : " + e);
        }
    }

    private void printToAllClients(String outputString) {
        for (var st: threadList) {
            st.output.println(outputString);
        }
    }
}
