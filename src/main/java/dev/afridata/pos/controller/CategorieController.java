package dev.afridata.pos.controller;

import dev.afridata.pos.model.Categorie;
import dev.afridata.pos.service.CategorieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieController {
    private final CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("all")
    public ResponseEntity<List<Categorie>> getAllCategories () {
        List<Categorie> categories = categorieService.findAllCategorie();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Categorie> getCategorieById (@PathVariable("id") Long id) {
        Categorie categorie = categorieService.findCategorieById(id);
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie) {
        Categorie newCategorie = categorieService.addCategorie(categorie);
        return new ResponseEntity<>(newCategorie, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie categorie) {
        Categorie updateCategorie = categorieService.updateCategorie(categorie);
        return new ResponseEntity<>(updateCategorie, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategorie(@PathVariable("id") Long id) {
        categorieService.deleteCategorie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
