public class Documento implements Comparable<Documento>{
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
        return "Documento [nome: " + nome + ", usuario: " + usuario + ", horaSolicitacao: " + horaSolicitacao + "]";
    }


    @Override
    public int compareTo(Documento outroDocumento){
        return this.nome.compareTo(outroDocumento.nome); 
    }



}
