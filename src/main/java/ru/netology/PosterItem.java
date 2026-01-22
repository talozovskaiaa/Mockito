package ru.netology;

public class PosterItem {
    private int id;
    private String name;
    private int rating;
    private String genre;

    public PosterItem(int id, String name, int rating, String genre) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.genre = genre;
    }

    /**
     метод для возвращения id элементов
     */
    public int getId() {
        return id;
    }

    /**
     метод для возвращения наименования элементов
     */
    public String getName() {
        return name;
    }

    /**
     метод для возвращения рейтинга элементов
     */
    public int getRating() {
        return rating;
    }

    /**
     метод для возвращения жанра элементов
     */
    public String getGenre() {
        return genre;
    }
}
