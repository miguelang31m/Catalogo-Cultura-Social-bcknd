package culturemedia.repository.impl;

import java.util.ArrayList;
import java.util.List;

import culturemedia.model.View;
import culturemedia.repository.ViewsRepository;

public class ViewsRepositoryImpl implements ViewsRepository {

    private final List<View> views;

    public ViewsRepositoryImpl() {
        this.views = new ArrayList<>();
    }

    @Override
    public View save(View view) {
        this.views.add(view);
        return view;
    }

    @Override
    public List<View> findAll() {
        return null; // Implementación pendiente
    }

    @Override
    public List<View> find(String userFullName) {
        return null; // Implementación pendiente
    }

    @Override
    public List<View> findByVideo(String videoTitle) {
        return null; // Implementación pendiente
    }
}
