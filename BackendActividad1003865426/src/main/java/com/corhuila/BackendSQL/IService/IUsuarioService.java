package com.corhuila.BackendSQL.IService;

import com.corhuila.BackendSQL.Entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    List<Usuario> getAll();
    Optional<Usuario> findById(Integer id);
    Usuario save(Usuario usuario);
    Usuario update(Integer idPerson, Usuario usuario);
    boolean delete(Integer id);
}