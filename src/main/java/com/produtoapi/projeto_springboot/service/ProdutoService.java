package com.produtoapi.projeto_springboot.service;

import com.produtoapi.projeto_springboot.model.ProdutoModel;
import com.produtoapi.projeto_springboot.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> listarTodos() {
        return produtoRepository.findAll();
    }

    public ProdutoModel salvar(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel) {
        if (produtoRepository.existsById(id)) {
            produtoModel.setId(id);
            return produtoRepository.save(produtoModel);
        } else {
            throw new RuntimeException(("Produto não encontrado"));
        }
    }

    public Optional<ProdutoModel> finfById(Long id) {
        return produtoRepository.findById(id);
    }

    public List<ProdutoModel> salvarLista(List<ProdutoModel> produtoModels) {
        return produtoRepository.saveAll(produtoModels);
    }

    public List<ProdutoModel> findBynome(String nome) {
        return produtoRepository.findBynome(nome);
    }

    public List<ProdutoModel> findByNomeContainig(String nome) {
        return produtoRepository.findByNomeContaining(nome);
    }

    public List<ProdutoModel> findByNomeAndStatus(String nome, String status) {
        return produtoRepository.findByNomeAndStatus(nome, status);
    }

    public List<ProdutoModel> findByNomeStartingWith(String prefix){
        return produtoRepository.findByNomeStartingWith(prefix);
    }

    public List<ProdutoModel> findByNomeEndingWith(String suffix){
        return produtoRepository.findByNomeEndingWith(suffix);
    }

    public List<ProdutoModel> findByPreco(Double preco){
        return produtoRepository.findByPreco(preco);
    }

    public List<ProdutoModel> findByPrecoGreaterThan(Double preco){
        return produtoRepository.findByPrecoGreaterThan(preco);
    }

    public List<ProdutoModel> findByPrecoLessThan(Double preco){
        return produtoRepository.findByPrecoLessThan(preco);
    }

    public Double buscarTotalPreco(){
        return produtoRepository.findTotalPreco();
    }
}
