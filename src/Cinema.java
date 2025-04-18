import java.util.Scanner;


public class Cinema {
    static Scanner sc = new Scanner(System.in);
    static String[] movies = {"cars", "sonic", "avatar", "titanic", "spider-man"};
    static int[] placesDispo = {28, 32, 50, 45};


    public static void main() {
        int choix;
        do {
            affichageMenu();
            choix = sc.nextInt();
            switch (choix) {
                case 1 -> affichageMovie();
                case 2 -> reservation();
                case 3 -> placeRestantes();
            }
        } while (choix != 4);
        if(choix == 4){
            System.out.println("A bientot");
        }
    }

    private static void affichageMenu() {
        System.out.println("********************************************\n" +
                "*                                          *\n" +
                "*            Système de Réservation        *\n" +
                "*                 de Cinéma                *\n" +
                "*                                          *\n" +
                "********************************************");

        System.out.println("* 1. Liste des films                       *");
        System.out.println("* 2. Réserver une place                    *");
        System.out.println("* 3. Nombre de places restantes            *");
        System.out.println("* 4. Quitter                               *");
        System.out.println("********************************************");

        System.out.println("Veuillez choisir une option:");
    }


    public static void affichageMovie() {
        System.out.println("Voici la liste des films disponible :");
        for (int i = 0; i < movies.length; i++) {
            System.out.println(i + ".  " + movies[i]);
        }
    }


    public static void placeRestantes() {
        System.out.println("--------------------------------------------");
        System.out.println("|    TITRE          |    PLACES             |");
        System.out.println("--------------------------------------------");
        for (int i = 0; i < placesDispo.length; i++) {
            System.out.println("|   " + i + "          |   " + placesDispo[i] + "   |");
        }
    }


    public static void reservation() {
        System.out.println("         Reservation          ");
        System.out.println("Quel film souhaitez vous reserver ?");
        affichageMovie();
        int film;
        do {
            System.out.println("Veuillez choisir un numéro de  film valide : ");
            film = sc.nextInt();
        } while (film < 0 || film >= movies.length);


        if (placesDispo[film] > 0) {
            System.out.println("Bravo vous avez reservé votre séance de film : " + movies[film]);
            placesDispo[film] -= 1;
        }
    }
}
