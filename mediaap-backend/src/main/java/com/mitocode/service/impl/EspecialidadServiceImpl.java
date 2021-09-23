package com.mitocode.service.impl;

import com.mitocode.dao.IEspecialidadDao;

import com.mitocode.model.Especialidad;

import com.mitocode.service.IEspecialidadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

    @Autowired
    private IEspecialidadDao dao;

    @Override
    public Especialidad registrar(Especialidad especialidad) {
        return dao.save(especialidad);
    }

    @Override
    public Especialidad modificar(Especialidad especialidad) {
        return dao.save(especialidad);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public Optional<Especialidad> listarId(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Especialidad> listar() {
        return dao.findAll();
    }
}
