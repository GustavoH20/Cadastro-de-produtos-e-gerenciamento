package com.produtoapi.projeto_springboot.client;

import com.produtoapi.projeto_springboot.model.ProdutoModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class JavaClient {
    private static final String BASE_URL = "http://localhost:8080/produtos";
    private RestTemplate restTemplate;

    public JavaClient() {
    }

    public JavaClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void listarTodos() {
        ResponseEntity<ProdutoModel[]> reponse = restTemplate.getForEntity(BASE_URL, ProdutoModel[].class);
        List<ProdutoModel> produtoModels = Arrays.asList(reponse.getBody());
        produtoModels.forEach(produtoModel ->
                System.out.println("ID: " + produtoModel.getId() +
                        "Nome: " + produtoModel.getNome() +
                        "Preço: " + produtoModel.getPreco() +
                        "Quantidade: " + produtoModel.getQuantidade() +
                        "Status: " + produtoModel.getStatus() +
                        "------------------------------------"
                ));
    }

    public ProdutoModel salvar(ProdutoModel produtoModel){
        HttpEntity<ProdutoModel> request = new HttpEntity<>(produtoModel);
        return restTemplate.postForObject(BASE_URL, request, ProdutoModel.class);
    }

    public void deletar(Long id){
        restTemplate.delete(BASE_URL + "/" + id);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel){
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ProdutoModel> request = new HttpEntity<>(produtoModel, headers);
        ResponseEntity<ProdutoModel> reponse = restTemplate.exchange(BASE_URL + "/" + id, HttpMethod.PUT, request, ProdutoModel.class);
        return reponse.getBody();
    }

    public ProdutoModel findById(Long id){
        ResponseEntity<ProdutoModel> response = restTemplate.getForEntity(BASE_URL + "/" + id, ProdutoModel.class);
        return response.getBody();
    }

    public static void main(String[] args) {
        JavaClient java = new JavaClient();

        ProdutoModel novoPrduto = new ProdutoModel();
        novoPrduto.setNome("iphone 13");
        novoPrduto.setPreco(5000.0);
        novoPrduto.setQuantidade(100);
        novoPrduto.setStatus("Diponivel");

        System.out.println("Criando novo produto");
        java.salvar(novoPrduto);
        java.listarTodos();

       /* ProdutoModel atualizarProduto = java.findById(x);
        atualizarProduto.setNome("testando 123");
        atualizarProduto.setPreco(100.90);

        java.listarT();

        */

       /* System.out.println("Deletar Produto");
        java.deletar(XXX);
        java.listarTodos();

        */
    }
}
