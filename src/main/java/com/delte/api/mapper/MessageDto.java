package com.delte.api.mapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private UUID messageId;
    private UUID userId;
    private String content;
    private Date receivedAt;
    private String category;
}
