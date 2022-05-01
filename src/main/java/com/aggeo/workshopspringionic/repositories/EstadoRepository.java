package com.aggeo.workshopspringionic.repositories;

import com.aggeo.workshopspringionic.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
