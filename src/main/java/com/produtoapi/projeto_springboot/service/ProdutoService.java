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

    public List<ProdutoModel> salvarLista(List<ProdutoModel> produtoModels){
        return produtoRepository.saveAll(produtoModels);
    }
}
