package lt.viko.eif.service;

import lt.viko.eif.Utils;
import lt.viko.eif.moodle_api.MoodleExternalApiClient;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@Singleton
public class GradeService {
    private final MoodleExternalApiClient apiClient;
    private final ObjectMapper objectMapper;

    public GradeService(MoodleExternalApiClient apiClient, ObjectMapper objectMapper) {
        this.apiClient = apiClient;
        this.objectMapper = objectMapper;
    }

    //
    // Extracts only specific JSON fields & data.
    //
    public Mono<String> getGradesData(long courseId) {
        Publisher<String> rawJsonPublisher = apiClient.getRawGradesDataForCourse(courseId);
        StringBuilder stringOutputBuilder = new StringBuilder();

        // Wrap the Publisher in a Mono to use .map()
        return Mono.from(rawJsonPublisher).map(jsonString -> {
            // === JSON processing with Jackson === //
            try {
                JsonNode root = objectMapper.readValue(jsonString, JsonNode.class);

                // The path: /usergrades/0/courseid --> int
                // FIXME (not sure): replace with `JsonNode.at()` method call

                // Iterate over array: /usergrades/
                JsonNode userGrades = root.get("usergrades");
                if (userGrades == null) {
                    return Utils.showStringError("JSON node \"usergrades\" is null. Processing stopped.");
                }

                int userGradeIndex = 0;
                for (JsonNode userGrade : userGrades) {
                    stringOutputBuilder.append("User grade ").append(userGradeIndex).append("\n");

                    JsonNode userGradeCourseId = userGrade.get("courseid");
                    JsonNode userGradeUserId = userGrade.get("userid");
                    JsonNode userGradeUserFullName = userGrade.get("userfullname");
                    // TODO: iterate over array: /usergrades/{i}/gradeitems

                    stringOutputBuilder.append("course_id: ").append(userGradeCourseId.asInt()).append("\n");
                    stringOutputBuilder.append("user_id: ").append(userGradeUserId.asInt()).append("\n");
                    stringOutputBuilder.append("user_full_name: ").append(userGradeUserFullName.asString()).append("\n");
                    stringOutputBuilder.append("\n");

                    userGradeIndex++;
                }

                // === Return raw string (content-type: text/plain) === //
                return stringOutputBuilder.toString();

            } catch (JacksonException e) {
                return Utils.showThrowableError(e, "JSON processing exception");
            } catch (NullPointerException e) {
                return Utils.showThrowableError(e, "JSON null error");
            }
        });
    }
}
