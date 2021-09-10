package com.delte.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 09/08/21
 **/
@Data
@Entity
@Table(name = "expenses")
public class Expense implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID expenseId;

    private double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    private Date expenseDate;
}
