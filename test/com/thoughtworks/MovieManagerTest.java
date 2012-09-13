package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieManagerTest {
    MovieManager movieManager;


    @Before
    public void setUp() {
        movieManager = new MovieManager();
    }

    @Test
    public void shouldInitializeSuccessfully() {
        ArrayList<Movie> movieArrayList = movieManager.getMovieList();
        assertThat("initiation failed", movieArrayList.size(), is(15));
    }

    @Test
    public void shouldAddMovieSuccessfully() {
        Movie movie = new Movie("2012", "Roland Emmerich", "8.8");
        movieManager.addMovies(movie);
        assertThat("add movie failed", movieManager.getMovieList().contains(movie), is(true));
    }
}
