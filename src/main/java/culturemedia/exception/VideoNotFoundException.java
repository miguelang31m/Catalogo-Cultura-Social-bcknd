package culturemedia.exception;

public class VideoNotFoundException extends CultureotecaException {
    public VideoNotFoundException(String message) {
        super(message);
    }

    public VideoNotFoundException() {
        super("Video not found.");
    }
}
