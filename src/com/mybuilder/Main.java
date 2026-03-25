/**
 *  Java program with realisation classical pattern Builder. Where Builder creates an object of a Post.
 */

package com.mybuilder;

import java.time.LocalDate;
import java.util.Objects;


/**
 *  Post class.
 */
class Post {

    // Fields of class Post.
    private final String title;
    private final String text;
    private final LocalDate date;

    // Constructor of the class post.
    public Post(Builder builder) {
        title = builder.title;
        text = builder.text;
        date = LocalDate.now();
    }

    // Getters of the class Post.
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }


    public LocalDate getDate() {
        return date;
    }

    // Method equals() to compare Post instances.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title) && Objects.equals(text, post.text) && Objects.equals(date, post.date);
    }

    // Method hashCode().
    @Override
    public int hashCode() {
        return Objects.hash(title, text, date);
    }

    // Method toString to show Post instance in readable form.
    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }

    // Inner nested class Builder.
    public static class Builder {

        // Fields of class Builder
        private String title;
        private String text;

        // Setting title.
        public Builder title(String title) {
            this.title = title;
            return this;
        }

        // Setting text.
        public  Builder text(String text) {
            this.text = text;
            return this;
        }

        // Method to create a Post.
        public Post build() {
            return new Post(this);
        }
    }
}




/**
 * Main class with main() method.
 */
public class Main {

    // JVM entry point.
    public static void main(String[] args) {

        // Creating a Post.
        Post post = new Post.Builder().title("Weather").text("Temperature is 9 degrees.").build();

        // Printing Post to console.
        System.out.println("Title: " + post.getTitle()); // Output: Title: Weather
        System.out.println("Text: " + post.getText()); // Output: Text: Temperature is 9 degrees.
        System.out.println("Date: " + post.getDate()); // Output: Date: 2026-03-25

    }
}
