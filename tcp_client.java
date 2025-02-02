import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
        String sentence;
        String modifiedSentence;
        String serverIP = "YOUR_IP_ADDRESS"; // Server IP address,
        int serverPort = 5000; // Server port , it can be change

        try (BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
             Socket clientSocket = new Socket(serverIP, serverPort);
             DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
             BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.print("Enter a sentence: ");
            sentence = inFromUser.readLine();

            outToServer.writeBytes(sentence + "\n");
            modifiedSentence = inFromServer.readLine(); // We wait answer from server
            System.out.println("FROM SERVER: " + modifiedSentence);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
