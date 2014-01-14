package sk.dejavu.jersey.sample.dto;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author Michal Gajdos
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CsfdSearch {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }
}
