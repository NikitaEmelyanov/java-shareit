package ru.practicum.shareit.item;

import java.util.Collection;
import ru.practicum.shareit.item.dto.CommentDto;
import ru.practicum.shareit.item.dto.ItemDto;
import ru.practicum.shareit.item.dto.NewCommentRequest;
import ru.practicum.shareit.item.dto.NewItemRequest;
import ru.practicum.shareit.item.dto.UpdateItemRequest;

public interface ItemService {

    ItemDto getItemById(long itemId);

    Collection<ItemDto> getItemsByOwnerId(long userId);

    Collection<ItemDto> getItemsByPattern(String pattern);

    ItemDto addItem(long userId, NewItemRequest newItemRequest);

    ItemDto updateItem(long userId, long itemId, UpdateItemRequest updateItemRequest);

    CommentDto addComment(NewCommentRequest newCommentRequest, long userId, long itemId);
}