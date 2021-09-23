package com.mitocode.controller;



import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Paciente;
import com.mitocode.service.IPacienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/pacientes")
@Api(value = "Servicio REST para los pacientes")
public class PacienteController {

    @Autowired
    private IPacienteService service;

    @ApiOperation("Retorna una lista de pacientes")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Paciente>> listar(){
        List<Paciente> pacientes = new ArrayList<>();
        pacientes = service.listar();
        return   new ResponseEntity<List<Paciente>>(pacientes, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Paciente>>  listarId(@PathVariable("id") Integer id){
            Optional<Paciente> paciente= service.listarId(id);
        if(paciente == null){
            throw new ModeloNotFoundException("ID :"+ id);
        }
            return  new ResponseEntity<Optional<Paciente>>(paciente,HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Paciente> registrar(@Valid @RequestBody Paciente paciente){
        Paciente pac = new Paciente();
        pac = service.registrar(paciente);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(pac.getIdPaciente()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@Valid @RequestBody Paciente paciente){
        service.modificar(paciente);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id){
        Optional<Paciente> pac = service.listarId(id);
        if(pac == null){
             throw new ModeloNotFoundException("ID :"+ id);
        }else{
            service.eliminar(id);
        }

    }
}
