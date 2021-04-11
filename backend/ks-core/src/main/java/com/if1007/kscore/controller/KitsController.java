package com.if1007.kscore.controller;

import com.if1007.kscore.context.IRequestContext;
import com.if1007.kscore.dto.response.Content;
import com.if1007.kscore.dto.response.KitResponse;
import com.if1007.kscore.service.KitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.if1007.kscore.PathsConstants.KITS_PATH;

@Slf4j
@RestController
@RequestMapping(KITS_PATH)
@RequiredArgsConstructor
public class KitsController {

    private final KitService kitService;

    @GetMapping
    public ResponseEntity<KitResponse> getAll(@RequestAttribute("context") IRequestContext context){
        log.info("Nova requisição buscar todos os kits. Correlation ID: {}", context.getCorrelationId());
        var response = kitService.getAll(context);
        log.info("Kits encontrados com sucesso");
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<Content> getById(@RequestAttribute("context") IRequestContext context, @PathVariable("id") String kitId){
        log.info("Nova requisição buscar kit por Id. Correlation ID: {}", context.getCorrelationId());
        var response = kitService.getById(context, kitId);
        log.info("Kit encontrado com sucesso");
        return ResponseEntity.ok(response);
    }

}
