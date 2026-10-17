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

        // Wrap the Publisher in a Mono to use .map()
        return Mono.from(rawJsonPublisher).map(jsonString -> {
            // === JSON processing with Jackson === //
            try {
                JsonNode root = objectMapper.readValue(jsonString, JsonNode.class);

                // The path: /usergrades/0/courseid --> int
                // FIXME (not sure): replace with `JsonNode.at()` method call
                JsonNode userGrades = root.get("usergrades");
                JsonNode userGradesFirstGrade = userGrades.get(0);
                JsonNode firstGradeCourseIdNode = userGradesFirstGrade.get("courseid");
                int extractedCourseId = firstGradeCourseIdNode.asInt();

                // === Return raw string === //
                return "ExtractedCourseId: " + extractedCourseId + "\n";

            } catch (JacksonException e) {
                return Utils.showError(e, "JSON processing exception");
            } catch (NullPointerException e) {
                return Utils.showError(e, "JSON null error");
            }
        });
    }
}
