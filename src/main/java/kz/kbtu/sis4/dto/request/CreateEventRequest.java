package kz.kbtu.sis4.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateEventRequest(
        @NotBlank(message = "Title is required")
        String title,

        @NotBlank(message = "Organizer email is required")
        @Email(message = "Organizer email must be valid")
        String organizerEmail,

        @NotNull(message = "Event date is required")
        LocalDateTime eventDate,

        @NotBlank(message = "Location is required")
        String location,

        @NotNull(message = "Ticket price is required")
        @Min(value = 0, message = "Ticket price must be >= 0")
        BigDecimal ticketPrice,

        @NotNull(message = "Age limit is required")
        @Min(value = 0, message = "Age limit must be >= 0")
        Integer ageLimit,

        String description
) {}
