
package com.if1007.ksanalysis.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties
public class Content {
    private String description;
    private String id;
    private List<Question> questions;
    private List<Reference> references;
    private String tier;
    private String title;
    private String type;
    private Long version;

    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("updated_by")
    private String updatedBy;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("created_by")
    private String createdBy;
}
