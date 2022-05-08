package TrabaioAgenda.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Agenda {

    private Map<Integer, Contato> agenda = new HashMap<Integer, Contato>();
    private int id = 0;

    public void incluirContato() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do contato: ");
        String nome = scanner.nextLine();

        System.out.println("Informe o telefone do contato: ");
        String tel = scanner.nextLine();

        System.out.println("Informe o e-mail do contato: ");
        String email = scanner.nextLine();

        id++;
        Contato contato = new Contato(nome, tel, email);
        contato.setId(id);
        agenda.put(id, contato);

        System.out.println("Contato salvo.");
    }    

    public void alterarContato(int id) {

        Contato contato = agenda.get(id);
        if(agenda.isEmpty()){
            System.out.println("A agenda está vazia.");
        }else if(contato == null){
            System.out.println("Registro não encontrado.");
        }
        else {
            Scanner scanner = new Scanner(System.in);
            Contato antigo = new Contato(contato);
            contato.push(antigo);
            System.out.println("Nome antigo: " + contato.getNome());
            System.out.println("Novo nome: ");
            contato.setNome(scanner.nextLine());
            System.out.println("Telefone antigo: " + contato.getTel());
            System.out.println("Novo telefone: ");
            contato.setTel(scanner.nextLine());
            System.out.println("Email antigo: " + contato.getEmail());
            System.out.println("Novo email: ");
            contato.setEmail(scanner.nextLine());
            System.out.println("Alteração concluída.");
        }
    }

    public void desfazerAlteracao(int id) throws PilhaVaziaException {

        Contato contato = agenda.get(id);
        if(agenda.isEmpty()){
            System.out.println("A agenda está vazia.");
        }else if(contato == null){
            System.out.println("Registro não encontrado.");
        }
        else {
            Contato antigo = contato.getLast();

            contato.setNome(antigo.getNome());
            contato.setTel(antigo.getTel());
            contato.setEmail(antigo.getEmail());

            System.out.println("Contato restaurado a versão anterior.");
        }
    }

    public void excluirContato(int id) {

        if(agenda.isEmpty()){
            System.out.println("A agenda está vazia.");
        }else if(agenda.get(id) == null){
            System.out.println("Registro não encontrado.");
        }else {
            agenda.remove(id);
            System.out.println("Contato excluído.");
        }
    }

    public void mostrarContatos() {
        if(agenda.isEmpty()){
            System.out.println("A agenda está vazia.");
        }else{
            for (int i = 1; i < id+1; i++) {
                System.out.println(agenda.get(i).toString());
            }
        }
    } 

}
