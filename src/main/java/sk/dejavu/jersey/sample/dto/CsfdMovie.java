package sk.dejavu.jersey.sample.dto;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

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
}
