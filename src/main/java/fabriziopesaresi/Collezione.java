package fabriziopesaresi;

import fabriziopesaresi.entities.*;
import java.util.*;
import java.util.stream.Collectors;

public class Collezione {
    private final List<Gioco> catalogo = new ArrayList<>();

    public void aggiungi(Gioco g) {
        catalogo.add(g);
    }

    public Gioco ricercaPerId(String id) {
        return catalogo.stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new GiocoNonTrovatoException("ID non trovato: " + id));
    }

    public List<Gioco> ricercaPerPrezzo(double prezzoMax) {
        return catalogo.stream()
                .filter(g -> g.getPrezzo() < prezzoMax)
                .collect(Collectors.toList());
    }

    public List<GiocoDaTavolo> ricercaPerGiocatori(int n) {
        return catalogo.stream()
                .filter(g -> g instanceof GiocoDaTavolo)
                .map(g -> (GiocoDaTavolo) g)
                .filter(g -> g.getNumeroGiocatori() == n)
                .collect(Collectors.toList());
    }

    public void rimuovi(String id) {
        Gioco trovato = ricercaPerId(id);
        catalogo.remove(trovato);
    }

    public void stampaStatistiche() {
        long nVideo = catalogo.stream().filter(g -> g instanceof Videogioco).count();
        long nTavolo = catalogo.stream().filter(g -> g instanceof GiocoDaTavolo).count();

        System.out.println("Videogiochi: " + nVideo);
        System.out.println("Giochi da Tavolo: " + nTavolo);

        catalogo.stream()
                .max(Comparator.comparing(Gioco::getPrezzo))
                .ifPresent(max -> System.out.println("Il più costoso è: " + max.getTitolo()));

        double media = catalogo.stream()
                .collect(Collectors.averagingDouble(Gioco::getPrezzo));
        System.out.println("Prezzo medio: " + media);
    }
}