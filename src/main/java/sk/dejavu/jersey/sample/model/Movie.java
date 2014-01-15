package sk.dejavu.jersey.sample.model;

import com.google.common.base.Objects;

/**
 * @author Michal Gajdos
 */
public class Movie {

    private final String link;
    private final String title;
    private final Integer rating;

    public Movie(final String link, final String title, final Integer rating) {
        this.link = link;
        this.title = title;
        this.rating = rating;
    }

    public String getLink() {
        return link;
    }

    public String getTitle() {
        return title;
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(Movie.class).
                add("link", link).
                add("title", title).
                add("rating", rating).
                omitNullValues().
                toString();
    }
}
