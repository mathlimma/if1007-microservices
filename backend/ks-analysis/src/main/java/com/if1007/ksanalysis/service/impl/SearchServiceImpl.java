package com.if1007.ksanalysis.service.impl;

import com.if1007.ksanalysis.dto.Content;
import com.if1007.ksanalysis.repository.KitRepository;
import com.if1007.ksanalysis.service.SearchService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final KitRepository kitRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Content> findByTitle(String title){
        log.info("Iniciando busca no banco de dados");
        try {
            var kits = kitRepository.findByTitle(title);

            var kitsDTO =  kits.stream()
                    .map(kit-> modelMapper.map(kit, Content.class))
                    .collect(Collectors.toList());
            log.info("kits retornados com sucesso");
            return kitsDTO;
        } catch (Exception e) {
            log.error("Erro ao se comunicar com banco de dados", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<Content> findByDescription(String description){
        log.info("Iniciando busca no banco de dados");
        try {
            var kits = kitRepository.findByDescription(description);

            var kitsDTO =  kits.stream()
                    .map(kit-> modelMapper.map(kit, Content.class))
                    .collect(Collectors.toList());
            log.info("kits retornados com sucesso");
            return kitsDTO;
        } catch (Exception e) {
            log.error("Erro ao se comunicar com banco de dados", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<Content> findByWord(String word) {
        var wordByTitle = findByTitle(word);
        var wordByDescription = findByDescription(word);

        wordByTitle.removeIf(k->wordByDescription.stream().anyMatch(t->k.getId().equals(t.getId())));

        wordByTitle.addAll(wordByDescription);

        return wordByTitle;
    }

}
