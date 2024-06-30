package com.forohub.controllers;


import com.forohub.dto.DatosActualizarTopicos;
import com.forohub.dto.DatosMostrarTopicos;
import com.forohub.dto.DatosRespuestaTopico;
import com.forohub.dto.DatosTopico;
import com.forohub.repository.RegistroTopicoRepository;
import com.forohub.topicos.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/topicos")
public class RegistroTopicoController {
    @Autowired
    private RegistroTopicoRepository registroTopicoRepository;


    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registraTopico(@RequestBody @Valid DatosTopico datosTopico, UriComponentsBuilder uriComponentsBuilder){
    Topico topico = registroTopicoRepository.save(new Topico(datosTopico));
    DatosRespuestaTopico datosRespuestaTopico = new  DatosRespuestaTopico(topico.getId(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo(),topico.getAutor(),topico.getFecha());
    URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
    return  ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public Page<DatosMostrarTopicos> listadoTopicos(@PageableDefault(size = 10, sort = "fecha") Pageable pageable){
        return registroTopicoRepository.findAll(pageable).map(DatosMostrarTopicos::new);
    }

    @GetMapping("/{id}")
    public DatosMostrarTopicos datosMostrarTopicos(@PathVariable Long id) {
        Topico topico = registroTopicoRepository.findById(id).get();
        return new DatosMostrarTopicos(topico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopicos datosActualizarTopicos) {
        Topico topico = registroTopicoRepository.findById(id).get();
        topico.actualizarDatos(datosActualizarTopicos);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(),topico.getMensaje(),topico.getNombreCurso(),topico.getTitulo(),topico.getAutor(),topico.getFecha()));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        if (registroTopicoRepository.existsById(id)) {
            registroTopicoRepository.deleteById(id);
        }
        return ResponseEntity.noContent().build();
    }

    }
