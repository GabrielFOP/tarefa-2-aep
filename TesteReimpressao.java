import java.time.LocalDateTime;
import java.util.Scanner;

public class TesteReimpressao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pilha<Documento> impressora = new Pilha();

        while (scanner.hasNext()) {
            int operacao = scanner.nextInt();
            scanner.nextLine();

            switch (operacao) {
                case 1: // Solicitacao reimpressao 

                    if (impressora.pilhaCheia()) {
                        System.out.println("Capacidade maxima da fila de impressao atingida!");
                        System.out.println("\n");
                        scanner.nextLine(); 
                        scanner.nextLine();

                    } else {
                        String nomeDoArquivo = scanner.nextLine();
                        String nomeUsuario = scanner.nextLine();
                        int horaEntrada = scanner.nextInt();
                        scanner.nextLine();

                        impressora.push(new Documento(nomeDoArquivo, nomeUsuario, horaEntrada));
                    }

                    break;

                case 2: // Execução de Reimpressão:
                    LocalDateTime horarioImpressao = LocalDateTime.now();

                    long ini = System.nanoTime();

                    Documento imprimido = impressora.pop();
                    System.out.println("Imprimido arquivo de nome " + imprimido.getNome() + " do usuario "
                            + imprimido.getUsuario());

                    long fim = System.nanoTime();

                    long tempoEspera = fim - ini;

                    System.out.println("Impressao inciada as: " + horarioImpressao + " com um tempo de espera de "
                            + tempoEspera/1000 + "ms");

                    System.out.println("\n");

                    break;

                case 3: // consulta documento
                     String nomeDoArquivo = scanner.nextLine();

                     Boolean consulta = impressora.buscaPilha(nomeDoArquivo); 

                     if(!consulta){
                        System.out.println("Documento nao encontrado na fila de impressao");
                        System.out.println("\n");
                     }

                    break;

            }

            scanner.nextLine(); 
            System.out.println("Fila atual: " + "\n" + impressora);
            System.out.println("\n");

        }

        scanner.close();
    }
}
