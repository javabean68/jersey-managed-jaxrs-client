package sk.dejavu.jersey.sample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.glassfish.jersey.server.ClientBinding;

/**
 * @author Michal Gajdos
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@ClientBinding(
        baseUri = "http://csfdapi.cz/",
        inheritServerProviders = false,
        configClass = ManagedClientConfig.class
)
public @interface CsfdClient {
}
