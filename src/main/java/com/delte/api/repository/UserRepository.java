package com.delte.api.repository;

import com.delte.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @Author rohit
 * @Date 07/09/21
 **/
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUserName(String userName);

}
