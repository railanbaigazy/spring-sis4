package kz.kbtu.sis4.service;

import kz.kbtu.sis4.dto.request.CreateEventRequest;
import kz.kbtu.sis4.dto.request.UpdateEventRequest;
import kz.kbtu.sis4.dto.response.EventResponse;

import java.util.List;

public interface EventService {
    EventResponse create(CreateEventRequest request);

    List<EventResponse> getAll();

    EventResponse getById(Long id);

    EventResponse update(Long id, UpdateEventRequest request);

    void delete(Long id);
}
