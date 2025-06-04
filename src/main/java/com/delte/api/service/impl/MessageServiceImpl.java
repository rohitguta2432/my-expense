package com.delte.api.service.impl;

import com.delte.api.mapper.MessageDto;
import com.delte.api.model.Message;
import com.delte.api.repository.MessageRepository;
import com.delte.api.repository.UserRepository;
import com.delte.api.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public MessageDto saveMessage(MessageDto messageDto) {
        log.info("save message : {}", messageDto);
        Message message = new Message();
        if (!ObjectUtils.isEmpty(messageDto.getMessageId())) {
            message = messageRepository.findById(messageDto.getMessageId()).orElse(new Message());
        }
        message.setContent(messageDto.getContent());
        message.setReceivedAt(messageDto.getReceivedAt());
        message.setCategory(categorize(messageDto.getContent()));
        if (!ObjectUtils.isEmpty(messageDto.getUserId())) {
            userRepository.findById(messageDto.getUserId()).ifPresent(message::setUser);
        }
        Message saved = messageRepository.save(message);
        messageDto.setMessageId(saved.getMessageId());
        messageDto.setCategory(saved.getCategory());
        return messageDto;
    }

    @Override
    public List<MessageDto> getAllMessages() {
        return messageRepository.findAllMessages();
    }

    private String categorize(String text) {
        if (text == null) {
            return "OTHER";
        }
        String lower = text.toLowerCase();
        if (lower.contains("spent") || lower.contains("paid") || lower.contains("debited")) {
            return "EXPENSE";
        } else if (lower.contains("credited")) {
            return "INCOME";
        }
        return "OTHER";
    }
}
