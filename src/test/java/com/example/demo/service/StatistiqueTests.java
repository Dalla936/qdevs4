package com.example.demo.service;

import com.example.demo.data.Voiture;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import static org.mockito.Mockito.*;


@SpringBootTest
public class StatistiqueTests {

    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Test
    void avecMockBean() throws Exception{
        Voiture voiture = mock(Voiture.class); //mock sert à créer une copie d'un objet sans dépendances
        Voiture voiture2 = mock(Voiture.class);
        statistiqueImpl.ajouter(voiture);
        statistiqueImpl.ajouter(voiture2);
        when(voiture.getMarque()).thenReturn("BMW"); //on impose BMW
        when(voiture.getPrix()).thenReturn(1000); //si on appelle getPrix pour voiture, return = 1000
        when(voiture2.getMarque()).thenReturn("Renault");
        when(voiture2.getPrix()).thenReturn(2000);

        Echantillon emock = mock(Echantillon.class); //un mock de l'echantillon pour
        when(emock.getNombreDeVoitures()).thenReturn(2);
        when(emock.getPrixMoyen()).thenReturn(1500);


        when(statistiqueImpl.prixMoyen()).thenReturn(emock);
        Assert.isTrue(voiture2.getMarque()=="Renault", "la marque de la deuxième voiture est Renault");


    }

}
