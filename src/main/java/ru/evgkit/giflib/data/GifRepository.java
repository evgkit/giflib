package ru.evgkit.giflib.data;

import org.springframework.stereotype.Component;
import ru.evgkit.giflib.model.Gif;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
        new Gif("android-explosion", 1, LocalDate.of(2015, 2, 13), "Chris Ramacciotti"),
        new Gif("ben-and-mike", 2, LocalDate.of(2015, 10, 30), "Ben Jakuben", true),
        new Gif("book-dominos", 1, LocalDate.of(2015, 9, 15), "Craig Dennis"),
        new Gif("compiler-bot", 3, LocalDate.of(2015, 2, 13), "Ada Lovelace", true),
        new Gif("cowboy-coder", 1, LocalDate.of(2015, 2, 13), "Grace Hopper"),
        new Gif("infinite-andrew", 2, LocalDate.of(2015, 8, 23), "Marissa Mayer", true)
    );

    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if (name.equals(gif.getName())) {
                return gif;
            }
        }

        return null;
    }

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id) {
        List<Gif> categoryGifs = new ArrayList<>();

        for (Gif gif : ALL_GIFS) {
            if (gif.getCategoryId() == id) {
                categoryGifs.add(gif);
            }
        }

        return categoryGifs;
    }
}
