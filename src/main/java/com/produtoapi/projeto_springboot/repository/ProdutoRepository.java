package com.produtoapi.projeto_springboot.repository;

import com.produtoapi.projeto_springboot.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

 List<ProdutoModel> findBynome(String nome);
 List<ProdutoModel> findByNomeContaining(String nome);
 List<ProdutoModel> findByNomeAndStatus(String nome, String Status);
 List<ProdutoModel> findByNomeStartingWith(String prefix);
 List<ProdutoModel> findByNomeEndingWith(String suffix);
}
