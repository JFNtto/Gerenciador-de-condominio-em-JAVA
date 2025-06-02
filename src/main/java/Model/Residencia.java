
package Model;


public class Residencia {
    private int numero;
    private String rua;
    private String cep;
    private int dono;

    
    
    
    
    //construtores
    public Residencia() {
    }

    public Residencia(int numero, String rua, String cep, int dono) {
        this.numero = numero;
        this.rua = rua;
        this.cep = cep;
        this.dono = dono;
    }

    
    //gets e sets
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getDono() {
        return dono;
    }

    public void setDono(int dono) {
        this.dono = dono;
    }
    
    
    
}
