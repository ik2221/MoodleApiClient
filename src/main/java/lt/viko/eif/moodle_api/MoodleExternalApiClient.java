package lt.viko.eif.moodle_api;

import io.micronaut.core.async.annotation.SingleResult;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;

// Key "id" must match the "moodle-api" web service name in application.properties
@Client(id = "moodle-api")
public interface MoodleExternalApiClient {

    @Get("/webservice/rest/server.php?wsfunction=gradereport_user_get_grade_items")
    @SingleResult
    Publisher<String> getRawGradesDataForCourse(
            @QueryValue("courseid") long courseId
    );

    @Get("/webservice/rest/server.php?wsfunction=gradereport_user_get_grade_items")
    @SingleResult
    Publisher<String> getRawGradesDataForCourseAndUser(
            @QueryValue("courseid") long courseId,
            @QueryValue("userid") long userId
    );
}
