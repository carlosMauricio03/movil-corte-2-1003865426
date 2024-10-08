package com.corhuila.BackendSQL.Controller;

import com.corhuila.BackendSQL.Entity.Actividad;
import com.corhuila.BackendSQL.Service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actividad")
@CrossOrigin(origins = "*")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    @GetMapping
    public ResponseEntity<List<Actividad>> getAll() {
        List<Actividad> actividades = actividadService.getAll();
        return ResponseEntity.ok(actividades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actividad> findById(@PathVariable int id) {
        Optional<Actividad> actividad = actividadService.findById(id);
        return actividad.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Actividad> save(@RequestBody Actividad actividad) {
        Actividad savedActividad = actividadService.save(actividad);
        return ResponseEntity.ok(savedActividad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actividad> update(@PathVariable Integer id, @RequestBody Actividad actividad) {
        if (!id.equals(actividad.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Actividad updatedActividad = actividadService.update(id, actividad);
        return updatedActividad != null ? ResponseEntity.ok(updatedActividad) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean deleted = actividadService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}