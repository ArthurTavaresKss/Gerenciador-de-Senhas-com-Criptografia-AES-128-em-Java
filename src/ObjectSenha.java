
public class ObjectSenha {
    private String nome, senha;

    // Construtor
    public ObjectSenha(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    // Set nome
    public void setNome(String nome) {this.nome = nome;}
    // Get nome
    public String getNome() {return nome;}

    // Set senha
    public void setSenha(String senha) {this.senha = senha;}
    // Get senha
    public String getSenha() {return senha;}

}
