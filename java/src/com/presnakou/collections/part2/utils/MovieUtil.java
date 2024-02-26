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
}
