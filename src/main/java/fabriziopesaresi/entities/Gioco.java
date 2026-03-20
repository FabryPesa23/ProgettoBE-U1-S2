package fabriziopesaresi.entities;

import java.util.UUID;

public abstract class Gioco {
    private String id;
    private String titolo;
    private int annoPubblicazione;
    private double prezzo;

    public Gioco(String titolo, int annoPubblicazione, double prezzo) {
        this.id = UUID.randomUUID().toString();
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.prezzo = prezzo;
    }

    public String getId() {
        return id;
    }
    public String getTitolo() {
        return titolo;
    }
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' + ", titolo='" + titolo + '\'' +
                ", anno=" + annoPubblicazione + ", prezzo=" + prezzo;
    }
}