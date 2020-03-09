package com.example.stefaniProekt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Data
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int categoryid;
    private String name;
    @ManyToOne(targetEntity = Category.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JoinColumn(name="supercategory_id")
    private Category parent;
}
