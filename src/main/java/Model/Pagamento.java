package Model;

import java.time.LocalDate;


public class Pagamento {
    
    private int id;
    private int residencia_id;
    private String mes;
    private int ano;
    private boolean pago;
    private LocalDate data_pagamento;
    private PagamentoStrategy estrategia;
    
    public Pagamento() {
   
    }

    public Pagamento(int id, int residencia_id, String mes, int ano, boolean pago, LocalDate data_pagamento) {
        this.id = id;
        this.residencia_id = residencia_id;
        this.mes = mes;
        this.ano = ano;
        this.pago = pago;
        this.data_pagamento = data_pagamento;
    }
    
    public void setEstrategia(PagamentoStrategy estrategia) {
        this.estrategia = estrategia;
    }
    
    public String processarPagamento() {
        if (estrategia != null) {
            return estrategia.valorPagamento();
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getResidencia_id() {
        return residencia_id;
    }

    public void setResidencia_id(int residencia_id) {
        this.residencia_id = residencia_id;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean getPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public LocalDate getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDate data_pagamento) {
        this.data_pagamento = data_pagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", residencia_id=" + residencia_id + ", mes=" + mes + ", ano=" + ano + ", pago=" + pago + ", data_pagamento=" + data_pagamento + '}';
    }
}
