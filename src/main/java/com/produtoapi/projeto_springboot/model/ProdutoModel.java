package com.produtoapi.projeto_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class ProdutoModel {

    //Gera id automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Não permite uma string vazia ou nula
    @NotEmpty(message = "Informe um nome")
    private String nome;

    private Integer quantidade;
    private Double preco;
    private String status;

    public ProdutoModel() {

    }
}
