
package com.if1007.ksanalysis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Agreement {

    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("user_id")
    private String userId;

}
