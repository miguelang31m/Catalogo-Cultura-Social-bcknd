package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;

import java.util.List;

public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public List<Video> findAll() throws VideoNotFoundException {
        List<Video> videos = videoRepository.findAll();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException("No videos found");
        }
        return videos;
    }

    public Video save(Video video) {
        return videoRepository.save(video);
    }

    public void save(View view) {
        videoRepository.save(view);
    }

    public List<Video> findByTitle(String title) throws VideoNotFoundException {
        List<Video> foundVideos = videoRepository.find(title);
        if (foundVideos.isEmpty()) {
            throw new VideoNotFoundException("No videos found with title: " + title);
        }
        return foundVideos;
    }

    public List<Video> findByDuration(Double fromDuration, Double toDuration) throws VideoNotFoundException {
        List<Video> foundVideos = videoRepository.find(fromDuration, toDuration);
        if (foundVideos.isEmpty()) {
            throw new VideoNotFoundException("No videos found in the duration range: " + fromDuration + " to " + toDuration);
        }
        return foundVideos;
    }
}
