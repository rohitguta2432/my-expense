package com.delte.api.repository;

import com.delte.api.model.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Author rohit
 * @Date 07/09/21
 **/
@Repository
public interface AuthRepository extends JpaRepository<AuthToken, UUID> {
    AuthToken findByUserId(UUID userId);
}
