package sk.dejavu.jersey.sample;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.Uri;
import org.glassfish.jersey.server.mvc.Template;

import com.google.common.collect.Maps;

import sk.dejavu.jersey.sample.dto.CsfdMovie;
import sk.dejavu.jersey.sample.dto.CsfdSearch;
import sk.dejavu.jersey.sample.dto.ImdbMovie;
import sk.dejavu.jersey.sample.dto.ImdbRoot;
import sk.dejavu.jersey.sample.model.Movie;

/**
 * @author Michal Gajdos
 */
@Path("/rating")
@Produces("text/html")
public class RatingsResource {

    @CsfdClient
    @Uri("movie")
    private WebTarget csfdSearch;

    @CsfdClient
    @Uri("movie/{id}")
    private WebTarget csfdMovie;

    @ImdbClient
    @Uri("http://omdbapi.com/?r={format}&t={search}")
    private WebTarget imdbMovie;

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Template(name = "/ratings")
    public Map<String, Object> getRatingsViaForm(@FormParam("movie") final String movie) {
        return getRatings(movie);
    }

    @GET
    @Path("{movie}")
    @Template(name = "/ratings")
    public Map<String, Object> getRatingsViaUri(@PathParam("movie") final String movie) {
        return getRatings(movie);
    }

    private Map<String, Object> getRatings(String movie) {
        final Map<String, Object> params = Maps.newHashMap();

        movie = "".equals(movie) ? "Fargo" : movie;

        params.put("search", movie);
        params.put("imdb", getImdbRating(movie));
        params.put("csfd", getCsfdRating(movie));

        return params;
    }

    private Movie getImdbRating(final String search) {
        final String format = imdbMovie.getConfiguration().getProperty("format").toString();

        final Response response = imdbMovie
                .resolveTemplate("search", search)
                .resolveTemplate("format", format)
                .request("application/" + format)
                .get();

        ImdbMovie movie;
        if ("xml".equals(format)) {
            movie = response.readEntity(ImdbRoot.class).getMovie();
        } else {
            // site is returning text/html for json.
            response.getHeaders().putSingle("Content-Type", "application/json");
            movie = response.readEntity(ImdbMovie.class);
        }

        return movie == null ? null : new Movie(
                "http://www.imdb.com/title/" + movie.getId(),
                movie.getTitle(),
                (int) (movie.getRating() * 10));
    }

    private Movie getCsfdRating(final String search) {
        final List<CsfdSearch> found = csfdSearch.queryParam("search", search)
                .request()
                .get(new GenericType<List<CsfdSearch>>() {});

        if (!search.isEmpty()) {
            final CsfdMovie movie = csfdMovie.resolveTemplate("id", found.get(0).getId())
                    .request()
                    .get(CsfdMovie.class);

            return new Movie(
                    movie.getLink(),
                    movie.getEnName(),
                    movie.getRating());
        }

        return null;
    }
}
