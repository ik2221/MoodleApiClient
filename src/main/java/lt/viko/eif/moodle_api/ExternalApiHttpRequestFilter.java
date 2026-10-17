package lt.viko.eif.moodle_api;

import io.micronaut.context.annotation.Property;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.annotation.ClientFilter;
import io.micronaut.http.annotation.RequestFilter;
import jakarta.inject.Singleton;

@Singleton
@ClientFilter(serviceId = "moodle-api")
public class ExternalApiHttpRequestFilter {
    private final String token;

    // Inject Moodle API token from application.properties
    public ExternalApiHttpRequestFilter(
            @Property(name = "external.moodle-api.access-token") String token
    ) {
        this.token = token;
    }

    /**
     * Automatically injects common web service API params on every HTTP request.
     * This is needed so that we don't repeat common params for every method in
     * the {@code MoodleExternalApiClient} interface.
     */
    @RequestFilter
    public void addCommonRequestParams(MutableHttpRequest<?> request) {
        request.uri(uriBuilder -> uriBuilder
                .queryParam("wstoken", token)
                .queryParam("moodlewsrestformat", "json")
        );
    }
}
