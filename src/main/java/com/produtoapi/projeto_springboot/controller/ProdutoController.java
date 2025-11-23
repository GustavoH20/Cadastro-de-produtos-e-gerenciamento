package com.produtoapi.projeto_springboot.controller;

import com.produtoapi.projeto_springboot.model.ProdutoModel;
import com.produtoapi.projeto_springboot.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoModel> listarTodos() {
        return produtoService.listarTodos();
    }

    @PostMapping
    public ProdutoModel salvar(@RequestBody ProdutoModel produtoModel) {
        return produtoService.salvar(produtoModel);
    }

    @PutMapping("{id}")
    public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        return produtoService.atualizar(id,produtoModel);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id){
        produtoService.deletar(id);
    }

    @GetMapping("{id}")
    public Optional<ProdutoModel> finfById(@PathVariable Long id){
        return produtoService.finfById(id);
    }

    @PostMapping("/salvarLista")
    public List<ProdutoModel> salvarLista(@RequestBody List<ProdutoModel> produtoModels){
        return produtoService.salvarLista(produtoModels);
    }
}
