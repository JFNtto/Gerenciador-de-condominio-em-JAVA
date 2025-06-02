package Model;


public class Morador {
    private int id;
    private String nome;
    private String rg;
    private String cpf;
    private int moraNa;
    
    
    //construtores
    public Morador(){}

    public Morador(int id, String nome, String rg, String cpf, int moraNa) {
        this.id = id;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.moraNa = moraNa;
    }

    //gets e sets
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

    public int getMoraNa() {
        return moraNa;
    }

    public void setMoraNa(int moraNa) {
        this.moraNa = moraNa;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Morador{" + "id=" + id + ", nome=" + nome + ", rg=" + rg + ", cpf=" + cpf + ", moraNa=" + moraNa + '}';
    }
    
    
    
}
