package sk.dejavu.jersey.sample;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.mustache.MustacheMvcFeature;

/**
 * @author Michal Gajdos
 */
@ApplicationPath("/")
public class MyApplication extends ResourceConfig {

    public MyApplication() {
        // Resources.
        packages(FormResource.class.getPackage().getName());

        // Providers.
        register(MustacheMvcFeature.class);
        register(JacksonFeature.class);

        // Properties.
        property(MustacheMvcFeature.TEMPLATE_BASE_PATH, "/mustache");
    }
}
