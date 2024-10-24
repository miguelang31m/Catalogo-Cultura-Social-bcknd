package culturemedia.repository;

import java.util.List;
import culturemedia.model.Video;
import culturemedia.model.View;

public interface VideoRepository {
    List<Video> findAll();
    Video save(Video video);
    View save(View view); // Agregar este método
    List<Video> find(String title);
    List<Video> find(Double fromDuration, Double toDuration);
}
