package vnw.bancodedados;

public class Usuario {

    final String nome;

    final int idade;

    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    int getIdade() {
        return idade;
    }
}