package com.if1007.ksanalysis.controller;

import com.if1007.ksanalysis.dto.Content;
import com.if1007.ksanalysis.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.if1007.ksanalysis.PathsConstants.SEARCH_PATH;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(SEARCH_PATH)
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @GetMapping
    public ResponseEntity<List<Content>> searchKits(@RequestParam String title) {
        log.info("Nova requisição pesquisar todos os kits com nome: {}", title);
        var response = searchService.findByTitle(title);
        log.info("A consulta foi executada com sucesso");
        return ResponseEntity.ok(response);
    }


}
