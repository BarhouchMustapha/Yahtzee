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
            do {
                out.println("1 : Lancer les des");
                out.println("2 : Exit");
                out.println("choix : ");

                int choix = Integer.parseInt(in.readLine());
                if (choix == 1) {
                    tour.lancer();
                    for (De d : tour.getLance().getDes())
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

                if (tour.getFigDispo().isEmpty()) {
                    tour.listeNPrise(berlan);
                    tour.listeNPrise(carre);
                    tour.listeNPrise(chance);
                    tour.listeNPrise(full);
                    tour.listeNPrise(Gsuite);
                    tour.listeNPrise(Psuite);
                    tour.listeNPrise(yahtzee);
                    tour.listeNPrise(as);
                    tour.listeNPrise(deux);
                    tour.listeNPrise(trois);
                    tour.listeNPrise(quatres);
                    tour.listeNPrise(cinques);
                    tour.listeNPrise(six);
                    out.println(tour.getFigNPrise());
                    out.println("Veuillez choisir une figure à barrer parmi les figures présentes dans cette liste .");
                    out.println("choix : ");
                    String choixbar = in.readLine();
                    switch (choixbar.toLowerCase()) {
                        case "berlan":
                            if (tour.barreFigure(berlan)) {
                                out.println("La Figure BERLAN a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "carre":
                            if (tour.barreFigure(carre)) {
                                out.println("La Figure CARRE a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "chance":
                            if (tour.barreFigure(chance)) {
                                out.println("La Figure CHANCE a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "full":
                            if (tour.barreFigure(full)) {
                                out.println("La Figure FULL a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "grandesuite":
                            if (tour.barreFigure(Gsuite)) {
                                out.println("La Figure GRANDE SUITE a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "petitesuite":
                            if (tour.barreFigure(Psuite)) {
                                out.println("La Figure PETITE SUITE a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "yahtzee":
                            if (tour.barreFigure(yahtzee)) {
                                out.println("La Figure YAHTZEE a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "1":
                            if (tour.barreFigure(as)) {
                                out.println("La Figure AS a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "2":
                            if (tour.barreFigure(deux)) {
                                out.println("La Figure DEUX a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "3":
                            if (tour.barreFigure(trois)) {
                                out.println("La Figure TROIS a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "4":
                            if (tour.barreFigure(quatres)) {
                                out.println("La Figure QUATRES a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "5":
                            if (tour.barreFigure(cinques)) {
                                out.println("La Figure CINQUES a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "6":
                            if (tour.barreFigure(six)) {
                                out.println("La Figure SIX a été barré avec succés");
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;
                        default:
                            out.println("il faut saisir une figure présente dans la liste");
                            System.exit(0);
                            break;
                    }
                    tour.clearFigNPrise();
                }

                else {

                    out.println(tour.getFigDispo());
                    tour.clearFigDispo();
                    out.println("Veuillez choisir une figure parmi les figures présentes dans cette liste ...");
                    out.println("choix : ");
                    String choixFig = in.readLine();
                    switch (choixFig.toLowerCase()) {
                        case "berlan":
                            if (tour.choisirFigure(berlan)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemaj(berlan, tour.getscoreTour());
                                tour.setscoreTour();
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "carre":
                            if (tour.choisirFigure(carre)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemaj(carre, tour.getscoreTour());
                                tour.setscoreTour();
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "chance":
                            if (tour.choisirFigure(chance)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemaj(chance, tour.getscoreTour());
                                tour.setscoreTour();
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "full":
                            if (tour.choisirFigure(full)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemaj(full, tour.getscoreTour());
                                tour.setscoreTour();
                            }

                            else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "grandesuite":
                            if (tour.choisirFigure(Gsuite)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemaj(Gsuite, tour.getscoreTour());
                                tour.setscoreTour();
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "petitesuite":
                            if (tour.choisirFigure(Psuite)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemaj(Psuite, tour.getscoreTour());
                                tour.setscoreTour();
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "yahtzee":
                            if (tour.choisirFigure(yahtzee)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemaj(yahtzee, tour.getscoreTour());
                                tour.setscoreTour();
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "1":
                            if (tour.choisirFigure(as)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemin(as, tour.getscoreTour());
                                tour.setscoreTour();
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "2":
                            if (tour.choisirFigure(deux)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemin(deux, tour.getscoreTour());
                                tour.setscoreTour();
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "3":
                            if (tour.choisirFigure(trois)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemin(trois, tour.getscoreTour());
                                tour.setscoreTour();
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "4":
                            if (tour.choisirFigure(quatres)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemin(quatres, tour.getscoreTour());
                                tour.setscoreTour();
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "5":
                            if (tour.choisirFigure(cinques)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemin(cinques, tour.getscoreTour());
                                tour.setscoreTour();
                            }

                            else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;

                        case "6":
                            if (tour.choisirFigure(six)) {
                                out.println("Choix vérfié, points:" + tour.getscoreTour());
                                tour.remplirTablemin(six, tour.getscoreTour());
                                tour.setscoreTour();
                            } else {
                                out.println("il faut saisir une figure présente dans la liste");
                                System.exit(0);
                            }
                            break;
                        default:
                            out.println("il faut saisir une figure présente dans la liste");
                            System.exit(0);
                            break;
                    }
                }
            } while (tour.getnumTour() < 13);

            tour.getTableAffichage().claculerTotals();
            tour.getTableAffichage().ajouterBonus();
            out.println(tour.getTableAffichage().affTable());

            // Fermer la connexion
            clientSocket.close();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
