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

import com.presnakou.collections.part2.utils.Genre;
import com.presnakou.collections.part2.utils.Month;
import com.presnakou.collections.part2.utils.MovieUtil;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {

        Cinema cinema = new Cinema(new LinkedHashMap<Integer, HashSet<Movie>>());

        cinema.addMovie(new Movie(1, 1990, Month.OCTOBER, Genre.COMEDY, 7.4));
        cinema.addMovie(new Movie(2, 1991, Month.AUGUST, Genre.DRAMA, 5.2));
        cinema.addMovie(new Movie(3, 1992, Month.MARCH, Genre.FICTION, 4.8));
        cinema.addMovie(new Movie(4, 2000, Month.FEBRUARY, Genre.DETECTIVE, 8.1));
        cinema.addMovie(new Movie(5, 2000, Month.AUGUST, Genre.THRILLER, 6.6));
        cinema.addMovie(new Movie(6, 2000, Month.DECEMBER, Genre.MUSIC, 7.2));
        cinema.addMovie(new Movie(7, 2005, Month.OCTOBER, Genre.HISTORICAL, 7.7));
        cinema.addMovie(new Movie(8, 2005, Month.JUNE, Genre.FICTION, 5.9));
        cinema.addMovie(new Movie(9, 2010, Month.NOVEMBER, Genre.DRAMA, 6.8));
        cinema.addMovie(new Movie(10, 2010, Month.JANUARY, Genre.THRILLER, 8.0));
        cinema.addMovie(new Movie(11, 2003, Month.MAY, Genre.COMEDY, 4.9));
        cinema.addMovie(new Movie(12, 2009, Month.APRIL, Genre.THRILLER, 6.0));
        cinema.addMovie(new Movie(13, 2020, Month.SEPTEMBER, Genre.COMEDY, 7.0));
        cinema.addMovie(new Movie(14, 2021, Month.JULY, Genre.FANTASTIC, 6.7));
        cinema.addMovie(new Movie(15, 2021, Month.AUGUST, Genre.DETECTIVE, 6.9));

        System.out.println(cinema);
        System.out.println(MovieUtil.getMoviesByYear(cinema, 2000));
        System.out.println(MovieUtil.getMoviesByYearAndMonth(cinema, 2010, Month.NOVEMBER));
        System.out.println(MovieUtil.getMoviesByGenre(cinema, Genre.COMEDY));
        System.out.println(MovieUtil.getRatingTopTenInDescendingOrder(cinema));
    }
}
