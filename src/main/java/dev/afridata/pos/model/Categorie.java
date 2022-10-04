package dev.afridata.pos.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="p_capr")
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CA_PID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "CA_P_NOM")
    private String nom;
    @Column(name = "PRO_IMG")
    private String imageUrl;

    public Categorie(Long id, String nom, String imageUrl) {
        this.id = id;
        this.nom = nom;
        this.imageUrl = imageUrl;
    }

    public Categorie() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
