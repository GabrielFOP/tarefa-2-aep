import java.time.LocalDateTime;
import java.util.Scanner;

public class TesteImpressao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila<Documento> impressora = new Fila<>(15);

        while (scanner.hasNext()) {
            int operacao = scanner.nextInt();
            scanner.nextLine();

            switch (operacao) {
                case 1: // Entrada documento

                    if (impressora.filaCheia()) {
                        System.out.println("Capacidade máxima da fila de impressao atingida!");
                        System.out.println("\n");
                    } else {
                        String nomeDoArquivo = scanner.nextLine();
                        String nomeUsuario = scanner.nextLine();
                        int horaEntrada = scanner.nextInt();
                        scanner.nextLine();

                        impressora.enfileira(new Documento(nomeDoArquivo, nomeUsuario, horaEntrada));
                    }

                    break;

                case 2: // Imprime documento
                    LocalDateTime horarioImpressao = LocalDateTime.now();

                    long ini = System.nanoTime();

                    Documento imprimido = impressora.desenfileira();
                    System.out.println("Imprimido arquivo de nome " + imprimido.getNome() + " do usuario "
                            + imprimido.getUsuario());

                    long fim = System.nanoTime();

                    long tempoEspera = fim - ini;

                    System.out.println("Impressão inciada as: " + horarioImpressao + " com um tempo de espera de "
                            + tempoEspera/1000 + "ms");

                    System.out.println("\n");

                    break;

                case 3: // consulta documento
                     String nomeDoArquivo = scanner.nextLine();
                     String nomeUsuario = scanner.nextLine();

                     impressora.buscaDocumento(nomeDoArquivo, nomeUsuario); 

                    break;

            }

            scanner.nextLine(); 
            System.out.println("Fila atual: " + impressora);
            System.out.println("\n");

        }

        scanner.close();
    }
}
