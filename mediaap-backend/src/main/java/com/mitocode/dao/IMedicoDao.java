package com.mitocode.dao;

import com.mitocode.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoDao extends JpaRepository<Medico,Integer> {
}
