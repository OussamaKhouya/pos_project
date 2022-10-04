package dev.afridata.pos.repo;

import dev.afridata.pos.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepo extends JpaRepository<Categorie, Long> {


    void deleteCategorieById(Long id);

    Optional<Categorie> findCategorieById(Long id);
}
