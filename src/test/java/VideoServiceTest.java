package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.impl.VideoRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VideoServiceTest {

    private final VideoRepository videoRepository = new VideoRepositoryImpl();
    private final VideoService videoService = new VideoService(videoRepository);

    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        Video video1 = new Video("code1", "Title1", "Description1", 10.0);
        Video video2 = new Video("code2", "Title2", "Description2", 20.0);
        videoService.save(video1);
        videoService.save(video2);

        List<Video> videos = videoService.findAll();
        assertEquals(2, videos.size());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        Exception exception = assertThrows(VideoNotFoundException.class, () -> {
            videoService.findAll();
        });

        String expectedMessage = "No videos found";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void when_FindByTitle_video_exists_should_return_video_successfully() throws VideoNotFoundException {
        Video video1 = new Video("code1", "Title1", "Description1", 10.0);
        Video video2 = new Video("code2", "Title2", "Description2", 20.0);
        videoService.save(video1);
        videoService.save(video2);

        List<Video> foundVideos = videoService.findByTitle("Title1");
        assertEquals(1, foundVideos.size());
        assertEquals("Title1", foundVideos.get(0).title());
    }

    @Test
    void when_FindByTitle_video_does_not_exist_should_throw_VideoNotFoundException() {
        Exception exception = assertThrows(VideoNotFoundException.class, () -> {
            videoService.findByTitle("NonExistingTitle");
        });

        String expectedMessage = "No videos found with title: NonExistingTitle";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void when_FindByDuration_videos_exist_should_return_videos_successfully() throws VideoNotFoundException {
        Video video1 = new Video("code1", "Title1", "Description1", 10.0);
        Video video2 = new Video("code2", "Title2", "Description2", 20.0);
        videoService.save(video1);
        videoService.save(video2);

        List<Video> foundVideos = videoService.findByDuration(5.0, 15.0);
        assertEquals(1, foundVideos.size());
        assertEquals("Title1", foundVideos.get(0).title());
    }

    @Test
    void when_FindByDuration_no_videos_found_should_throw_VideoNotFoundException() {
        Exception exception = assertThrows(VideoNotFoundException.class, () -> {
            videoService.findByDuration(30.0, 40.0);
        });

        String expectedMessage = "No videos found in the duration range: 30.0 to 40.0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
