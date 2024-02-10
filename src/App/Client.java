package App;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int PORT = 12345;

        try (
                Socket socket = new Socket(SERVER_ADDRESS, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            String serverMessage;
            String userInput;
            System.out
                    .println("Bienvenue sur Yahtzee\nchoisir vous commandes selon les valeurs proposeés dans le menu");
            // Lire et afficher le message du serveur
            while ((serverMessage = in.readLine()) != null) {

                System.out.println(serverMessage);

                if (serverMessage.contains("choix")) {
                    userInput = stdIn.readLine();
                    out.println(userInput);
                }
            }

        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + SERVER_ADDRESS);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + SERVER_ADDRESS);
            System.exit(1);
        }
    }
}
