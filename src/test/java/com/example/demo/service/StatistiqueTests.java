package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    StatistiqueImpl statistiqueImpl = new StatistiqueImpl();

    @Test
    void avecMockBean() throws Exception{
        Voiture voiture = mock(Voiture.class); //mock sert à créer une copie d'un objet sans dépendances
        Voiture voiture2 = mock(Voiture.class);



        when(voiture.getMarque()).thenReturn("BMW"); //on impose BMW, ..
        when(voiture.getPrix()).thenReturn(1000); //si on appelle getPrix pour voiture, return = 1000

        when(voiture2.getMarque()).thenReturn("Renault"); //when pour les mocks, explique les comportements futures
        when(voiture2.getPrix()).thenReturn(2000);

        statistiqueImpl.ajouter(voiture);
        statistiqueImpl.ajouter(voiture2);

        Echantillon e1 = statistiqueImpl.prixMoyen(); //on ne mock pas echantillon car il return le prix moyen, stats car il return le new echantillon
        assertEquals(e1.getNombreDeVoitures(),2);
        assertEquals(e1.getPrixMoyen(),1500);


    }

}
