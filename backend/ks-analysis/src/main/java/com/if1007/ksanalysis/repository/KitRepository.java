package com.if1007.ksanalysis.repository;

import com.if1007.ksanalysis.entity.Kit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface KitRepository extends JpaRepository<Kit, Long> {
    @Query(value="SELECT k FROM Kit k WHERE k.title LIKE %:title% ")
    List<Kit> findByTitle(String title);

    @Query(value="SELECT k FROM Kit k WHERE k.description LIKE %:description% ")
    List<Kit> findByDescription(String description);
}
