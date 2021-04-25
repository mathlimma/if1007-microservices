package com.if1007.ksanalysis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "tb_kits")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Kit {
    @Id
    private String id;

    @OneToMany
    @JoinColumn(name = "kit_id", nullable = false)
    private List<Question> questions;

    @OneToMany
    @JoinColumn(name = "kit_id", nullable = false)
    private List<Reference> references;

    private String description;
    private String tier;
    private String title;
    private String type;
    private Long version;
}
