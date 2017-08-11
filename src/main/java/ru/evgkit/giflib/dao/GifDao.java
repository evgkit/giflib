package ru.evgkit.giflib.dao;

import ru.evgkit.giflib.model.Gif;

import java.util.List;

public interface GifDao {
    List<Gif> findAll();

    Gif findById(Long id);

    void save(Gif gif);

    void delete(Gif gif);
}
