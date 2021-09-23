package com.mitocode.service.impl;

import com.mitocode.dao.IMedicoDao;
import com.mitocode.dao.IPacienteDao;
import com.mitocode.model.Medico;
import com.mitocode.model.Paciente;
import com.mitocode.service.IMedicoService;
import com.mitocode.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoServiceImpl implements IMedicoService {

    @Autowired
    private IMedicoDao dao;

    @Override
    public Medico registrar(Medico medico) {
        return dao.save(medico);
    }

    @Override
    public Medico modificar(Medico medico) {
        return dao.save(medico);
    }

    @Override
    public void eliminar(int id) {
        dao.deleteById(id);
    }

    @Override
    public Optional<Medico> listarId(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Medico> listar() {
        return dao.findAll();
    }
}
