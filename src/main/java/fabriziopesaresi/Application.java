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

        boolean continua = true;
        while (continua) {
            System.out.println("\n--- MENU GESTIONE ---");
            System.out.println("1. Cerca per ID | 2. Cerca per Prezzo | 3. Rimuovi | 0. Esci");

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