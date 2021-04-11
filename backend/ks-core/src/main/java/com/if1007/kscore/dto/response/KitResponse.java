
package com.if1007.kscore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KitResponse {
    private List<Content> content;
    private Boolean empty;
    private Boolean first;
    private Boolean last;
    private Long number;
    private Pageable pageable;
    private Long size;
    private Sort sort;

    @JsonProperty("number_of_elements")
    private Long numberOfElements;
    @JsonProperty("total_elements")
    private Long totalElements;
    @JsonProperty("total_pages")
    private Long totalPages;
}
