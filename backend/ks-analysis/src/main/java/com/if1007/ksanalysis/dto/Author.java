
package com.if1007.ksanalysis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Author {
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private String id;
    private String name;
}
