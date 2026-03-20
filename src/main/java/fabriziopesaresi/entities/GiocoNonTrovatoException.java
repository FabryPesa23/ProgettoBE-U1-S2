package fabriziopesaresi.entities;

public class GiocoNonTrovatoException extends RuntimeException {
    public GiocoNonTrovatoException(String message) {
        super(message);
    }
}