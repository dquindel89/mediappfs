package com.mitocode.dao;

import com.mitocode.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConsultaDao extends JpaRepository<Consulta, Integer> {
}
