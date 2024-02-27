package com.presnakou.collections.part2.utils;

import com.presnakou.collections.part2.Cinema;
import com.presnakou.collections.part2.Movie;
import com.presnakou.collections.part2.comparator.RatingComparator;

import java.util.*;

public final class MovieUtil {

    private MovieUtil() {
    }

    public static List<Movie> getRatingTopTenInDescendingOrder(Cinema cinema) {
        Collection<HashSet<Movie>> allMovies = cinema.getMovies().values();
        List<Movie> topTenMovies = new ArrayList<>();

        for (HashSet<Movie> movies : allMovies) {
            topTenMovies.addAll(movies);
        }
        topTenMovies.sort(new RatingComparator());
        return topTenMovies.reversed().subList(0, 10);
    }

    public static Set<Movie> getMoviesByYear(Cinema cinema, Integer year) {

        return cinema.getMovies().get(year);
    }

    public static Set<Movie> getMoviesByYearAndMonth(Cinema cinema, Integer year, Month month) {
        Set<Movie> moviesByYear = cinema.getMovies().get(year);
        Set<Movie> moviesByMonth = new HashSet<>();

        for (Iterator<Movie> iterator = moviesByYear.iterator(); iterator.hasNext(); ) {
            Movie movie = iterator.next();
            if (month.equals(movie.getMonth())) {
                moviesByMonth.add(movie);
            }
        }
        return moviesByMonth;
    }

    public static Set<Movie> getMoviesByGenre(Cinema cinema, Genre genre) {
        Collection<HashSet<Movie>> allMovies = cinema.getMovies().values();
        Set<Movie> moviesByGenre = new HashSet<>();

        for (Iterator<HashSet<Movie>> iterator1 = allMovies.iterator(); iterator1.hasNext(); ) {
            HashSet<Movie> movies = iterator1.next();
            for (Iterator<Movie> iterator2 = movies.iterator(); iterator2.hasNext(); ) {
                Movie movie = iterator2.next();
                if (genre.equals(movie.getGenre())) {
                    moviesByGenre.add(movie);
                }
            }
        }
        return moviesByGenre;
    }
}
