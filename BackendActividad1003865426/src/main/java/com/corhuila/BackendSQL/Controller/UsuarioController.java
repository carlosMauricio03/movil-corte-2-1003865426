package com.corhuila.BackendSQL.Controller;

import com.corhuila.BackendSQL.Entity.Usuario;
import com.corhuila.BackendSQL.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService personService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> usuarios = personService.getAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{idPerson}")
    public ResponseEntity<Usuario> findById(@PathVariable int idPerson) {
        Optional<Usuario> usuario = personService.findById(idPerson);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        Usuario savedUsuario = personService.save(usuario);
        return ResponseEntity.ok(savedUsuario);
    }

    @PutMapping("/{idPerson}")
    public ResponseEntity<Usuario> update(@PathVariable Integer idPerson, @RequestBody Usuario usuario) {
        if (!idPerson.equals(usuario.getId())) {
            return ResponseEntity.badRequest().build();
        }
        Usuario updatedUsuario = personService.update(idPerson, usuario);
        return updatedUsuario != null ? ResponseEntity.ok(updatedUsuario) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean deleted = personService.delete(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}