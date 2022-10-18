package vnw.bancodedados;

import java.util.List;

public interface BancoDados {

    void inserirUsuario(Usuario usuario);

    Usuario buscaUsuarioPorNome(String nome);

    void excluirUsuario(Usuario usuario);

    List<Usuario> buscaTodosUsuarios();

    List<Usuario> buscaUsuariosMaioresIdade();

}