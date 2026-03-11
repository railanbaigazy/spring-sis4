package kz.kbtu.sis4.controller;

import jakarta.validation.Valid;
import kz.kbtu.sis4.dto.request.CreateEventRequest;
import kz.kbtu.sis4.dto.request.UpdateEventRequest;
import kz.kbtu.sis4.dto.response.EventResponse;
import kz.kbtu.sis4.service.EventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
@Slf4j
public class EventController {
    @Autowired
    private final EventService eventService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponse create(@Valid @RequestBody CreateEventRequest request) {
        log.debug("POST /api/events called");
        return eventService.create(request);
    }

    @GetMapping
    public List<EventResponse> getAll() {
        log.debug("GET /api/events called");
        return eventService.getAll();
    }

    @GetMapping("/{id}")
    public EventResponse getById(@PathVariable Long id) {
        log.debug("GET /api/events/{} called", id);
        return eventService.getById(id);
    }

    @PutMapping("/{id}")
    public EventResponse update(@PathVariable Long id, @Valid @RequestBody UpdateEventRequest request) {
        log.debug("PUT /api/events/{} called", id);
        return eventService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        log.debug("DELETE /api/events/{} called", id);
        eventService.delete(id);
    }
}
