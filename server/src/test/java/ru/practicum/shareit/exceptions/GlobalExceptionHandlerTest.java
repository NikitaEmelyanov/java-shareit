package ru.practicum.shareit.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import jakarta.validation.ConstraintViolationException;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler gl;

    @BeforeEach
    void setUp() {
        gl = new GlobalExceptionHandler();
    }

    @Test
    void shouldHandleNotFoundException() {
        Map<String, String> response = gl.handleNotFoundException(
            new NotFoundException("Item not found"));

        assertEquals(HttpStatus.NOT_FOUND.value(), 404);
        assertTrue(response.containsKey("Not Found"));
        assertEquals("Item not found", response.get("Not Found"));
    }

    @Test
    void shouldHandleValidationException() {
        Map<String, String> response = gl.handleValidationExceptions(
            new ValidationException("Invalid data"));

        assertTrue(response.containsKey("Validation error"));
        assertEquals("Invalid data", response.get("Validation error"));
    }

    @Test
    void shouldHandleUnacceptableValueException() {
        Map<String, String> response = gl.handleUnacceptableUserException(
            new UnacceptableValueException("Access denied"));

        assertTrue(response.containsKey("Unacceptable value"));
        assertEquals("Access denied", response.get("Unacceptable value"));
    }

    @Test
    void shouldHandleConstraintViolationException() {
        Map<String, String> response = gl.handleConstraintViolationException(
            new ConstraintViolationException("Validation failed", null));

        assertTrue(response.containsKey("Validation errors"));
        assertNotNull(response.get("Validation errors"));
    }

    @Test
    void shouldHandleDataIntegrityViolationExceptionForEmailConflict() {
        DataIntegrityViolationException ex = new DataIntegrityViolationException(
            "ERROR: duplicate key value violates unique constraint \"users_email_key\"");

        ResponseEntity<Map<String, String>> response = gl.handleEmailConflict(ex);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertTrue(response.getBody().containsKey("error"));
        assertEquals("This email address is already registered.", response.getBody().get("error"));
    }

    @Test
    void shouldHandleDataIntegrityViolationExceptionForGenericViolation() {
        DataIntegrityViolationException ex = new DataIntegrityViolationException(
            "Some other constraint violation");

        ResponseEntity<Map<String, String>> response = gl.handleEmailConflict(ex);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertTrue(response.getBody().containsKey("error"));
        assertEquals("Data integrity violation.", response.getBody().get("error"));
    }

    @Test
    void shouldHandleInternalServerError() {
        Map<String, String> response = gl.handleInternalServerError(
            new RuntimeException("Unexpected error"));

        assertTrue(response.containsKey("Internal server error"));
        assertEquals("Unexpected error", response.get("Internal server error"));
    }

    // Дополнительные тесты для edge cases
    @Test
    void shouldHandleDataIntegrityViolationExceptionWithNullRootCause() {
        DataIntegrityViolationException ex = new DataIntegrityViolationException("Test error");
        // Создаем исключение без root cause
        DataIntegrityViolationException exWithoutRootCause = new DataIntegrityViolationException(
            "Test", ex);

        ResponseEntity<Map<String, String>> response = gl.handleEmailConflict(exWithoutRootCause);

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        assertTrue(response.getBody().containsKey("error"));
    }

    @Test
    void shouldHandleEmptyExceptionMessage() {
        Map<String, String> response = gl.handleInternalServerError(
            new RuntimeException(""));

        assertTrue(response.containsKey("Internal server error"));
        assertEquals("", response.get("Internal server error"));
    }
}