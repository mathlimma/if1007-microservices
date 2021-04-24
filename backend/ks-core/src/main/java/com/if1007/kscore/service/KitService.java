package com.if1007.kscore.service;

import com.if1007.kscore.context.IRequestContext;
import com.if1007.kscore.dto.request.KitRequest;
import com.if1007.kscore.dto.response.Content;
import com.if1007.kscore.dto.response.KitResponse;

public interface KitService {
    KitResponse getAll(IRequestContext context);
    Content getById(IRequestContext context, String id);
    Content saveKit(IRequestContext context, KitRequest kitRequest);
    void shareKit(IRequestContext context, String id);
    void deleteKit(String id);
}
