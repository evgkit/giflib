package ru.evgkit.giflib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.evgkit.giflib.dao.GifDao;
import ru.evgkit.giflib.model.Gif;

import java.io.IOException;
import java.util.List;

@Service
public class GifServiceImpl implements GifService {
    @Autowired
    private GifDao gifDao;

    @Override
    public List<Gif> findAll() {
        return gifDao.findAll();
    }

    @Override
    public Gif findById(Long id) {
        return gifDao.findById(id);
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
            Gif oldGif = gifDao.findById(gif.getId());
            gif.setBytes(oldGif.getBytes());
        }

        gifDao.save(gif);
    }

    @Override
    public void delete(Gif gif) {
        gifDao.delete(gif);
    }
}
