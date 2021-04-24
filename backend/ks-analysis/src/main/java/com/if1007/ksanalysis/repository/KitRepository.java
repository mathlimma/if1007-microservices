package com.if1007.ksanalysis.repository;

import com.if1007.ksanalysis.entity.Kit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KitRepository extends JpaRepository<Kit, Long> {
    Optional<List<Kit>> findByTitle(String title);
}
