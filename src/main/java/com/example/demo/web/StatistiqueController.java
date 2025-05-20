package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.Statistique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatistiqueController {

    @Autowired
    Statistique statistique;

    @GetMapping(value = "/statistique")
    public Echantillon getStatistiques() throws PasDeVoitureException {
        try{
            return statistique.prixMoyen();
        } catch (ArithmeticException e) {
            throw new PasDeVoitureException();
        }

    }
    @GetMapping(value ="/")
    public String getStatistique(){
        return "Bienvenue sur le site de statistiques";
    }

    @PostMapping("/voiture")
    public void creerVoiture(@RequestBody Voiture voiture){
        statistique.ajouter(voiture);
    }

}
