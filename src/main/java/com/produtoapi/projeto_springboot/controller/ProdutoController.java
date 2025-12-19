package com.produtoapi.projeto_springboot.controller;

import com.produtoapi.projeto_springboot.model.ProdutoModel;
import com.produtoapi.projeto_springboot.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/produtos")
public class ProdutoController  {

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
    public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel produtoModel) {
        return produtoService.atualizar(id, produtoModel);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }

    @GetMapping("{id}")
    public Optional<ProdutoModel> findById(@PathVariable Long id) {
        return produtoService.finfById(id);
    }

    @PostMapping("/salvarLista")
    public List<ProdutoModel> salvarLista(@RequestBody List<ProdutoModel> produtoModels) {
        return produtoService.salvarLista(produtoModels);
    }

    @GetMapping("/buscarPorNome")
    public List<ProdutoModel> buscarPorNome(@RequestParam String valor) {
        return produtoService.findBynome(valor);
    }

    @GetMapping("/buscarPorNomeContendo")
    public List<ProdutoModel> buscarPorNomeContendo(@RequestParam String valor) {
        return produtoService.findByNomeContainig(valor);
    }

    @GetMapping("/buscarPorNomeEStatus")
    public List<ProdutoModel> buscarPorNomeEStatus(@RequestParam String nome, @RequestParam String status) {
        return produtoService.findByNomeAndStatus(nome, status);
    }

    @GetMapping("/buscarPorNomeComecandoCom")
    public List<ProdutoModel> buscarPorNomeComecandoCom(@RequestParam String valor){
        return produtoService.findByNomeEndingWith(valor);
    }

    @GetMapping("/buscarPorNomeTerminandoCom")
    public List<ProdutoModel> buscarPorNomeTerminandoCom(@RequestParam String valor){
        return produtoService.findByNomeStartingWith(valor);
    }

    @GetMapping("/buscarPorPreco")
    public List<ProdutoModel> buscarPorPreco(@RequestParam Double valor){
        return produtoService.findByPreco(valor);
    }

    @GetMapping("/buscarPorPrecoMaiorQue")
    public List<ProdutoModel> buscarPorPrecoMaiorQue(@RequestParam Double valor){
        return produtoService.findByPrecoGreaterThan(valor);
    }

    @GetMapping("/buscarPorPrecoMenorQue")
    public List<ProdutoModel> buscarPorPrecoMenorQue(@RequestParam Double valor){
        return produtoService.findByPrecoLessThan(valor);
    }

    @GetMapping("/buscarTotalPreco")
    public Double buscarTotalPreco(){
        return produtoService.buscarTotalPreco();
    }

    @GetMapping("/buscarPorQuantidade")
    public List<ProdutoModel> buscarPorQuantidade(@RequestParam Integer valor){
        return produtoService.findByQuantidade(valor);
    }

    @GetMapping("/buscarPorQuantidadeMenorQue")
    public List<ProdutoModel> buscarQuantidadeMenorQue(@RequestParam Integer valor){
        return produtoService.findByQuantidadeLessThan(valor);
    }

    @GetMapping("/buscarPorQuantidadeMaiorQue")
    public List<ProdutoModel> buscarPorQuantidadeMaiorQue(@RequestParam Integer valor){
        return produtoService.findByQuantidadeGreateThan(valor);
    }

    @GetMapping("/buscarPorStatus")
    public List<ProdutoModel> buscarPorStatua(@RequestParam(required = false) String valor){
        return produtoService.findByStatus(valor);
    }

    @GetMapping("/buscarPorStatusNulos")
    public List<ProdutoModel> buscarPorStatusNulos(){
        return produtoService.findByStatusIsNull();
    }

    @GetMapping("/buscarPorPrecoEStatus")
    public List<ProdutoModel> buscarPorPrecoEStatus(@RequestParam Double preco, @RequestParam String status){
        return produtoService.findByPrecoAndStatus(preco, status);
    }

    @GetMapping("/contarTotalDeProdutos")
    public Long contarTotalDeProdutos(){
        return produtoService.count();
    }

    //Se não passar nada, volta todos os produtos com status padrão, neste caso será "DISPONIVEL"
    @GetMapping("/buscarPorStatusPadrao")
    public List<ProdutoModel> buscarPorStatusPadrao(@RequestParam (defaultValue = "Disponível") String valor){
        return produtoService.findByStatus(valor);
    }
}
