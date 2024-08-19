package be.jimsa.springtutorial.rest.controller;

import be.jimsa.springtutorial.rest.model.request.PersonRequest;
import be.jimsa.springtutorial.rest.model.response.PersonResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/person")
@CrossOrigin("*")
@Slf4j
public class PersonController {

    @GetMapping
    public ResponseEntity<List<PersonResponse>> getPeople() {
        List<PersonResponse> people = new ArrayList<>();
        people.add(new PersonResponse(
                1L, "jimsa", "salehi"
        ));
        return ResponseEntity.ok(people);
    }

    @GetMapping("/byRequestBodyAnnotation")
    public ResponseEntity<List<PersonResponse>> getByRequestBodyAnnotation(@RequestBody PersonRequest personRequest) {
        List<PersonResponse> people = new ArrayList<>();
        people.add(new PersonResponse(
                1L, personRequest.getFirstName(), personRequest.getLastName()
        ));
        return ResponseEntity.ok(people);
    }

    @PostMapping
    public ResponseEntity<PersonResponse> savePerson(
            @RequestHeader("invocationFrom") String invocationFrom,
            @Valid @RequestBody PersonRequest personRequest
    ) {
        log.info("Header invocationFrom = {}", invocationFrom);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("isSaved", "true")
                .body(new PersonResponse(
                        1L, personRequest.getFirstName(), personRequest.getLastName()
                ));
    }

    @DeleteMapping
    public ResponseEntity<PersonResponse> deletePerson(RequestEntity<PersonRequest> personRequestRequestEntity) {

        HttpHeaders headers = personRequestRequestEntity.getHeaders();
        headers.forEach(
                (key, value) -> log.info("Header '{}' = {}", key, String.join("|", value))
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new PersonResponse(
                        1L,
                        Objects.requireNonNull(personRequestRequestEntity.getBody()).getFirstName(),
                        Objects.requireNonNull(personRequestRequestEntity.getBody()).getFirstName()
                ));
    }

    @PatchMapping
    public ResponseEntity<PersonResponse> changeNumberTag(@RequestBody PersonRequest personRequest) {

        if (personRequest.getFirstName() == null ) {
            personRequest.setFirstName("jimsa5");
        }
        if (personRequest.getLastName() == null ) {
            personRequest.setLastName("salehi5");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new PersonResponse(
                        1L, personRequest.getFirstName(), personRequest.getLastName()
                ));
    }

}
