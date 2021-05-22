package com.moloucars.moloucars.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moloucars.moloucars.Model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

}
