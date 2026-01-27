package Assignment2dot3;

import java.util.ArrayList;

public class Book {
    private final String title;
    private final String author;
    private final int pubYear;
    private double rating;
    private ArrayList<String> reviews = new ArrayList<String>();

    public Book(String title, String author, int pubYear){
        this.title = title;
        this.author = author;
        this.pubYear = pubYear;
    }
    String getTitle(){
        return title;
    }
    String getAuthor(){
        return author;
    }
    int getYear(){
        return pubYear;
    }
    void setRating(double rating){
        this.rating = rating;
    }
    void addReview(String review){
        reviews.add(review);
    }
    double getRating(){
        return this.rating;
    }
    int reviewAmount(){
        return reviews.size();
    }
    void displayReviews(){
        for(String review : reviews){
            System.out.println(review);
        }
    }
}
