package com.delte.api.repository;

import com.delte.api.mapper.MessageDto;
import com.delte.api.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

    @Query("select new com.delte.api.mapper.MessageDto(m.messageId, m.user.userId, m.content, m.receivedAt, m.category) from Message m")
    List<MessageDto> findAllMessages();
}
