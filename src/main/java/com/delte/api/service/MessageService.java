package com.delte.api.service;

import com.delte.api.mapper.MessageDto;

import java.util.List;

public interface MessageService {
    MessageDto saveMessage(MessageDto messageDto);
    List<MessageDto> getAllMessages();
}
