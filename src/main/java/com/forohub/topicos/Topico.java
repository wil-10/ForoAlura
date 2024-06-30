package com.forohub.topicos;

import com.forohub.dto.DatosActualizarTopicos;
import com.forohub.dto.DatosTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String mensaje;
 private String nombreCurso;
 private String titulo;
 private LocalDateTime fecha;
 private String status;
 private String autor;

 public Long getId() {
  return id;
 }

 public String getMensaje() {
  return mensaje;
 }

 public String getNombreCurso() {
  return nombreCurso;
 }

 public String getTitulo() {
  return titulo;
 }

 public LocalDateTime getFecha() {
  return fecha;
 }

 public String getStatus() {
  return status;
 }

 public String getAutor() {
  return autor;
 }

 public Topico(DatosTopico datosTopico) {
  this.mensaje = datosTopico.mensaje();
  this.nombreCurso = datosTopico.nombreCurso();
  this.titulo = datosTopico.titulo();
  this.autor = datosTopico.autor();
 }

 @PrePersist
 protected void fechaStatus() {
  this.fecha = LocalDateTime.now();
  if (this.status == null) {
   this.status = "ACTIVO";
  }
 }

 public void actualizarDatos(DatosActualizarTopicos datosActualizarTopicos) {
  if (datosActualizarTopicos.mensaje() != null){
   this.mensaje = datosActualizarTopicos.mensaje();
  }
  if (datosActualizarTopicos.nombreCurso() != null){
   this.nombreCurso = datosActualizarTopicos.nombreCurso();
  }
  if (datosActualizarTopicos.titulo() != null){
   this.titulo = datosActualizarTopicos.titulo();
  }
  if (datosActualizarTopicos.autor() != null){
   this.autor = datosActualizarTopicos.autor();
  }

 }
}