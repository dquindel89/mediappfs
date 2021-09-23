package com.mitocode.controller;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Consulta;

import com.mitocode.service.IConsultaService;

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
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private IConsultaService service;

    @ApiOperation("Retorna una lista de especialidad")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Consulta>> listar(){
        List<Consulta> consulta = new ArrayList<>();
        consulta = service.listar();
        return   new ResponseEntity<List<Consulta>>(consulta, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Consulta>>  listarId(@PathVariable("id") Integer id){
        Optional<Consulta> consulta= service.listarId(id);
        if(consulta == null){
            throw new ModeloNotFoundException("ID :"+ id);
        }
        return  new ResponseEntity<Optional<Consulta>>(consulta,HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Consulta> registrar(@Valid @RequestBody Consulta consulta){
        Consulta cons = new Consulta();
        cons = service.registrar(consulta);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(cons.getIdConsulta()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@Valid @RequestBody Consulta consulta){
        service.modificar(consulta);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id) {
        Optional<Consulta> cons = service.listarId(id);
        if (cons == null) {
            throw new ModeloNotFoundException("ID :" + id);
        } else {
            service.eliminar(id);
        }
    }

}
