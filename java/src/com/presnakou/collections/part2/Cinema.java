package com.presnakou.collections.part2;

import java.util.*;

public class Cinema {
    private LinkedHashMap<Integer, HashSet<Movie>> movies;

    public Cinema(LinkedHashMap<Integer, HashSet<Movie>> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        if (movies.isEmpty() || !movies.containsKey(movie.getYear())) {
            HashSet<Movie> newMovies = new HashSet<>();
            newMovies.add(movie);
            movies.put(movie.getYear(), newMovies);
        } else {
            movies.get(movie.getYear()).add(movie);
        }
    }

    public LinkedHashMap<Integer, HashSet<Movie>> getMovies() {
        return movies;
    }

    public void setMovies(LinkedHashMap<Integer, HashSet<Movie>> movies) {
        this.movies = movies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(movies, cinema.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movies);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "movies=\n" + movies +
                '}';
    }
}

