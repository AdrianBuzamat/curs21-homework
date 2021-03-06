package ro.fasttrackit.curs21homework.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int year;

    @OneToOne (cascade = CascadeType.ALL)
    private MovieRating movieRating;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;

    @ManyToOne
    private Studio studio;

    @ManyToMany
    private List<Actor> actors;

    public Movie() {
    }

    public Movie(String name, int year) {
        this(name, year, null);
    }

    public Movie(String name, int year, MovieRating movieRating) {
        this(name, year, movieRating, List.of());
    }

    public Movie(String name, int year, MovieRating movieRating, List<Review> reviews) {
        this(name, year, movieRating, reviews, null);
    }

    public Movie(String name, int year, MovieRating movieRating, List<Review> reviews, Studio studio) {
        this(name, year, movieRating, reviews, studio, List.of());
    }

    public Movie(String name, int year, MovieRating movieRating, List<Review> reviews, Studio studio, List<Actor> actors) {
        this.name = name;
        this.year = year;
        this.movieRating = movieRating;
        this.reviews = reviews;
        this.studio = studio;
        this.actors = actors;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Studio getStudio() {
        return studio;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
