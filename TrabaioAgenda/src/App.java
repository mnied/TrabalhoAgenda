package TrabaioAgenda.src;

import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws PilhaVaziaException {
        int opcao;
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("O que deseja fazer?" + 
                                "\n [1] Mostrar contatos" +
                                "\n [2] Adicionar contato" +
                                "\n [3] Alterar contato" +
                                "\n [4] Excluir contato" +
                                "\n [5] Desfazer última alteração" +
                                "\n [6] Sair");
            opcao = scanner.nextInt();
            switch(opcao) {
                case 1:
                    agenda.mostrarContatos();
                    break;
                case 2:
                    agenda.incluirContato();
                    break;
                case 3:
                    System.out.println("Informe o id do contato que deseja alterar: ");
                    agenda.alterarContato(scanner.nextInt());
                    break;
                case 4: 
                    System.out.println("Informe o id do contato que deseja excluir: ");
                    agenda.excluirContato(scanner.nextInt());
                    break;
                case 5:
                    System.out.println("Informe o id do contato que deseja desfazer a última alteração: ");
                    agenda.desfazerAlteracao(scanner.nextInt());
                    break;
            }
        } while (opcao != 6);
        System.out.println("Aplicativo finalizado.");
        scanner.close();
    }
}
