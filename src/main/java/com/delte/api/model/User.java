package com.delte.api.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 08/08/21
 **/
@Data
@Entity
@Table(name="users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String mobile;
    private String email;
    private String firstName;
    private String lastName;

}
