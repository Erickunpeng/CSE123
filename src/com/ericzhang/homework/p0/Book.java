package com.ericzhang.homework.p0;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric Zhang
 * @version 1.0
 */

/**
 * A class that implements Media interface that represents books
 */
public class Book implements Media {

    // The book's title
    private String title;
    // The author list for this book
    private List<String> authors;
    // The rating list for this book
    private List<Integer> ratings;

    /**
     * The constructor for the only author
     *
     * @param title  The book's title'
     * @param author The author's name
     */
    public Book(String title, String author) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.authors.add(author);
        this.ratings = new ArrayList<>();
    }

    /**
     * The constructor for multiple authors
     *
     * @param title   The book's title'
     * @param authors The author list
     */
    public Book(String title, List<String> authors) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.authors.addAll(authors);
        this.ratings = new ArrayList<>();
    }

    /**
     * Gets the title of this book.
     *
     * @return The title of this book.
     */
    @Override
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets all authors associated with this book.
     *
     * @return A list of authors for this book.
     */
    @Override
    public List<String> getArtists() {
        return this.authors;
    }

    /**
     * Adds a rating to this book.
     *
     * @param score The score for the new rating. Should be non-negative.
     */
    @Override
    public void addRating(int score) {
        ratings.add(score);
    }

    /**
     * Gets the number of times this book has been rated.
     *
     * @return The number of ratings for this book.
     */
    @Override
    public int getNumRatings() {
        return ratings.size();
    }

    /**
     * Gets the average (mean) of all ratings for this book.
     *
     * @return The average (mean) of all ratings for this book. If no ratings exist, returns 0.
     */
    @Override
    public double getAverageRating() {
        if (ratings.size() != 0) {
            int sum = 0;
            for (int i : ratings) {
                sum += i;
            }
            return (double) sum / getNumRatings();
        }
        return 0;
    }

    /**
     * Gets the toString information for this book
     *
     * @return The book title, the author list,
     * and the average rating for this book (rating times).
     * If no ratings exist, returns "No ratings yet!" after the author list.
     */
    @Override
    public String toString() {

        if (ratings.size() == 0) {
            return this.title + " by " + this.authors.toString() + ": " +
                    "No ratings yet!";
        }
        return this.title + " by " + this.authors.toString() + ": " +
                String.format("%.2f", getAverageRating()) + " (" + getNumRatings() + " ratings)";
    }
}
