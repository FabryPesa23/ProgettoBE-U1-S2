package fabriziopesaresi.entities;

public class Videogioco extends Gioco {
    private final String piattaforma;
    private final int durataOre;
    private final Genere genere;

    public Videogioco(String titolo, int annoPubblicazione, double prezzo, String piattaforma, int durataOre, Genere genere) {
        super(titolo, annoPubblicazione, prezzo);
        this.piattaforma = piattaforma;
        this.durataOre = durataOre;
        this.genere = genere;
    }

    public String getPiattaforma() {
        return piattaforma;
    }
    public int getDurataOre() {
        return durataOre;
    }
    public Genere getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Videogioco{" + super.toString() + ", piattaforma='" + piattaforma + '\'' +
                ", durata=" + durataOre + "h, genere=" + genere + "}";
    }
}