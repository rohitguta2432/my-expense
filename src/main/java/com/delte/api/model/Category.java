package com.delte.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * @Author rohit
 * @Date 09/08/21
 **/
@Data
@Entity
@Table(name = "categorys")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID categoryId;
    private String name;
    private UUID parentId;
    private String description;
    private UUID userId;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id",
            foreignKey = @ForeignKey(name = "fk_category_expense"))
    @JsonIgnore
    List<Expense> expenses;

}
