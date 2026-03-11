package kz.kbtu.sis4.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventResponse(
        Long id,
        String title,
        String organizerEmail,
        LocalDateTime eventDate,
        String location,
        BigDecimal ticketPrice,
        Integer ageLimit,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}
