package com.corhuila.BackendSQL.IService;

import com.corhuila.BackendSQL.Entity.Actividad;

import java.util.List;
import java.util.Optional;

public interface IActividadService {
    List<Actividad> getAll();
    Optional<Actividad> findById(Integer id);
    Actividad save(Actividad actividad);
    Actividad update(Integer id, Actividad actividad);
    boolean delete(Integer id);
}