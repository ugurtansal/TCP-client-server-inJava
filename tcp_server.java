import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        int port = 5000;//Port number can be changed , but must be same client port number

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("TCP Server is running on port " + port);

            while (true) {
                Socket connectionSocket = serverSocket.accept(); 
                System.out.println("Client connected: " + connectionSocket.getInetAddress());

                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

                String clientSentence = inFromClient.readLine(); // İstemciden mesaj al
                System.out.println("Received: " + clientSentence);

                String modifiedSentence = clientSentence.toUpperCase() + "\n"; 
                outToClient.writeBytes(modifiedSentence); //Returne client message but with uppercase

                connectionSocket.close(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
