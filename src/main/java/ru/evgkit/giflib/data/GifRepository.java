package ru.evgkit.giflib.data;

import org.springframework.stereotype.Component;
import ru.evgkit.giflib.model.Gif;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by e on 30.01.16.
 */
@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
        new Gif("android-explosion", LocalDate.of(2015, 2, 13), "Chris Ramacciotti"),
        new Gif("ben-and-mike", LocalDate.of(2015, 10, 30), "Ben Jakuben", true),
        new Gif("book-dominos", LocalDate.of(2015, 9, 15), "Craig Dennis"),
        new Gif("compiler-bot", LocalDate.of(2015, 2, 13), "Ada Lovelace", true),
        new Gif("cowboy-coder", LocalDate.of(2015, 2, 13), "Grace Hopper"),
        new Gif("infinite-andrew", LocalDate.of(2015, 8, 23), "Marissa Mayer", true)
    );

    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if (name.equals(gif.getName())) {
                return gif;
            }
        }

        return null;
    }
}
