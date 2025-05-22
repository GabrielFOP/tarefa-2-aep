public class Pilha<T extends Comparable<T>> {
    private int topo;
    private T[] dados;

    public Pilha() {
        this(10);

    }

    @SuppressWarnings("unchecked")
    public Pilha(int capacidade) {
        topo = 0;
        dados = (T[]) new Comparable[capacidade];

    }

    public boolean pilhaVazia() {
        return topo == 0;
    }

    public boolean pilhaCheia() {
        return topo == dados.length;
    }

    public boolean push(T elemento) {
        if (pilhaCheia()) {
            return false;
        }
        dados[topo++] = elemento;
        return true;

    }

    public T pop() {
        if (pilhaVazia()) {
            throw new RuntimeException("Pilha vazia, falha na remocao");
        }
        return dados[--topo];
    }

    public T peak() {
        if (pilhaVazia()) {
            throw new RuntimeException("Pilha vazia, sem elementos para verificar");
        }
        return dados[topo - 1];
    }

    public boolean buscaPilha(String nome) {
        Documento docBusca = new Documento(nome, "", 0);
        for (int i = topo - 1; i >= 0; i--) {
            T elemento = dados[i];

            if (elemento.compareTo((T) docBusca) == 0) {
                System.out.println("Documento encontrado na posicao " + i);
                if (elemento instanceof Documento d) {
                    System.out.println("Horario de solicitacao: " + d.getHoraSolicitacao());
                }
                System.out.println("\n");
                return true;
            }
        }

        return false;
    }
}
