package ru.practicum.shareit.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import ru.practicum.shareit.request.dto.ItemRequestDto;

class ItemRequestDtoTest {


    @Test
    void shouldImplementEqualsAndHashCodeBasedOnId() {
        // Given
        ItemRequestDto dto1 = new ItemRequestDto(1L, null, "Desc 1", "2023-01-01", null);
        ItemRequestDto dto2 = new ItemRequestDto(1L, null, "Desc 2", "2023-01-02", null);
        ItemRequestDto dto3 = new ItemRequestDto(2L, null, "Desc 1", "2023-01-01", null);

        // Then
        assertEquals(dto1, dto2); // Same ID
        assertNotEquals(dto1, dto3); // Different ID
        assertEquals(dto1.hashCode(), dto2.hashCode());
        assertNotEquals(dto1.hashCode(), dto3.hashCode());
    }

    @Test
    void shouldReturnToString() {
        // Given
        ItemRequestDto dto = new ItemRequestDto(1L, null, "Test description", "2023-01-01", null);

        // When
        String toString = dto.toString();

        // Then
        assertTrue(toString.contains("ItemRequestDto"));
        assertTrue(toString.contains("id=1"));
        assertTrue(toString.contains("description=Test description"));
    }

    @Test
    void shouldHandleNullItems() {
        // When
        ItemRequestDto dto = new ItemRequestDto(1L, null, "Test", "2023-01-01", null);

        // Then
        assertNotNull(dto);
        assertEquals(1L, dto.getId());
    }
}