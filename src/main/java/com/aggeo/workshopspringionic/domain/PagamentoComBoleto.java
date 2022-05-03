package com.aggeo.workshopspringionic.domain;

import com.aggeo.workshopspringionic.domain.enums.EstadoPagamento;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PagamentoComBoleto extends Pagamento{
    private static final long serialVersionUID = 1L;

    private Date dateVencimento;
    private Date datePagamento;

    public PagamentoComBoleto(){
    }


    public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dateVencimento, Date datePagamento) {
        super(id, estado, pedido);
        this.dateVencimento = dateVencimento;
        this.datePagamento = datePagamento;
    }

    public Date getDateVencimento() {
        return dateVencimento;
    }

    public void setDateVencimento(Date dateVencimento) {
        this.dateVencimento = dateVencimento;
    }

    public Date getDatePagamento() {
        return datePagamento;
    }

    public void setDatePagamento(Date datePagamento) {
        this.datePagamento = datePagamento;
    }
}
