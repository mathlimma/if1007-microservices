
package com.if1007.kscore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pageable {
    private Long offset;
    private Boolean paged;
    private Sort sort;
    private Boolean unpaged;

    @JsonProperty("page_number")
    private Long pageNumber;
    @JsonProperty("page_size")
    private Long pageSize;
}
