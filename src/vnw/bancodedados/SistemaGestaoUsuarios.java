package vnw.bancodedados;

import java.util.HashMap;
import java.util.Map;

    public class SistemaGestaoUsuarios {

        final InterfaceConsole console;

        final ServicoUsuario servicoUsuario;

        final BancoDados bancoDados;

        public SistemaGestaoUsuarios() {
            this.console = new InterfaceConsole();
            this.bancoDados = new BancoDadosAlunos() {};
            this.servicoUsuario = new ServicoUsuario(bancoDados, console);
        }

        public static void main(String[] args) {
            final SistemaGestaoUsuarios sistema = new SistemaGestaoUsuarios();
            sistema.executar();
        }

        void executar() {
            Map<String, String> opcoesMenu = new HashMap<String, String>();
            opcoesMenu.put("1", "cadastrar usuário");
            opcoesMenu.put("2", "mostrar detalhes de um usuário");
            opcoesMenu.put("3", "remover usuário");
            opcoesMenu.put("4", "listar todos usuários");
            opcoesMenu.put("5", "sair do programa");

            String resposta;
            do {
                console.exibirTitulo("Sistema de gestão de usuários");
                resposta = console.perguntaComEscolha("O que você deseja fazer?", opcoesMenu);
                console.pulaLinhas(2);
                switch (resposta) {
                    case "1":
                        console.exibirTitulo("Cadastrar usuário");
                        servicoUsuario.cadastrarUsuario();
                        break;
                    case "2":
                        console.exibirTitulo("Detalhar usuário");
                        servicoUsuario.detalharUsuario();
                        break;
                    case "3":
                        console.exibirTitulo("Excluir usuário");
                        servicoUsuario.excluirUsuario();
                        break;
                    case "4":
                        console.exibirTitulo("Listar usuários");
                        servicoUsuario.listarUsuarios();
                }
                console.pulaLinhas(2);
            } while (!resposta.equals("5"));
            System.out.println("Obrigado por usar o sistema de gestão de usuários versão 1.0");
        }

    }