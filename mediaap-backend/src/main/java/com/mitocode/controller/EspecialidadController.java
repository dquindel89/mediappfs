package com.mitocode.controller;

import com.mitocode.exception.ModeloNotFoundException;
import com.mitocode.model.Especialidad;
import com.mitocode.model.Medico;
import com.mitocode.service.IEspecialidadService;
import com.mitocode.service.IMedicoService;
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
@RequestMapping("/especialidad")
@Api(value = "Servicio REST para los especialidad")
public class EspecialidadController {
    @Autowired
    private IEspecialidadService service;

    @ApiOperation("Retorna una lista de especialidad")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Especialidad>> listar(){
        List<Especialidad> especialidad = new ArrayList<>();
        especialidad = service.listar();
        return   new ResponseEntity<List<Especialidad>>(especialidad, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Especialidad>>  listarId(@PathVariable("id") Integer id){
        Optional<Especialidad> especialidad= service.listarId(id);
        if(especialidad == null){
            throw new ModeloNotFoundException("ID :"+ id);
        }
        return  new ResponseEntity<Optional<Especialidad>>(especialidad,HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Especialidad> registrar(@Valid @RequestBody Especialidad especialidad){
        Especialidad esp = new Especialidad();
        esp = service.registrar(especialidad);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/{id}").buildAndExpand(esp.getIdEspecialidad()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> actualizar(@Valid @RequestBody Especialidad especialidad){
        service.modificar(especialidad);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void eliminar(@PathVariable Integer id){
        Optional<Especialidad> esp = service.listarId(id);
        if(esp == null){
            throw new ModeloNotFoundException("ID :"+ id);
        }else{
            service.eliminar(id);
        }

    }
}
