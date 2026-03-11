package kz.kbtu.sis4.service;

import kz.kbtu.sis4.dto.request.CreateEventRequest;
import kz.kbtu.sis4.dto.request.UpdateEventRequest;
import kz.kbtu.sis4.dto.response.EventResponse;
import kz.kbtu.sis4.entity.Event;
import kz.kbtu.sis4.exception.ResourceNotFoundException;
import kz.kbtu.sis4.mapper.EventMapper;
import kz.kbtu.sis4.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    @Override
    public EventResponse create(CreateEventRequest request) {
        log.info("Creating event with title='{}", request.title());
        log.debug("CreateEventRequest payload: {}", request);

        Event event = eventMapper.toEntity(request);
        Event saved = eventRepository.save(event);

        log.info("Event created successfully with id={}", saved.getId());
        return eventMapper.toResponse(saved);
    }

    @Override
    public List<EventResponse> getAll() {
        log.info("Fetching all events");

        return eventRepository
                .findAll()
                .stream()
                .map(eventMapper::toResponse)
                .toList();
    }

    @Override
    public EventResponse getById(Long id) {
        log.info("Fetching event by id={}", id);

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id=" + id));

        return eventMapper.toResponse(event);
    }

    @Override
    public EventResponse update(Long id, UpdateEventRequest request) {
        log.info("Updating event with id={}", id);
        log.debug("UpdateEventRequest payload: {}", request);

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id=" + id));

        eventMapper.updateEntity(request, event);
        Event updated = eventRepository.save(event);

        log.info("Event updated successfully with id={}", updated.getId());
        return eventMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting event with id={}", id);

        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found with id=" + id));

        eventRepository.delete(event);
        log.info("Event deleted successfully with id={}", id);
    }
}
