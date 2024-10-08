package com.corhuila.BackendSQL.IRepository;

import com.corhuila.BackendSQL.Entity.Actividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActividadRepositorio extends JpaRepository<Actividad, Integer> {}
