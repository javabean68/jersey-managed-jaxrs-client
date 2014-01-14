package sk.dejavu.jersey.sample.model;

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
}
