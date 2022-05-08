package TrabaioAgenda.src;

public class Contato {

    private int id;
    private String nome;
    private String tel;
    private String email;
    private final Contato[] historico;

    public Contato(String nome, String tel, String email) {
        this.nome = nome;
        this.tel = tel;
        this.email = email;
        this.historico = new Contato[1];
    }

    public Contato(Contato contato) {
        this.id = contato.getId();
        this.nome = contato.getNome();
        this.tel = contato.getTel();
        this.email = contato.getEmail();
        this.historico = new Contato[1];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contato getHistorico() {
        return historico[0];
    }

    public void push(Contato contato) {

        historico[0] = contato;
    }

    public Contato getLast() throws PilhaVaziaException {
        if (historico[0] == null) {
            throw new PilhaVaziaException();
        }

        Contato contato = historico[0];
        historico[0] = null;

        return contato;
    }

    @Override
    public String toString() {
        return "Contato" +
            "\n Id:" + id +
            "\n Nome: " + nome +
            "\n Telefone: " + tel +
            "\n Email: " + email;
    }
    
}
