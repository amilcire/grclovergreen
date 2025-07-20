package br.com.sgv.repository;


import br.com.sgv.model.Usuario;
//import org.springframework.data.jpa.repository.Query;//
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Eric Lima 
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    // Buscar um usuário pelo login
    Usuario findByLogin(String login);
}

