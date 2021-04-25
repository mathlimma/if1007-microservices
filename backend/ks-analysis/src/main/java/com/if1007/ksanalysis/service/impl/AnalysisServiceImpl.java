package com.if1007.ksanalysis.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.if1007.ksanalysis.dto.Content;
import com.if1007.ksanalysis.entity.Kit;
import com.if1007.ksanalysis.repository.KitRepository;
import com.if1007.ksanalysis.service.AnalysisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnalysisServiceImpl implements AnalysisService {

    private final ObjectMapper mapper;
    private final KitRepository kitRepository;
    private final ModelMapper modelMapper;

    @Override
    public String analyseSharedKit(String content) {
        log.info("Iniciando analise de kit");
        try {
            var dto = mapper.readValue(content, Content.class);
            log.info("Analizando kit com id: {}", dto.getId());
            var entity = modelMapper.map(dto, Kit.class);
            kitRepository.save(entity);
            log.info("kit salvo com sucesso!");
            return "O processo finalizou com sucesso!";
        } catch (Exception e) {
            log.error("Erro ao se comunicar com ks-core", e);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
