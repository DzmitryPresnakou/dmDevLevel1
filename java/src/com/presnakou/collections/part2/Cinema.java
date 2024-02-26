package com.presnakou.collections.part2;

import java.util.*;

public class Cinema {
    private LinkedHashMap<Integer, HashSet<Movie>> movies;

    public Cinema(LinkedHashMap<Integer, HashSet<Movie>> movies) {
        this.movies = movies;
    }

    public void addMovie(Movie movie) {
        if (movies.isEmpty() || !movies.containsKey(movie.getYear())) {
            Set<Movie> newMovies = new HashSet<>();
            newMovies.add(movie);
            movies.put(movie.getYear(), (HashSet<Movie>) newMovies);
        } else {
            movies.get(movie.getYear()).add(movie);
        }
    }

    public Set<Movie> getMoviesByYear(int year) {
        return movies.get(year);
    }

    public Set<Movie> getMoviesByYearAndMonth(int year, int month) {
        Set<Movie> moviesByYear = movies.get(year);
        Set<Movie> moviesByMonth = new HashSet<>();

        for (Iterator<Movie> iterator = moviesByYear.iterator(); iterator.hasNext(); ) {
            Movie movie = iterator.next();
            if (movie.getMonth() == month) {
                moviesByMonth.add(movie);
            }
        }
        return moviesByMonth;
    }

    public Set<Movie> getMoviesByGenre(String genre) {
        Collection<HashSet<Movie>> allMovies = movies.values();
        Set<Movie> moviesByGenre = new HashSet<>();

        for (Iterator<HashSet<Movie>> iterator1 = allMovies.iterator(); iterator1.hasNext(); ) {
            HashSet<Movie> movies = iterator1.next();
            for (Iterator<Movie> iterator2 = movies.iterator(); iterator2.hasNext(); ) {
                Movie movie = iterator2.next();
                if (genre.equalsIgnoreCase(movie.getGenre())) {
                    moviesByGenre.add(movie);
                }
            }
        }
        return moviesByGenre;
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

