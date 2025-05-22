import java.time.LocalDateTime;
import java.util.Scanner;

public class TesteImpressao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila<Documento> impressora = new Fila<>(15);

        while (scanner.hasNext()) {
            String linha = scanner.nextLine();
            if (linha.isBlank())
                continue; 
            int operacao = Integer.parseInt(linha.trim());

            switch (operacao) {
                case 1: // Entrada de documento na fila
                    if (impressora.filaCheia()) {
                        System.out.println("Capacidade maxima da fila de impressao atingida!");
                        System.out.println();
                        scanner.nextLine();
                        scanner.nextLine(); 
                        scanner.nextLine(); 
                    } else {
                        String nomeDoArquivo = scanner.nextLine();
                        String nomeUsuario = scanner.nextLine();
                        int horaEntrada = scanner.nextInt();
                        scanner.nextLine(); 

                        Documento doc = new Documento(nomeDoArquivo, nomeUsuario, horaEntrada);
                        impressora.enfileira(doc);
                    }
                    break;

                case 2: // Imprimir documento (desenfileira)
                    if (!impressora.filaVazia()) {
                        LocalDateTime horarioImpressao = LocalDateTime.now();

                        long ini = System.nanoTime();

                        Documento imprimido = impressora.desenfileira();
                        System.out.println("Impressao do arquivo de nome " + imprimido.getNome() + " do usuario " + imprimido.getUsuario());

                        long fim = System.nanoTime();
                        long tempoEspera = (fim - ini) / 1000;

                        System.out.println("Impressao inciada as: " + horarioImpressao + " com um tempo de espera de " + tempoEspera + "ms");
                        System.out.println();

                    } else {
                        System.out.println("Fila vazia. Nenhum documento para imprimir.");
                        System.out.println();
                    }
                    break;

                case 3: // Consulta documento na fila
                    if (scanner.hasNextLine()) {
                        String nomeDoArquivoConsulta = scanner.nextLine();
                        boolean encontrado = impressora.buscaDocumento(nomeDoArquivoConsulta);
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

            System.out.println("Fila atual: " + "\n" + impressora);
            System.out.println();
        }

        scanner.close();
    }
}
