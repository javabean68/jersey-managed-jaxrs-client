package sk.dejavu.jersey.sample.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Michal Gajdos
 */
@XmlRootElement(name = "root")
public class ImdbRoot {

    @XmlElement(name = "movie")
    private ImdbMovie movie;

    public ImdbMovie getMovie() {
        return movie;
    }
}
