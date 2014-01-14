package sk.dejavu.jersey.sample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * @author Michal Gajdos
 */
@Path("internal")
public class InternalResource {

    @GET
    @Path("greeting/{greeting: .*}")
    public String getGreeting(@PathParam("greeting") final String greeting) {
        return "".equals(greeting) ? "Hello" : greeting;
    }
}
