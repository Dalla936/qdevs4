
package com.example.demo.data;

import  org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.*;

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
    }
    @Test
            void marqueVoiture(){
        Voiture v2 = new Voiture();
        Assert.isTrue(v2.getId() == 10, "l'id est de 10");
        v2.setMarque("Renault");
        Assert.isTrue(v2.getMarque() == "Renault", "la marque doit être renault");


    }

}
