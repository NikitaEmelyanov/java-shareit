package ru.practicum.shareit.item.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.practicum.shareit.booking.dto.LastBookingDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {

    private long id;
    private String name;
    private String description;
    private boolean available;
    private LastBookingDto lastBooking;
    private LastBookingDto nextBooking;
    private Long itemRequest;
    private Set<CommentDto> comments;
}