package ru.practicum.shareit.booking;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Перечисление содержащие статусы бронирования
 */
@Getter
@AllArgsConstructor
public enum STATUS {
    WAITING("Новое бронирование, ожидает одобрения"),
    APPROVED("Бронирование подтверждено владельцем"),
    REJECTED("Бронирование отклонено владельцем"),
    CANCELED("Бронирование отменено создателем");

    private String description;
}
