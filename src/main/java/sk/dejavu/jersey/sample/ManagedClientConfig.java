package sk.dejavu.jersey.sample;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * @author Michal Gajdos
 */
public class ManagedClientConfig extends org.glassfish.jersey.client.ClientConfig {

    public ManagedClientConfig() {
        // Providers.
        register(LoggingFilter.class);
        register(JacksonFeature.class);
    }
}
