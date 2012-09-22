package com.thoughtworks;

import java.util.ArrayList;

public class MovieManager {
    private ArrayList<Movie> movieList = new ArrayList<Movie>();

    public MovieManager() {
        initializeMovies(getMovieInfo());
    }

    private void initializeMovies(Movie[] movie) {
        for (Movie aMovie : movie) {
            addMovies(aMovie);
        }
    }

    public void addMovies(Movie movie) {
        if (movieList.contains(movie)) {
            new Messages().showMovieAlreadyExistMessage();
        } else {
            movieList.add(movie);
        }
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    private Movie[] getMovieInfo() {
        return new Movie[]{
                new Movie("Star Treck", "J.J. Abrams", "8.0"), new Movie("Mission Impossible III", "J.J. Abrams", "9.0"),
                new Movie("Notorious", "Alfred Hitchcock", "7.4"), new Movie("Taxi Driver", "Martin Scorsese", "9.8"),
                new Movie("Curly Sue", "John Hughes", "7.0"), new Movie("Network", "Sidney Lumet", "9.1"), new Movie("A Serious Man", "Joel and Ethan Coen", "9.0"),
                new Movie("The Life Aquatic with Steve Zissou", "Wes Andersen", "9.0"), new Movie("The 40-Year-Old Virgin", "Judd Apatow", "9.2"),
                new Movie("Avatar", "James Cameron", "9.0"), new Movie("King Kong", "Peter Jackson", "6.4"),
                new Movie("Young Frankenstein", "Mel Brooks", "6.0"), new Movie("Being John Malkovich", "Spike Jonze", "7.9"),
                new Movie("Do the Right Thing", "Spike Lee", "N/A"), new Movie("A.I.", "Steven Speilberg", "9.6")};
    }
}
