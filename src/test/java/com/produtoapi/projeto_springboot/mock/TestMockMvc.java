package com.produtoapi.projeto_springboot.mock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestMockMvc {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnDefaultMessageForGetSudacao() throws Exception {

        //Executa a requisição GET
        mockMvc.perform(get("api/v1/saudacao")
                        .param("nome", "Teste")) // Adiciona o parametro nome

                //Verifica o status da resposta
                .andExpect(status().isOk())

                //Verifica o conteudo da resposta
                .andExpect((ResultMatcher) content().string("Olá, testando"));

    }

    @Test
    void shouldReturnCreatedStatusForCreateItem() throws Exception {
        String itemJson = "Novo Item de Teste";

        // 1. Executa a requisição POST
        mockMvc.perform(post("/api/v1/exemplo/item")
                        .contentType(MediaType.APPLICATION_JSON) // Define o tipo de conteúdo
                        .content(itemJson)) // Define o corpo da requisição

                // 2. Verifica o status da resposta
                .andExpect(status().isCreated())

                // 3. Verifica o conteúdo da resposta
                .andExpect((ResultMatcher) content().string("Item criado: Novo Item de Teste"));
    }


}

