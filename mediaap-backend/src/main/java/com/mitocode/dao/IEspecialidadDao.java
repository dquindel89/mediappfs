package com.mitocode.dao;

import com.mitocode.model.Especialidad;
import com.mitocode.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEspecialidadDao extends JpaRepository<Especialidad,Integer> {
}
