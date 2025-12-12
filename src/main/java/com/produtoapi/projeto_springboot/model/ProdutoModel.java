package com.produtoapi.projeto_springboot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class ProdutoModel {

    //Gera id automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Não permite uma strig vazia ou nula
    @NotEmpty(message = "Informe um nome")
    private String nome;

    private Integer quantidade;
    private Double preco;
    private String status;

    public ProdutoModel() {
    }

    public ProdutoModel(String nome, Integer quantidade, Double preco, String status) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
