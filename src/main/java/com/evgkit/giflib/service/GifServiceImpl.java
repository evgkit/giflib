package com.evgkit.giflib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.evgkit.giflib.dao.GifDao;
import com.evgkit.giflib.model.Gif;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class GifServiceImpl implements GifService {
    @Autowired
    private GifDao gifDao;

    @Override
    public List<Gif> findAll() {
        return (List<Gif>) gifDao.findAll();
    }

    @Override
    public Gif findById(Long id) {
        Optional<Gif> gif = gifDao.findById(id);
        return gif.orElse(null);
    }

    @Override
    public void save(Gif gif) {
        try {
            gif.setBytes(gif.getFile().getBytes());
            gifDao.save(gif);
        } catch (IOException e) {
            System.err.println("Unable to get byte array from uploaded file");
        }
    }

    @Override
    public void update(Gif gif) {
        MultipartFile file = gif.getFile();

        if (file != null && !file.isEmpty()) {
            try {
                gif.setBytes(file.getBytes());
            } catch (IOException e) {
                System.err.println("Unable to get byte array from uploaded file");
            }
        } else {
            Optional<Gif> oldGif = gifDao.findById(gif.getId());
            oldGif.ifPresent(g -> gif.setBytes(g.getBytes()));
        }

        gifDao.save(gif);
    }

    @Override
    public void delete(Gif gif) {
        gifDao.delete(gif);
    }

    @Override
    public void toggleFavorite(Gif gif) {
        gif.setFavorite(!gif.isFavorite());
        gifDao.save(gif);
    }

    @Override
    public List<Gif> searchByName(String q) {
        return null;
    }
}
