package ru.practicum.shareit.request.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import ru.practicum.shareit.item.dto.ItemDtoAnswer;
import ru.practicum.shareit.user.dto.UserDto;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class ItemRequestDto {

    private Long id;
    private UserDto requestor;
    private String description;
    private String created;
    private Set<ItemDtoAnswer> items;
}