package ru.netology;

import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.Random;

public class FakerUtils {

    private static Faker faker = new Faker(new Locale("ru"));

    private FakerUtils() {
    }

    /**
     * Возвращает случайный жанр фильма
     */
    public static String generateRandomMovieGenre() {
        String[] genres = {
                "horror", "fantasy", "thriller", "comedy", "drama",
                "action", "sci-fi", "romance", "documentary", "animation",
                "crime", "mystery", "adventure", "biography", "history",
                "musical", "western", "war", "family", "sport"
        };
        Random random = new Random();
        return genres[random.nextInt(genres.length)];
    }

    /**
     * Возвращает случайное название кино
     */
    public static String generateRandomMovieName() {
        String[] names = {
                "Screem", "Avatar", "Shutter Island", "Frozen", "Hangover",
                "Hotel Transilvania", "Avengers", "Die hard", "Lost",
                "The Godfather", "The silence of the lambs", "Forrest Gump"
        };
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    /**
     * Возвращает случайный id
     */
    public static int generateMovieId() {
        return faker.number().numberBetween(1, 1000);
    }

    /**
     * Возвращает рейтинг фильма от 1 до 5
     */
    public static int generateRating() {
        return faker.number().numberBetween(1, 5);
    }

    /**
     * Возвращает сгенерированный фильм со всеми характеристиками
     */
    public static PosterItem generatePosterItem() {
        return new PosterItem(
                generateMovieId(),
                generateRandomMovieName(),
                generateRating(),
                generateRandomMovieGenre()
        );
    }
}
