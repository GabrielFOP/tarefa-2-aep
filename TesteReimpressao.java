import java.time.LocalDateTime;
import java.util.Scanner;

public class TesteReimpressao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha<Documento> pilha = new Pilha(15);

        while (scanner.hasNext()) {
            String linha = scanner.nextLine();
            if (linha.isBlank())
                continue; 
            int operacao = Integer.parseInt(linha.trim());

            switch (operacao) {
                case 1: // Solicitação de reimpressão
                    if (pilha.pilhaCheia()) {
                        System.out.println("Capacidade maxima da fila de impressao atingida!");
                        System.out.println();
                        scanner.nextLine();
                        scanner.nextLine();
                        scanner.nextLine(); 
                        
                    } else {
                        String nomeDoArquivo = scanner.nextLine();
                        String nomeUsuario = scanner.nextLine();
                        int horaEntrada = scanner.nextInt(); 

                        Documento doc = new Documento(nomeDoArquivo, nomeUsuario, horaEntrada);
                        pilha.push(doc);
                    }
                    break;

                case 2: // Reimpressão
                    if (!pilha.pilhaVazia()) {
                        LocalDateTime horarioImpressao = LocalDateTime.now();
                        long ini = System.nanoTime();
                        Documento imprimido = pilha.pop();
                        long fim = System.nanoTime();
                        long tempoEspera = (fim - ini) / 1000;

                        System.out.println("Imprimido arquivo de nome " + imprimido.getNome() + " do usuario " + imprimido.getUsuario());
                        System.out.println("Impressao inciada as: " + horarioImpressao + " com um tempo de espera de " + tempoEspera + "ms");
                        System.out.println();
                        
                    } else {
                        System.out.println("Pilha vazia. Nenhum documento para reimprimir.");
                        System.out.println();
                    }
                    break;

                case 3: // Consulta
                    if (scanner.hasNextLine()) {
                        String nomeDoArquivoConsulta = scanner.nextLine();
                        boolean encontrado = pilha.buscaPilha(nomeDoArquivoConsulta);
                        if (!encontrado) {
                            System.out.println("Documento nao encontrado na fila de impressao");
                            System.out.println();
                        }
                    }
                    break;

                default:
                    System.out.println("Operacao invalida.");
                    System.out.println();
            }

            System.out.println("Pilha atual: " + "\n" + pilha);
            System.out.println();

        }

        scanner.close();
    }
}
