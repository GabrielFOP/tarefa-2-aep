import java.util.Objects;

public class Documento {
    private String nome;
    private String usuario;
    private int horaSolicitacao;

    public Documento(String nome, String usuario, int horaSolicitacao) {
        this.nome = nome;
        this.usuario = usuario;
        this.horaSolicitacao = horaSolicitacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setHoraSolicitacao(int horaSolicitacao) {
        this.horaSolicitacao = horaSolicitacao;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getHoraSolicitacao() {
        return horaSolicitacao;
    }

    @Override
    public String toString() {
        return "Documento [nome: " + nome + ", usuario: " + usuario + ", horaSolicitacao: " + horaSolicitacao + "]" + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Documento outro = (Documento) obj;

        return this.nome.equals(outro.nome) &&
                this.usuario.equals(outro.usuario) &&
                this.horaSolicitacao == outro.horaSolicitacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, usuario, horaSolicitacao);
    }

}
