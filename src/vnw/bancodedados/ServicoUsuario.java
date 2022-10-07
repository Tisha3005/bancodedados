package vnw.bancodedados;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServicoUsuario {

    final BancoDados bancoDados;

    final InterfaceConsole console;

    public ServicoUsuario(BancoDados bancoDados, InterfaceConsole console) {
        this.console = console;
        this.bancoDados = bancoDados;
    }

    void cadastrarUsuario() {
        Usuario usuarioJaExistente;
        String nome;
        do {
            nome = console.perguntaTexto("Primeiro nome: ");
            usuarioJaExistente = bancoDados.buscaUsuarioPorNome(nome);
            if (usuarioJaExistente != null) {
                System.out.println("Já existe um usuário cadastrado com esse nome");
            }
        } while (usuarioJaExistente != null);
        final int idade = console.perguntaNumero("Idade: ");
        final Usuario usuario = new Usuario(nome, idade);
        bancoDados.inserirUsuario(usuario);
        System.out.printf("Usuário '%s' cadastrado com sucesso!\n", nome);
    }

    void detalharUsuario() {
        final String nome = console.perguntaTexto("Digite o nome do usuário: ");
        final Usuario usuario = bancoDados.buscaUsuarioPorNome(nome);
        if (usuario != null) {
            System.out.println("Usuário encontrado");
            System.out.println("\tnome:" + usuario.getNome());
            System.out.println("\tidade: " + usuario.getIdade());
        } else {
            System.out.printf("Usuário '%s' não encontrado\n", nome);
        }
    }

    void excluirUsuario() {
        final String nome = console.perguntaTexto("Nome do usuário para excluir: ");
        final Usuario usuario = bancoDados.buscaUsuarioPorNome(nome);
        if (usuario != null) {
            bancoDados.excluirUsuario(usuario);
            System.out.printf("Usuário '%s' excluido com sucesso", nome);
        } else {
            System.out.printf("Usuário '%s' não encontrado", nome);
        }
    }

    public void listarUsuarios() {
        final Map<String, String> opcoes = new HashMap<String, String>();
        opcoes.put("1", "sim");
        opcoes.put("2", "não");
        final String resposta = console.perguntaComEscolha("Voce quer listar apenas usuários maiores de idade?",
                opcoes);
        List<Usuario> usuarios = null;
        switch (resposta) {
            case "1":
                usuarios = bancoDados.buscaUsuariosMaioresIdade();
                break;
            case "2":
                usuarios = bancoDados.buscaTodosUsuarios();
                break;
        }

        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("Nenhum usuário encontrado");
        } else {
            System.out.println("nome\t\t| idade");
            for (Usuario usuario : usuarios) {
                System.out.printf("%s\t\t| %s\n", usuario.getNome(), usuario.getIdade());
            }
        }
    }
}