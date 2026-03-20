package fabriziopesaresi;

import com.github.javafaker.Faker;
import fabriziopesaresi.entities.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Faker faker = new Faker(Locale.ITALIAN);

        Videogioco v1 = new Videogioco("Elden Ring", 2022, 69.99, "PC", 100, Genere.GDR);
        System.out.println("Test Videogioco: " + v1);

        String titoloCasuale = faker.backToTheFuture().character();
        System.out.println("Titolo generato da Faker: " + titoloCasuale);

        GiocoDaTavolo g1 = new GiocoDaTavolo("Risiko", 1957, 35.0, 6, 120);
        System.out.println("Test Gioco da Tavolo: " + g1);
    }
}