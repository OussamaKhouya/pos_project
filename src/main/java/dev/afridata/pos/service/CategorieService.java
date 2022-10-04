package dev.afridata.pos.service;

import dev.afridata.pos.exception.CategorieNotFoundException;
import dev.afridata.pos.model.Categorie;
import dev.afridata.pos.repo.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CategorieService {

    private final CategorieRepo categorieRepo;

    @Autowired
    public CategorieService(CategorieRepo categorieRepo) {
        this.categorieRepo = categorieRepo;
    }


    public Categorie addCategorie(Categorie cat) {
        cat.setNom(UUID.randomUUID().toString());
        return categorieRepo.save(cat);
    }

    public List<Categorie> findAllCategorie() {
        return categorieRepo.findAll();
    }

    public Categorie updateCategorie(Categorie cat) {
        return categorieRepo.save(cat);
    }

    public Categorie findCategorieById(Long id) {
        return categorieRepo.findCategorieById(id)
                .orElseThrow(() -> new CategorieNotFoundException("Categorie by id " + id + "was not found"));
    }

    public void deleteCategorie(Long id) {
        categorieRepo.deleteCategorieById(id);
    }


}
