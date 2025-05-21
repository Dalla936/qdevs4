package com.example.demo.web;

import com.example.demo.data.Voiture;
import com.example.demo.service.Echantillon;
import com.example.demo.service.StatistiqueImpl;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebTests {
    @MockBean
    StatistiqueImpl statistiqueImpl;

    @Autowired
    MockMvc mockMvc;


    @Test
    void ajouterVoiture() throws Exception {
        mockMvc.perform(post("/voiture")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"marque\": \"Ferrari\", \"prix\": 5000 }")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testPageAccueil() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Bienvenue sur le site de statistiques"));
    }


    @Test
    void testPrixMoyen() throws Exception {
        when(statistiqueImpl.prixMoyen()).thenReturn(new Echantillon(1,5000));
        mockMvc.perform(get("/statistique")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.nombreDeVoitures").value(1))
                .andExpect(jsonPath("$.prixMoyen").value(5000))
                .andReturn();
    }
}
