package dio.my.web.aoi.repository;

import dio.my.web.aoi.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository


public class UsuarioRepository {
    public void save(Usuario usuario){
        if(usuario.getId()==null)
            System.out.println("SAVE - Recebendo o usuario na camada repositorio");
        else
            System.out.println("UPDATE - Recebendo o usuario na camada repositorio");
        System.out.println(usuario);
    }
    public void deleteById(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id para excluir um usuario"));
        System.out.println(id);
    }
    public List<Usuario> findAll(){
        System.out.println("LIST - Listando os usuarios do sistema");
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Augusto","password"));
        usuarios.add(new Usuario("Ricardo","passwordkey"));
        return usuarios;

    }
    public Usuario findById(Integer id){
        System.out.println(String.format("FIND - Recebendo o id para localizar um usuario"));
        return new Usuario("Augusto" , "password");

    }
    public Usuario findByUsername(String username){
        System.out.println(String.format("FIND/username - Recebendo o username: %d para o usuario"));
        return new Usuario("Augusto" , "password2");
    }
}
