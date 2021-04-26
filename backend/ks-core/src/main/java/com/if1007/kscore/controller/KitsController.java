package com.if1007.kscore.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.if1007.kscore.context.IRequestContext;
import com.if1007.kscore.dto.request.KitRequest;
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

    @CrossOrigin
    @GetMapping
    public ResponseEntity<KitResponse> getAll(@RequestAttribute("context") IRequestContext context) {
        log.info("Nova requisição buscar todos os kits. Correlation ID: {}", context.getCorrelationId());
        var response = kitService.getAll(context);
        log.info("Kits encontrados com sucesso");
        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @GetMapping("{id}")
    public ResponseEntity<Content> getById(@RequestAttribute("context") IRequestContext context, @PathVariable("id") String kitId) {
        log.info("Nova requisição buscar kit por Id. Correlation ID: {}", context.getCorrelationId());
        var response = kitService.getById(context, kitId);
        log.info("Kit encontrado com sucesso");
        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @PostMapping("{id}")
    public ResponseEntity<?> shareKit(@RequestAttribute("context") IRequestContext context, @PathVariable("id") String kitId) {
        log.info("Nova requisição compartilhando o kit com Id: {}", kitId);
        kitService.shareKit(context, kitId);
        log.info("Kit compartilhado com sucesso");
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<?> saveKit(@RequestAttribute("context") IRequestContext context, @RequestBody KitRequest kitRequest) throws JsonProcessingException {
        log.info("Nova requisição salvando o kit compartilhado");
        var response = kitService.saveKit(context, kitRequest);
        log.info("Kit salvo com sucesso");
        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteKit(@PathVariable("id") String kitId) {
        log.info("Nova requisição deletando o kit com Id: {}", kitId);
        kitService.deleteKit(kitId);
        log.info("Kit deletado com sucesso");
        return ResponseEntity.ok().build();
    }

}
