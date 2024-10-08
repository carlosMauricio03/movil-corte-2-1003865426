package com.corhuila.BackendSQL.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 25, unique = false)
    private String nombre;

    @Column(nullable = false, length = 25, unique = false)
    private String apellido;

    @Column(nullable = false, length = 25, unique = false)
    private String correo;

    @Column(nullable = false, length = 25, unique = false)
    private String direccion;

    @Column(nullable = false, length = 14, unique = false)
    private String telefono;

    @Column(nullable = false, length = 25, unique = false)
    private String password;

    @OneToMany
    private Actividad actividades;
}