package com.if1007.ksanalysis.service;

import com.if1007.ksanalysis.dto.Content;

import java.util.List;

public interface SearchService {
    List<Content> findByTitle(String title);
}
