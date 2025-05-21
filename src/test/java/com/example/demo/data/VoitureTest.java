package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import  org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VoitureTest {

    @Test
    void creerVoiture(){
        Voiture v = new Voiture("BMW", 20000);
        Assert.isTrue(v.getMarque().equals("BMW"), "La marque doit être BMW");
        Assert.isTrue(v.getPrix() == 20000, "Le prix doit être 20000");
}
    @Test
    void idVoiture() {
        Voiture v1 = new Voiture();
        v1.setId(10);
        Assert.isTrue(v1.getId() == 10);
    }
    @Test
            void marqueVoiture(){
        Voiture v2 = new Voiture();
        v2.setId(10);
        Assert.isTrue(v2.getId() == 10, "l'id est de 10");
        v2.setMarque("Renault");
        Assert.isTrue(v2.getMarque() == "Renault", "la marque doit être renault");


    }
@Test
void testGetMarque() {
    Voiture voiture = new Voiture();
    voiture.setMarque("Renault");
    String marque = voiture.getMarque(); // Appel explicite
    Assert.isTrue("Renault".equals(marque), "La méthode getMarque doit retourner la valeur définie");
}

    @Test
    void testString() {
        // Création d'une voiture avec des valeurs spécifiques
        Voiture voiture = new Voiture("Tesla", 75000);
        voiture.setId(1);

        // Chaîne attendue correspondant à la méthode toString
        String expected = "Car{marque='Tesla', prix=75000, id=1}";

        // Vérification que toString retourne la chaîne attendue
        assertEquals(expected, voiture.toString(), "La méthode toString ne génère pas la chaîne attendue");
    }
}