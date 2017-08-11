package ru.evgkit.giflib.service;

import ru.evgkit.giflib.model.Gif;

import java.util.List;

public interface GifService {
    List<Gif> findAll();

    Gif findById(Long id);

    void save(Gif gif);

    void update(Gif gif);

    void delete(Gif gif);
}
