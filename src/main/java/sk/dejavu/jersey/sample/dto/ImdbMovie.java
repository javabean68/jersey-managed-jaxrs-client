package sk.dejavu.jersey.sample.dto;

import javax.xml.bind.annotation.XmlAttribute;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.common.base.Objects;

/**
 * @author Michal Gajdos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImdbMovie {

    @JsonProperty("Title")
    @XmlAttribute
    private String title;

    @JsonProperty("imdbRating")
    @XmlAttribute(name = "imdbRating")
    private Double rating;

    @JsonProperty("imdbID")
    @XmlAttribute(name = "imdbID")
    private String id;

    public String getTitle() {
        return title;
    }

    public Double getRating() {
        return rating;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(ImdbMovie.class).
                add("title", title).
                add("rating", rating).
                add("id", id).
                omitNullValues().
                toString();
    }
}
