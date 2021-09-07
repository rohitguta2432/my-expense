package com.delte.api.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 08/08/21
 **/
@Data
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID userId;
    private String mobile;
    private String userName;
    private String password;
    private String authority;
    private String email;
    private String firstName;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_expense"))
    List<Expense> expenses;

}
