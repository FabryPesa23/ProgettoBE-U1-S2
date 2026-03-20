package fabriziopesaresi.entities;

public class GiocoDaTavolo extends Gioco {
    private int numeroGiocatori;
    private int durataMediaMinuti;

    public GiocoDaTavolo(String titolo, int annoPubblicazione, double prezzo, int numeroGiocatori, int durataMediaMinuti) {
        super(titolo, annoPubblicazione, prezzo);
        if (numeroGiocatori < 2 || numeroGiocatori > 10) {
            throw new IllegalArgumentException("Giocatori tra 2 e 10");
        }
        this.numeroGiocatori = numeroGiocatori;
        this.durataMediaMinuti = durataMediaMinuti;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }
    public int getDurataMediaMinuti() {
        return durataMediaMinuti;
    }

    @Override
    public String toString() {
        return "GiocoDaTavolo{" + super.toString() + ", giocatori=" + numeroGiocatori +
                ", durata=" + durataMediaMinuti + "min}";
    }
}