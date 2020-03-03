package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.Table;

import com.mozart.model.util.MozartUtil;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "IdentificaLancamentoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from IdentificaLancamentoEJB o")
@Table(name = "IDENTIFICA_LANCAMENTO")
public class IdentificaLancamentoEJB extends MozartEntity {
    private String atividade;
    @Column(name="DESCRICAO_LANCAMENTO")
    private String descricaoLancamento;
    @Column(name="GRUPO_DESPESA", nullable = false)
    private String grupoDespesa;
    @Column(name="GRUPO_SUB")
    private String grupoSub;
    @Id
    @Column(name="ID_IDENTIFICA_LANCAMENTO", nullable = false)
    private Long idIdentificaLancamento;
    @Column(name="RECEITA_CHECKOUT")
    private String receitaCheckout;

    @OneToOne
    @JoinColumn(name = "ID_IDENTIFICA_LANCAMENTO_PAI", referencedColumnName = "ID_IDENTIFICA_LANCAMENTO")
    private IdentificaLancamentoEJB identificaLancamentoPaiEJB;
   /* @OneToMany(mappedBy = "identificaLancamentoEJB")
    private List<IdentificaLancamentoEJB> identificaLancamentoEJBList;
8*/
    public IdentificaLancamentoEJB() {
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getDescricaoLancamento() {
        return descricaoLancamento;
    }

    public void setDescricaoLancamento(String descricaoLancamento) {
        this.descricaoLancamento = descricaoLancamento;
    }

    public String getGrupoDespesa() {
        return grupoDespesa;
    }

    public void setGrupoDespesa(String grupoDespesa) {
        this.grupoDespesa = grupoDespesa;
    }

    public String getGrupoSub() {
        return grupoSub;
    }

    public void setGrupoSub(String grupoSub) {
        this.grupoSub = grupoSub;
    }

    public Long getIdIdentificaLancamento() {
        return idIdentificaLancamento;
    }

    public void setIdIdentificaLancamento(Long idIdentificaLancamento) {
        this.idIdentificaLancamento = idIdentificaLancamento;
    }
    public void setIdIdentificaLancamento(String idIdentificaLancamento) {
    	if(!MozartUtil.isNull(idIdentificaLancamento)){
    		this.idIdentificaLancamento = Long.valueOf(idIdentificaLancamento.split(";")[0]);
    	}
    }


    public String getReceitaCheckout() {
        return receitaCheckout;
    }

    public void setReceitaCheckout(String receitaCheckout) {
        this.receitaCheckout = receitaCheckout;
    }

  /*  public IdentificaLancamentoEJB getIdentificaLancamentoEJB() {
        return identificaLancamentoEJB;
    }

    public void setIdentificaLancamentoEJB(IdentificaLancamentoEJB identificaLancamentoEJB) {
        this.identificaLancamentoEJB = identificaLancamentoEJB;
    }

    public List<IdentificaLancamentoEJB> getIdentificaLancamentoEJBList() {
        return identificaLancamentoEJBList;
    }

    public void setIdentificaLancamentoEJBList(List<IdentificaLancamentoEJB> identificaLancamentoEJBList) {
        this.identificaLancamentoEJBList = identificaLancamentoEJBList;
    }

    public IdentificaLancamentoEJB addIdentificaLancamentoEJB(IdentificaLancamentoEJB identificaLancamentoEJB) {
        getIdentificaLancamentoEJBList().add(identificaLancamentoEJB);
        identificaLancamentoEJB.setIdentificaLancamentoEJB(this);
        return identificaLancamentoEJB;
    }

    public IdentificaLancamentoEJB removeIdentificaLancamentoEJB(IdentificaLancamentoEJB identificaLancamentoEJB) {
        getIdentificaLancamentoEJBList().remove(identificaLancamentoEJB);
        identificaLancamentoEJB.setIdentificaLancamentoEJB(null);
        return identificaLancamentoEJB;
    }*/



    public void setIdentificaLancamentoPaiEJB(IdentificaLancamentoEJB identificaLancamentoPaiEJB) {
        this.identificaLancamentoPaiEJB = identificaLancamentoPaiEJB;
    }

    public IdentificaLancamentoEJB getIdentificaLancamentoPaiEJB() {
        return identificaLancamentoPaiEJB;
    }
    
    public String getChave(){
		return  + idIdentificaLancamento + ";"
				+ receitaCheckout + ";"
				+ ((identificaLancamentoPaiEJB!=null) ? identificaLancamentoPaiEJB.getIdIdentificaLancamento() : "");
	}
}
