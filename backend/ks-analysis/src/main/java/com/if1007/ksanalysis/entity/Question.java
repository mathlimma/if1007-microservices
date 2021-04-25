
package com.if1007.ksanalysis.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Table(name = "tb_question")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    private String id;

    private String question;

    @ManyToOne
    @JoinColumn(name="kit_id")
    private Kit kit;
}
