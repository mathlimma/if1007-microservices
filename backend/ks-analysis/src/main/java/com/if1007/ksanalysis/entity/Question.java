
package com.if1007.ksanalysis.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_question")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    @Id
    private String id;

    private String question;
}
