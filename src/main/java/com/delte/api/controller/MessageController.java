package com.delte.api.controller;

import com.delte.api.mapper.MessageDto;
import com.delte.api.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<MessageDto> save(@RequestBody MessageDto messageDto) {
        return new ResponseEntity<>(messageService.saveMessage(messageDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MessageDto>> getAll() {
        return new ResponseEntity<>(messageService.getAllMessages(), HttpStatus.OK);
    }
}
