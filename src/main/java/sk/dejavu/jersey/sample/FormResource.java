package sk.dejavu.jersey.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.WebTarget;

import org.glassfish.jersey.server.Uri;
import org.glassfish.jersey.server.mvc.Template;

/**
 * @author Michal Gajdos
 */
@Path("/{greeting: .*}")
public class FormResource {

    @GET
    @Produces("text/html")
    @Template(name = "/form")
    public String getForm(
            @Uri("internal/greeting/{greeting}") final WebTarget greeting) {
        return greeting.request().get(String.class);
    }
}
