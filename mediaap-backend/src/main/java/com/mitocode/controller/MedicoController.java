package com.mitocode.controller;


import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Medico;

import com.mitocode.service.IMedicoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private IMedicoService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Medico>> listar(){
        List<Medico> medicos = new ArrayList<>();
        medicos = service.listar();
        return   new ResponseEntity<List<Medico>>(medicos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
   public ResponseEntity<Optional<Medico>>  listarId(@PathVariable("id") Integer id){
            Optional<Medico> medico= service.listarId(id);

        if(medico == null){
            throw new ModeloNotFoundException("ID :"+ id);
        }
            return  new ResponseEntity<Optional<Medico>>(medico,HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Medico> registrar(@Valid @RequestBody Medico medico){
        Medico med = new Medico();
        med = service.registrar(medico);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(med.getIdMedico()).toUri();

        return ResponseEntity.created(location).build();
    }



    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@Valid @RequestBody Medico medico){
        service.modificar(medico);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id){
        Optional<Medico> med = service.listarId(id);
        if(med == null){
             throw new ModeloNotFoundException("ID :"+ id);
        }else{
            service.eliminar(id);
        }

    }
}
