package fabriziopesaresi;

import com.github.javafaker.Faker;
import fabriziopesaresi.entities.*;
import java.util.*;
import java.util.function.Supplier;

public class Application {
    public static void main(String[] args) {
        Collezione miaCollezione = new Collezione();
        Faker faker = new Faker(Locale.ITALIAN);
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);

        Supplier<Videogioco> randomVG = () -> new Videogioco(
                faker.gameOfThrones().character(),
                rnd.nextInt(2010, 2025),
                rnd.nextDouble() * 50 + 15,
                "PC", rnd.nextInt(10, 80), Genere.AVVENTURA);

        for (int i = 0; i < 3; i++) {
            miaCollezione.aggiungi(randomVG.get());
        }

        //test ********
        miaCollezione.aggiungi(new GiocoDaTavolo("Dixit", 2008, 30.0, 6, 30));
        miaCollezione.aggiungi(new GiocoDaTavolo("Monopoly", 1935, 25.0, 8, 90));

        boolean continua = true;
        while (continua) {
            System.out.println("\n--- MENU GESTIONE ---");
            System.out.println("1. Cerca per ID | 2. Cerca per Prezzo | 3. Cerca per Giocatori | 4. Rimuovi | 0. Esci");

            try {
                int scelta = Integer.parseInt(sc.nextLine());
                switch (scelta) {
                    case 1:
                        System.out.print("ID da cercare: ");
                        String id = sc.nextLine();
                        System.out.println("Risultato: " + miaCollezione.ricercaPerId(id));
                        break;
                    case 2:
                        System.out.print("Inserisci prezzo massimo: ");
                        double pMax = Double.parseDouble(sc.nextLine());
                        miaCollezione.ricercaPerPrezzo(pMax).forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Inserisci numero giocatori: ");
                        int nG = Integer.parseInt(sc.nextLine());
                        List<GiocoDaTavolo> filtrati = miaCollezione.ricercaPerGiocatori(nG);
                        if (filtrati.isEmpty()) {
                            System.out.println("Nessun gioco da tavolo trovato per " + nG + " giocatori.");
                        } else {
                            filtrati.forEach(System.out::println);
                        }
                        break;
                    case 4:
                        System.out.print("ID da eliminare: ");
                        miaCollezione.rimuovi(sc.nextLine());
                        System.out.println("Elemento rimosso.");
                        break;
                    case 0:
                        continua = false;
                        break;
                    default:
                        System.out.println("Scelta non valida.");
                }
            } catch (GiocoNonTrovatoException e) {
                System.err.println("Errore: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Errore nell'inserimento dei dati.");
            }
        }
        sc.close();
    }
}