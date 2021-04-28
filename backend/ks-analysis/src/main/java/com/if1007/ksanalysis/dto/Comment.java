
package com.if1007.ksanalysis.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Comment {

    private Boolean active;
    private List<Agreement> agreements;
    private Author author;
    @JsonProperty("content_id")
    private String contentId;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("created_by")
    private String createdBy;
    private String id;
    @JsonProperty("parent_id")
    private String parentId;
    @JsonProperty("question_id")
    private String questionId;
    private List<Object> replies;
    @JsonProperty("reply_count")
    private Long replyCount;
    private String text;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("updated_by")
    private String updatedBy;
    private Long version;


}
