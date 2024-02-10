package App;
import java.io.*;
import java.net.*;
import Figures.*;
import Jeu.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);

                // Créer un nouveau thread pour gérer le client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    Tour tour = new Tour();
    Figure berlan = new Figure("berlan");
    Figure carre = new Figure("carre");
    Figure chance = new Figure("chance");
    Figure full = new Figure("full");
    Figure Gsuite = new Figure("grande suite");
    Figure Psuite= new Figure("petite suite");
    Figure yahtzee = new Figure("yahtzee");
    FigureMineur as = new FigureMineur("as",1);
    FigureMineur deux = new FigureMineur("deux",2);
    FigureMineur trois = new FigureMineur("trois",3);
    FigureMineur quatres = new FigureMineur("quatres",4);
    FigureMineur cinques = new FigureMineur("cinques",5);
    FigureMineur six = new FigureMineur("six",6);


    

    @Override
    public void run() {
        try {
           
            out.println(" 1 : Lancer les des");
            out.println("2 : Exit");
            out.println("menu");

            int choix = Integer.parseInt(in.readLine());
            if(choix == 1){
                this.tour.lancer();
                for(De d : this.tour.getLance().getDes())
                out.print(d.getValeur()+" ");
            }
            else{
                clientSocket.close();
            }
            out.println("\nChoisir parmi les figures disponible : ");
            tour.figureMajDisponible(berlan);
            tour.figureMajDisponible(carre);
            tour.figureMajDisponible(chance);
            tour.figureMajDisponible(full);
            tour.figureMajDisponible(Gsuite);
            tour.figureMajDisponible(Psuite);
            tour.figureMajDisponible(yahtzee);

            tour.figureMinDisponible(as);
            tour.figureMinDisponible(deux);
            tour.figureMinDisponible(trois);
            tour.figureMinDisponible(quatres);
            tour.figureMinDisponible(cinques);
            tour.figureMinDisponible(six);
            out.println(tour.getFigDispo());




            // Peut ajouter plus de logique ici...
            
            // Fermer la connexion
            //clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
