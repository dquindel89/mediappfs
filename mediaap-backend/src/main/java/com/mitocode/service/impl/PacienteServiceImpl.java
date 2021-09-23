package com.mitocode.service.impl;

import com.mitocode.dao.IPacienteDao;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteDao dao;

    @Override
    public Paciente registrar(Paciente paciente) {
        return dao.save(paciente);
    }

    @Override
    public Paciente modificar(Paciente paciente) {
        return dao.save(paciente);
    }

    @Override
    public void eliminar(int id) {
        //dao.delete
        dao.deleteById(id);
    }



    @Override
    public Optional<Paciente> listarId(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Paciente> listar() {
        return dao.findAll();
    }
}
