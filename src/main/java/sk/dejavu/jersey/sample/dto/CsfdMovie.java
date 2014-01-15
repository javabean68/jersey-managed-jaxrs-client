package sk.dejavu.jersey.sample.dto;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.google.common.base.Objects;

/**
 * @author Michal Gajdos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CsfdMovie {

    @JsonProperty("names")
    private Map<String, String> names;

    private int rating;

    @JsonProperty("csfd_url")
    private String link;

    public String getEnName() {
        return names.get("en");
    }

    public int getRating() {
        return rating;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(CsfdMovie.class).
                add("names", names).
                add("rating", rating).
                add("link", link).
                omitNullValues().
                toString();
    }
}
