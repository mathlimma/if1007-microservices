package com.if1007.kscore.context.impl;

import com.if1007.kscore.context.IRequestContext;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class RequestContext implements IRequestContext {
    private String correlationId;
}
