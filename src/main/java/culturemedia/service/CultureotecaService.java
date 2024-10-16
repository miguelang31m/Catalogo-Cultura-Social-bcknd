package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;
import java.util.List;

public interface CultureotecaService {
    List<Video> listarTodos();
    View agregarReproduccion(View view);
}
