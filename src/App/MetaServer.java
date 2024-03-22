package App;

import java.io.*;
import java.net.*;
import Jeu.*;
import java.util.ArrayList;

public class MetaServer {
    private ArrayList<Table> tables = new ArrayList<>();
    private Table table1 = new Table("table1", 10);
    private Table table2 = new Table("table2",20);
    private Table table3 = new Table("table3",30);
    
    public ArrayList<Table> getTables(){
        return this.tables;
    }

    public static void main(String[] args) {
        final int PORT = 12345;
        MetaServer metaServer = new MetaServer();
        metaServer.table1.setTType("P");
        metaServer.table2.setTType("P");
        metaServer.table3.setTType("P");

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("MetaServer is running...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);
                int i =1;
                String name = "Joueur"+i;
                Joueur joueur = new Joueur(name);

                // Créer un nouveau thread pour gérer le client
                ClientHandler clientHandler = new ClientHandler(clientSocket, metaServer, joueur);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private MetaServer metaServer;
    private Joueur joueur;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket, MetaServer metaServer, Joueur joueur) {
        this.clientSocket = socket;
        this.metaServer = metaServer;
        this.joueur = joueur;
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @Override
    public void run() {
        try {
            out.println("Liste des table");
            for(Table T : metaServer.getTables()){
                out.println(T.getNom()+ " :" + T.getnbrjoueurs()+" Joueurs");
            }
            out.println("Choisir dans le menu entre joindre une table ou Créer une nouvelle table");
            out.println("1 : Joindre une table");
            out.println("2 : créer une table");
            out.println("choix : ");
            int choix = Integer.parseInt(in.readLine());
            if(choix == 1){
                out.println("Entrer le nom de la table à joindre : ");
                out.println("choix : ");
                String nomtable = in.readLine();
                for(Table T : metaServer.getTables()){
                    if(T.getNom().equals(nomtable)){
                        joueur.JoindreTable(T);
                        out.println("Vous viendrez de joindre la table"+ T.getNom());
                        out.println("Connexion à la table " + T.getNom());
                        T.LancerJeu();
                        Socket tableSocket = new Socket("localhost", T.getPort());
                        transferData(clientSocket.getInputStream(), tableSocket.getOutputStream());
                        transferData(tableSocket.getInputStream(), clientSocket.getOutputStream());
                        tableSocket.close();
                        //T.LancerJeu();
                    }
                }

            }
            else if(choix == 2){
                //joueur.creerTable("Table de"+joueur.getNom());
                out.println("Vous viendrez de créer et joindre la table"+ joueur.getTable());
                joueur.getTable().LancerJeu();
            }

            

        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void transferData(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
    }
}
