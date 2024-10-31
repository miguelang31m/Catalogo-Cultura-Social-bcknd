package culturemedia.controllers;

import java.util.*;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CultureotecaService;

public class CultureMediaController {

    private final CultureotecaService cultureMediaService;

    public CultureMediaController(CultureotecaService cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }

    public List<Video> findAllVideos() throws VideoNotFoundException {
        return cultureMediaService.listarTodos();
    }

    public Video agregarVideo(Video video) {
        return cultureMediaService.agregar(video);
    }
}
