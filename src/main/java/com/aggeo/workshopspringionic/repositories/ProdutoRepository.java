package com.aggeo.workshopspringionic.repositories;

import com.aggeo.workshopspringionic.domain.Categoria;
import com.aggeo.workshopspringionic.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
