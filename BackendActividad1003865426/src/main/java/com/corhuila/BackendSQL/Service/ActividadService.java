package com.corhuila.BackendSQL.Service;

import com.corhuila.BackendSQL.Entity.Actividad;
import com.corhuila.BackendSQL.IRepository.IActividadRepositorio;
import com.corhuila.BackendSQL.IService.IActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadService implements IActividadService {
    @Autowired
    private IActividadRepositorio iActividadRepositorio;

    @Override
    @Transactional
    public List<Actividad> getAll() {
        return iActividadRepositorio.findAll();
    }

    @Override
    @Transactional
    public Optional<Actividad> findById(Integer id) {
        return iActividadRepositorio.findById(id);
    }

    @Override
    public Actividad save(Actividad actividad) {
        return iActividadRepositorio.save(actividad);
    }

    @Override
    public Actividad update(Integer id, Actividad actividad) {
        Actividad existingActividad = iActividadRepositorio.findById(id).orElse(null);
        if (existingActividad != null) {
            existingActividad.setNombre(actividad.getNombre());
            existingActividad.setCodigo(actividad.getCodigo());
            return iActividadRepositorio.save(existingActividad);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (iActividadRepositorio.existsById(id)) {
            iActividadRepositorio.deleteById(id);
            return true;
        }
        return false;
    }
}