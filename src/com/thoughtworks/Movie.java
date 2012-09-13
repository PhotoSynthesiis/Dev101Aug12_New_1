package com.thoughtworks;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 7/29/12
 * Time: 11:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Movie {
    private String movieName;
    private String director;
    private String rate;

    public Movie(String movieName, String director, String rate) {
        this.movieName = movieName;
        this.director = director;
        this.rate = rate;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirector() {
        return director;
    }

    public String getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Movie)) {
            return false;
        }

        Movie movie = (Movie)obj;
        return this.getMovieName().equalsIgnoreCase((movie).getMovieName());
    }

    @Override
    public int hashCode() {
        return (getMovieName() != null ? getMovieName().hashCode() : 1) * 31 + (getDirector() != null ? getDirector().hashCode() : 1) * 31;
    }
    
    @Override
    public String toString() {
        return "Movie Name : " + getMovieName() + "| Director : " + getDirector() + "| Rate : " + getRate();
    }
}
