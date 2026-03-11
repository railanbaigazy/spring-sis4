package kz.kbtu.sis4.mapper;

import kz.kbtu.sis4.dto.request.CreateEventRequest;
import kz.kbtu.sis4.dto.request.UpdateEventRequest;
import kz.kbtu.sis4.dto.response.EventResponse;
import kz.kbtu.sis4.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventMapper {
    Event toEntity(CreateEventRequest request);

    EventResponse toResponse(Event event);

    void updateEntity(UpdateEventRequest request, @MappingTarget Event event);
}
