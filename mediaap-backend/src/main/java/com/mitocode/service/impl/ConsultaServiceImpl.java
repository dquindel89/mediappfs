package com.mitocode.service.impl;

import com.mitocode.dao.IConsultaDao;
import com.mitocode.model.Consulta;
import com.mitocode.service.IConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements IConsultaService {

    @Autowired
    private IConsultaDao dao;

    @Override
    public Consulta registrar(Consulta consulta) {
        return dao.save(consulta);
    }

    @Override
    public Consulta modificar(Consulta consulta) {
        return dao.save(consulta);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public Optional<Consulta> listarId(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Consulta> listar() {
        return dao.findAll();
    }
}
