package culturemedia.service;

import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;

import java.util.List;

public class CultureotecaServiceImpl implements CultureotecaService {

    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;

    public CultureotecaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }

    @Override
    public List<Video> listarTodos() {
        return videoRepository.findAll();
    }

    @Override
    public View agregarReproduccion(View view) {
        return viewsRepository.save(view);
    }
}
