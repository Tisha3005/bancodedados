package vnw.bancodedados;

import java.util.ArrayList;
import java.util.List;

public abstract class BancoDadosAlunos implements BancoDados {
    public static List<Usuario> usuarios = new ArrayList<>();


    @Override
    public void inserirUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public Usuario buscaUsuarioPorNome(String nome) {
        // implemente a busca por nome, deve retornar null se não encontrar nada
        if (!usuarios.isEmpty()) {
            for (int i = 0; i < usuarios.size(); i++) {
                if (usuarios.get(i).nome.equals(nome)) {
                    return new Usuario(usuarios.get(i).nome, usuarios.get(i).idade);
                }
            }
        }
        return null;
    }

    @Override
    public void excluirUsuario(Usuario usuario) {
        // implemente a exclusão de um usuário
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).nome.equalsIgnoreCase(usuario.nome)){
                System.out.println(usuario.getNome());
                usuarios.remove(i);
            }
        }
    }

    // implemente a busca que retorna todos os usuarios
    @Override
    public List<Usuario> buscaTodosUsuarios() {
            return usuarios;
    }

    // implemente a busca que retorna apenas os usuarios com idade maior ou igual a 18 anos
    @Override
    public List<Usuario> buscaUsuariosMaioresIdade() {
        List<Usuario> usuariosMaiorIdade = new ArrayList<Usuario>();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).idade >= 18) {
                usuariosMaiorIdade.add(usuarios.get(i));
            }
        }
        return usuariosMaiorIdade;
    }
}