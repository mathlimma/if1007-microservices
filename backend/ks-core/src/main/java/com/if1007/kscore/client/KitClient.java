package com.if1007.kscore.client;

import com.if1007.kscore.dto.request.KitRequest;
import com.if1007.kscore.dto.response.Content;
import com.if1007.kscore.dto.response.KitResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "kits", url = "${api.strateegia.kits}")
public interface KitClient {
    @GetMapping
    KitResponse getAllKits(@RequestHeader("Authorization") String authorization);

    @GetMapping("{id}")
    Content getById(@RequestHeader("Authorization") String authorization, @PathVariable("id") String id);

    @PostMapping
    Content saveKit(@RequestHeader("Authorization") String authorization, @RequestBody KitRequest kitRequest);
}
