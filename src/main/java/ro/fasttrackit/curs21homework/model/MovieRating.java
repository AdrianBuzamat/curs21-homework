package ro.fasttrackit.curs21homework.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MovieRating {
    @Id
    @GeneratedValue
    private int id;
    private double rating;
    private String agency;

    public MovieRating() {
    }

    public MovieRating(double rating, String agency) {
        this.rating = rating;
        this.agency = agency;
    }

    public int getId() {
        return id;
    }

    public double getRating() {
        return rating;
    }

    public String getAgency() {
        return agency;
    }
}
