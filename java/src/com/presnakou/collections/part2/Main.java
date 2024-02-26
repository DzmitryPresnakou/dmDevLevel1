package com.presnakou.collections.part2;

/**
 * Даны 2 класса:
 * <p>
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 * <p>
 * - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив,
 * где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.
 * <p>
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * <p>
 * - добавлять в него новый фильм
 * <p>
 * - получить все фильмы по переданному году
 * <p>
 * - получить все фильмы по переданному году и месяцу
 * <p>
 * - получить все фильмы по переданному жанру
 * <p>
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 * <p>
 * Учесть следующее:
 * <p>
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него
 * (т.е. предусмотреть порядок значения ассоциативного массива)
 * <p>
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 * <p>
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */

import com.presnakou.collections.part2.utils.MovieUtil;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {

        Cinema cinema = new Cinema(new LinkedHashMap<Integer, HashSet<Movie>>());

        cinema.addMovie(new Movie(1, 1990, 10, "comedy", 7.4));
        cinema.addMovie(new Movie(2, 1991, 8, "drama", 5.2));
        cinema.addMovie(new Movie(3, 1992, 3, "fiction", 4.8));
        cinema.addMovie(new Movie(4, 2000, 2, "detective", 8.1));
        cinema.addMovie(new Movie(5, 2000, 8, "thriller", 6.6));
        cinema.addMovie(new Movie(6, 2000, 12, "music", 7.2));
        cinema.addMovie(new Movie(7, 2005, 10, "historic", 7.7));
        cinema.addMovie(new Movie(8, 2005, 6, "fiction", 5.9));
        cinema.addMovie(new Movie(9, 2010, 11, "drama", 6.8));
        cinema.addMovie(new Movie(10, 2010, 1, "thriller", 8.0));
        cinema.addMovie(new Movie(11, 2003, 5, "comedy", 4.9));
        cinema.addMovie(new Movie(12, 2009, 4, "thriller", 6.0));
        cinema.addMovie(new Movie(13, 2020, 9, "comedy", 7.0));
        cinema.addMovie(new Movie(14, 2021, 7, "fiction", 6.7));
        cinema.addMovie(new Movie(15, 2021, 8, "drama", 6.9));

        System.out.println(cinema);
        System.out.println(cinema.getMoviesByYear(2000));
        System.out.println(cinema.getMoviesByYearAndMonth(2010, 11));
        System.out.println(cinema.getMoviesByGenre("comedy"));
        System.out.println(MovieUtil.getRatingTopTenInDescendingOrder(cinema));
    }
}
