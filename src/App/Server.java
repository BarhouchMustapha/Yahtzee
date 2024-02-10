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
    Figure Gsuite = new Figure("grandesuite");
    Figure Psuite = new Figure("petitesuite");
    Figure yahtzee = new Figure("yahtzee");
    FigureMineur as = new FigureMineur("as", 1);
    FigureMineur deux = new FigureMineur("deux", 2);
    FigureMineur trois = new FigureMineur("trois", 3);
    FigureMineur quatres = new FigureMineur("quatres", 4);
    FigureMineur cinques = new FigureMineur("cinques", 5);
    FigureMineur six = new FigureMineur("six", 6);

    @Override
    public void run() {
        try {

            out.println("1 : Lancer les des");
            out.println("2 : Exit");
            out.println("choix : ");

            int choix = Integer.parseInt(in.readLine());
            if (choix == 1) {
                this.tour.lancer();
                for (De d : this.tour.getLance().getDes())
                    out.print(d.getValeur() + " ");
            } else {
                clientSocket.close();
            }
            out.println("\nChoisir parmi les figures disponible : ");
            tour.listeDispo(berlan);
            tour.listeDispo(carre);
            tour.listeDispo(chance);
            tour.listeDispo(full);
            tour.listeDispo(Gsuite);
            tour.listeDispo(Psuite);
            tour.listeDispo(yahtzee);

            tour.listeDispo(as);
            tour.listeDispo(deux);
            tour.listeDispo(trois);
            tour.listeDispo(quatres);
            tour.listeDispo(cinques);
            tour.listeDispo(six);
            out.println(tour.getFigDispo());

            out.println("Veuillez choisir une figure parmi les figures présentes dans cette liste ...");
            out.println("choix : ");

            
            
            
            String choixFig = in.readLine();
            switch (choixFig.toLowerCase()) {
            case "berlan":
                if (tour.choisirFigure(berlan)){
                    out.println("Choix vérfié");
                }
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                break;

            case "carre":
                if (tour.choisirFigure(carre)){
                    out.println("Choix vérfié");
                }
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                break;

            case "chance":
                if (tour.choisirFigure(chance)){
                    out.println("Choix vérfié");
                }
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                break;
            
            case "full":
                if (tour.choisirFigure(full)){
                    out.println("Choix vérfié");
                }
                
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                break;
            
            case "grandesuite":
                if (tour.choisirFigure(Gsuite)){
                    out.println("Choix vérfié");
                }
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                break;
            
            case "petitesuite":
                if (tour.choisirFigure(Psuite)){
                    out.println("Choix vérfié");
                }
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                break;
            
            case "yahtzee":
                if (tour.choisirFigure(yahtzee)){
                    out.println("Choix vérfié");
                }
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                    break; 
            
            case "1":
                if (tour.choisirFigure(as)){
                    out.println("Choix vérfié");
                }
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                    break;
    
            case "2":
                if (tour.choisirFigure(deux)){
                    out.println("Choix vérfié");
                }
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                break;
    
            case "3":
                if (tour.choisirFigure(trois)){
                    out.println("Choix vérfié");
                }
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                break;
                
            case "4":
                if (tour.choisirFigure(quatres)){
                    out.println("Choix vérfié");
                }
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                break;
                
            case "5":
                if (tour.choisirFigure(cinques)){
                    out.println("Choix vérfié");
                }
                
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
                break;
                    
            case "6":
                if (tour.choisirFigure(six)){
                    out.println("Choix vérfié");
                }
                else{
                    out.println("Veuillez saisir une figure présente dans la liste");
                    out.println("choix : ");
                }
            default:
                out.println("Veuillez saisir une figure de la liste");
                out.println("choix : ");
                break;
            }


           
            
            out.println(tour.getTableAffichage().affTable());
            
        }




            // Peut ajouter plus de logique ici...

            // Fermer la connexion
            // clientSocket.close();
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
