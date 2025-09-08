package ru.practicum.shareit.request;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import ru.practicum.shareit.request.dto.NewItemRequest;

class NewItemRequestTest {

    @Test
    void shouldCreateNewItemRequestWithAllFields() {
        // When
        NewItemRequest request = new NewItemRequest("Need a power tool");

        // Then
        assertEquals("Need a power tool", request.getDescription());
    }

    @Test
    void shouldCreateNewItemRequestWithNoArgsConstructor() {
        // When
        NewItemRequest request = new NewItemRequest();

        // Then
        assertNotNull(request);
    }

    @Test
    void shouldSetAndGetDescription() {
        // Given
        NewItemRequest request = new NewItemRequest();

        // When
        request.setDescription("Updated description");

        // Then
        assertEquals("Updated description", request.getDescription());
    }

    @Test
    void shouldImplementDataAnnotation() {
        // Given
        NewItemRequest request1 = new NewItemRequest("Test");
        NewItemRequest request2 = new NewItemRequest("Test");

        // Then - @Data should generate equals, hashCode, toString
        assertEquals(request1, request2);
        assertEquals(request1.hashCode(), request2.hashCode());
        assertNotNull(request1.toString());
    }
}