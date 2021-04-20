package com.if1007.ksanalysis.service.impl;

import com.if1007.ksanalysis.dto.Content;
import com.if1007.ksanalysis.repository.KitRepository;
import com.if1007.ksanalysis.service.SearchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Slf4j
@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final KitRepository kitRepository;

    @Override
    public List<Content> findByName(String name){
        log.info("Iniciando busca no banco de dados");
        try {
            // todo: ir no banco e pegar todos os kits que contem o nome passado como param
            //kitRepository.findByName(name);
            return null;
        } catch (Exception e) {
            log.error("Erro ao se comunicar com banco de dados", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
