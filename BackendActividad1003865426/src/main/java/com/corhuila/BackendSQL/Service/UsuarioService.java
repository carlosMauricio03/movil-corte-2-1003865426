package com.corhuila.BackendSQL.Service;

import com.corhuila.BackendSQL.Entity.Usuario;
import com.corhuila.BackendSQL.IRepository.IUsuarioRepositorio;
import com.corhuila.BackendSQL.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuarioRepositorio iUsuarioRepositorio;

    @Transactional
    @Override
    public List<Usuario> getAll() {
        return iUsuarioRepositorio.findAll();
    }

    @Transactional
    @Override
    public Optional<Usuario> findById(Integer id) {
        return iUsuarioRepositorio.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return iUsuarioRepositorio.save(usuario);
    }

    @Override
    public Usuario update(Integer idPerson, Usuario usuario) {
        Usuario existingUsuario = iUsuarioRepositorio.findById(idPerson).orElse(null);
        if (existingUsuario != null) {
            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setApellido(usuario.getApellido());
            existingUsuario.setCorreo(usuario.getCorreo());
            existingUsuario.setDireccion(usuario.getDireccion());
            existingUsuario.setTelefono(usuario.getTelefono());
            existingUsuario.setPassword(usuario.getPassword());
            return iUsuarioRepositorio.save(existingUsuario);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Usuario existingUsuario = iUsuarioRepositorio.findById(id).orElse(null);
        if (existingUsuario != null) {
            iUsuarioRepositorio.delete(existingUsuario);
            return true; // Eliminación exitosa
        }
        return false; // No se encontró la persona con el ID dado
    }
}
