package lt.viko.eif.controller;

import lt.viko.eif.service.GradeService;

import io.micronaut.http.annotation.*;
import io.micronaut.http.MediaType;
import reactor.core.publisher.Mono;

@Controller("/grades")
public class GradeController {
    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @Get("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Mono<String> getGrade(@PathVariable("id") long id) {
        return gradeService.getGradesData(id);
    }
}
