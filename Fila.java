
public class Fila<T extends Comparable<T>> {
    T[] dados;
    int primeiro, ultimo, ocupacao;

    @SuppressWarnings("unchecked")
    public Fila(int capacidade) {
        dados = (T[]) new Comparable[capacidade];
        primeiro = 0;
        ultimo = 0;
        ocupacao = 0;
    }

    public Fila() {
        this(10);
    }

    public boolean filaVazia() {
        return ocupacao == 0;
    }

    public boolean filaCheia() {
        return ocupacao == dados.length;
    }

    private int proxima(int pos) {
        return (pos + 1) % dados.length;
    }

    public void enfileira(T e) {
        if (filaCheia())
            throw new RuntimeException("falha na insercao");
        dados[ultimo] = e;
        ultimo = proxima(ultimo);
        ocupacao++;
    }

    public T desenfileira() {
        if (filaVazia())
            throw new RuntimeException("falha na remocao");
        T temp = dados[primeiro];
        primeiro = proxima(primeiro);
        ocupacao--;
        return temp;
    }

    public boolean buscaDocumento(String nome) {
        for (int i = primeiro, cont = 0; cont < ocupacao; cont++) {
            Documento d = (Documento) dados[i];

            if (nome.compareTo(d.getNome()) == 0 ) {
                System.out.println("Documento encontrado na posicao " + i);
                System.out.println("Horario de solicitacao: " + d.getHoraSolicitacao());
                System.out.println("\n");
                return true;
            }

            i = proxima(i);
        }
        return false;
    }

    @Override
    public String toString() {
        if (filaVazia())
            return ("fila vazia");
        String s = "";
        for (int i = primeiro, cont = 0; cont < ocupacao; cont++) {
            s = s + dados[i] + " ";
            i = proxima(i);
        }
        return s;
    }

    public String stringVetor() {
        String s = "";
        if (filaVazia())
            for (int i = 0; i < dados.length; i++)
                s += "_ ";
        else if (filaCheia())
            for (int i = 0; i < dados.length; i++)
                s += dados[i] + " ";
        else if (primeiro < ultimo) {
            for (int i = 0; i < primeiro; i++)
                s += "_ ";
            for (int i = primeiro; i < ultimo; i++)
                s += dados[i] + " ";
            for (int i = ultimo; i < dados.length; i++)
                s += "_ ";
        } else {
            for (int i = 0; i < ultimo; i++)
                s += dados[i] + " ";
            for (int i = ultimo; i < primeiro; i++)
                s += "_ ";
            for (int i = primeiro; i < dados.length; i++)
                s += dados[i] + " ";
        }
        return s + "\n";
    }
}