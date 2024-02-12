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
            System.out.println("Bienvenue sur Yahtzee");
            System.out.println("---------Consignes pour avoir une meilleur performance de jeu----------");
            System.out.println("Il faut toujours entrer des entrées Valides selon les valeurs proposé dans le menu");
            System.out.println(
                    "Pour choisir les Figures Grande suite et Petite Suite il faut entrer 'grandesuite' ou 'petite suite' ");
            System.out.println(
                    "Pour le choix des autres figurs majeurs il faut juste écrire son nom {berlan ,carre ,full ,chance ,yahtzee}");
            System.out.println("Pour le choix des autres figurs mineurs il faut entrer la valeur de dé");
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("choisir vous commandes selon les valeurs proposeés dans le menu");
            // Lire et afficher le message du serveur
            while ((serverMessage = in.readLine()) != null) {

                System.out.println(serverMessage);

                if (serverMessage.contains("choix")) {
                    userInput = stdIn.readLine();
                    out.println(userInput);
                }
            }

        } catch (UnknownHostException e) {
            System.err.println("Connection impossible à :  " + SERVER_ADDRESS);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Connection impossible à: " + SERVER_ADDRESS);
            System.exit(1);
        }
    }
}
