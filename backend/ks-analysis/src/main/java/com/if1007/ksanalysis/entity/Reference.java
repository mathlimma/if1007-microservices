package com.if1007.ksanalysis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Table(name = "tb_reference")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="kit_id")
    private Kit kit;

    private String description;
    private String url;
}
