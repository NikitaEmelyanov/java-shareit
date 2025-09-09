package ru.practicum.shareit.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import ru.practicum.shareit.request.model.ItemRequest;
import ru.practicum.shareit.user.model.User;

class ItemRequestTest {

    @Test
    void shouldCreateItemRequestWithAllFields() {
        // Given
        User user = new User(1L, "John Doe", "john@example.com");
        LocalDateTime created = LocalDateTime.of(2023, 1, 1, 10, 0);

        // When
        ItemRequest request = new ItemRequest(1L, user, "Need a drill", created);

        // Then
        assertEquals(1L, request.getId());
        assertEquals(user, request.getRequestor());
        assertEquals("Need a drill", request.getDescription());
        assertEquals(created, request.getCreated());
    }

    @Test
    void shouldCreateItemRequestWithNoArgsConstructor() {
        // When
        ItemRequest request = new ItemRequest();

        // Then
        assertNotNull(request);
    }

    @Test
    void shouldSetAndGetFields() {
        // Given
        ItemRequest request = new ItemRequest();
        User user = new User(2L, "Jane Smith", "jane@example.com");
        LocalDateTime created = LocalDateTime.of(2023, 1, 2, 12, 0);

        // When
        request.setId(2L);
        request.setRequestor(user);
        request.setDescription("Need a hammer");
        request.setCreated(created);

        // Then
        assertEquals(2L, request.getId());
        assertEquals(user, request.getRequestor());
        assertEquals("Need a hammer", request.getDescription());
        assertEquals(created, request.getCreated());
    }

    @Test
    void shouldImplementEqualsBasedOnId() {
        // Given
        ItemRequest request1 = new ItemRequest(1L, null, "Desc 1", null);
        ItemRequest request2 = new ItemRequest(1L, null, "Desc 2", null);
        ItemRequest request3 = new ItemRequest(2L, null, "Desc 1", null);

        // Then
        assertEquals(request1, request2); // Same ID
        assertNotEquals(request1, request3); // Different ID
        assertFalse(request1.equals(null)); // Not equal to null
        assertFalse(request1.equals(new Object())); // Not equal to different class
    }

    @Test
    void shouldImplementHashCodeBasedOnClass() {
        // Given
        ItemRequest request1 = new ItemRequest(1L, null, "Desc 1", null);
        ItemRequest request2 = new ItemRequest(1L, null, "Desc 2", null);

        // Then - hashCode is based on class, not fields
        assertEquals(request1.hashCode(), request2.hashCode());
    }

    @Test
    void shouldReturnToString() {
        // Given
        ItemRequest request = new ItemRequest(1L, null, "Test description", null);

        // When
        String toString = request.toString();

        // Then
        assertTrue(toString.contains("ItemRequest"));
        assertTrue(toString.contains("id=1"));
    }

    @Test
    void shouldHandleNullFields() {
        // When
        ItemRequest request = new ItemRequest();
        request.setId(1L);

        // Then
        assertEquals(1L, request.getId());
        assertEquals(null, request.getRequestor());
        assertEquals(null, request.getDescription());
        assertEquals(null, request.getCreated());
    }
}