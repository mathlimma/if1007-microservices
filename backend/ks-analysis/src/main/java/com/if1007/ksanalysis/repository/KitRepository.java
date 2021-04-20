package com.if1007.ksanalysis.repository;

import com.if1007.ksanalysis.dto.Content;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KitRepository extends JpaRepository<Content, Long> {

    Optional<List<Content>> findByName(String name);
}
