package culturemedia.repository;

import java.util.List;
import culturemedia.model.View;

public interface ViewsRepository {
    List<View> findAll();
    View save(View view);
    List<View> find(String userFullName);
    List<View> findByVideo(String videoTitle);
}
