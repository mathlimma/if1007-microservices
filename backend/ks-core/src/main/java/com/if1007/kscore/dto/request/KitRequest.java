
package com.if1007.kscore.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KitRequest {
    private String description;
    private List<Question> questions;
    private List<Reference> references;
    private String tier;
    private String title;
    private String type;
}
