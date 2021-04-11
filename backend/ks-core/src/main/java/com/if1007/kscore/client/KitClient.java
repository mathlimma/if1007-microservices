package com.if1007.kscore.client;

import com.if1007.kscore.dto.response.KitResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "kits", url = "${api.strateegia.kits}")
public interface KitClient {
    @GetMapping
    KitResponse getAllKits(@RequestHeader("Authorization") String authorization, @RequestParam("paged") Boolean paged);
}
