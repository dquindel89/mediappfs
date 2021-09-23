package com.mitocode.dao;

import com.mitocode.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteDao extends JpaRepository<Paciente,Integer> {
}
