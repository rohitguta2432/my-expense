package com.delte.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 07/09/21
 **/
@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "auth_token")
public class AuthToken implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID authId;
    private String token;
    private UUID userId;

}
