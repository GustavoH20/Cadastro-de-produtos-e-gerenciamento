
package com.produtoapi.projeto_springboot.controllerswagger;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exemplo" )
@Tag(name = "Produtos API", description = "Operações de exemplo para demonstração do OpenAPI")
public class ControllerSwagger {

    @Operation(summary = "Seja Bem vindo(a)", description = "Endpoint simples para testar a documentação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem-sucedida",
                    content = @Content(mediaType = "text/plain", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida")
    })
    @GetMapping("/saudacao")
    public ResponseEntity<String> getSaudacao(
            @Parameter(description = "Nome da pessoa a ser saudada", required = true)
            @RequestParam String nome) {
        return ResponseEntity.ok("Olá, " + nome + "! Sua API está documentada com OpenAPI.");
    }

    @Operation(summary = "Cria um novo item", description = "Demonstra um método POST com corpo de requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados do item inválidos")
    })
    @PostMapping("/item")
    public ResponseEntity<String> createItem(@RequestBody String item) {
        // Lógica para criar o item...
        return ResponseEntity.status(201).body("Item criado: " + item);
    }
}
