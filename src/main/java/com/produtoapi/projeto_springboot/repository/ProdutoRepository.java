package com.produtoapi.projeto_springboot.repository;

import com.produtoapi.projeto_springboot.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
