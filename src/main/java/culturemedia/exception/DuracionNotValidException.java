package culturemedia.exception;

public class DuracionNotValidException extends CultureotecaException {
    public DuracionNotValidException(String message, double duracion) {
        super(message + " Duration: " + duracion);
    }

    public DuracionNotValidException() {
        super("Duration not valid.");
    }
}
