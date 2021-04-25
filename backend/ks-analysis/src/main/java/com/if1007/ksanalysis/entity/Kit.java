package com.if1007.ksanalysis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @OneToMany(mappedBy = "kit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Question> questions;

    @OneToMany(mappedBy = "kit", cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Reference> references;

    private String description;
    private String tier;
    private String title;
    private String type;
    private Long version;
}
