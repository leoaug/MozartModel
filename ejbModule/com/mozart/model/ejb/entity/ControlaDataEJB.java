package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "ControlaDataEJB.findAll",hints=@QueryHint(name="eclipselink.refresh", value="TRUE"), 
    query = "select o from ControlaDataEJB o")
@Table(name = "CONTROLA_DATA")
public class ControlaDataEJB extends MozartEntity {
    /**
	 * 
	 */
	
	@Column(name="AUD_ENCERRA")
    private String audEncerra;
    @Column(name="CENTRAL_ADVISER")
    private String centralAdviser;
    
    private Timestamp contabilidade;
    
    
    @Column(name="CONTAS_PAGAR")
    private Timestamp contasPagar;
    
    @Column(name="CONTAS_RECEBER")
    private Timestamp contasReceber;
    
    @Column(name="estoque")
    private Timestamp estoque;
    
    
    @Column(name="FATURAMENTO_CONTAS_RECEBER")
    private Timestamp faturamentoContasReceber;
    private Long fechadura;
    @Column(name="FRONT_OFFICE")
    
    private Timestamp frontOffice;
    @Id
    @Column(name="ID_HOTEL", nullable = false)
    private Long idHotel;
    @Column(name="ID_REDE_HOTEL")
    private Long idRedeHotel;
    @Column(name="SALDO_ELEVADO")
    private Double saldoElevado;
    private Long telefonia;
    
    private Timestamp tesouraria;
    @Column(name="ULTIMA_CNFS")
    private Long ultimaCnfs;
    @Column(name="ULTIMA_NFS")
    private Long ultimaNfs;
    @Column(name="ULTIMA_NOTA_HOSPEDAGEM")
    private String ultimaNotaHospedagem;
    @Column(name="ULTIMA_NR")
    private Long ultimaNr;
    @Column(name="ULTIMA_REQUISICAO")
    private Long ultimaRequisicao;
    @Column(name="ULTIMA_SEQ_BANCARIA")
    private Long ultimaSeqBancaria;
    @Column(name="ULTIMO_NUM_CONTAS_PAGAR")
    private Long ultimoNumContasPagar;
    @Column(name="ULTIMO_NUM_COTACAO")
    private Long ultimoNumCotacao;
    @Column(name="ULTIMO_NUM_DUPLICATA")
    private Long ultimoNumDuplicata;
    @Column(name="ULTIMO_NUM_PEDIDO")
    private Long ultimoNumPedido;
    @Column(name="ULTIMA_CNFE")
    private Long ultimaCnfe;
    

    public ControlaDataEJB() {
    }

    public String getAudEncerra() {
        return audEncerra;
    }

    public void setAudEncerra(String audEncerra) {
        this.audEncerra = audEncerra;
    }

    public String getCentralAdviser() {
        return centralAdviser;
    }

    public void setCentralAdviser(String centralAdviser) {
        this.centralAdviser = centralAdviser;
    }

    public Timestamp getContabilidade() {
        return contabilidade;
    }

    public void setContabilidade(Timestamp contabilidade) {
        this.contabilidade = contabilidade;
    }

    public Timestamp getContasPagar() {
        return contasPagar;
    }

    public void setContasPagar(Timestamp contasPagar) {
        this.contasPagar = contasPagar;
    }

    public Timestamp getContasReceber() {
        return contasReceber;
    }

    public void setContasReceber(Timestamp contasReceber) {
        this.contasReceber = contasReceber;
    }

    public Timestamp getEstoque() {
        return estoque;
    }

    public void setEstoque(Timestamp estoque) {
        this.estoque = estoque;
    }

    public Timestamp getFaturamentoContasReceber() {
        return faturamentoContasReceber;
    }

    public void setFaturamentoContasReceber(Timestamp faturamentoContasReceber) {
        this.faturamentoContasReceber = faturamentoContasReceber;
    }

    public Long getFechadura() {
        return fechadura;
    }

    public void setFechadura(Long fechadura) {
        this.fechadura = fechadura;
    }

    public Timestamp getFrontOffice() {
        return frontOffice;
    }

    public void setFrontOffice(Timestamp frontOffice) {
        this.frontOffice = frontOffice;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdRedeHotel() {
        return idRedeHotel;
    }

    public void setIdRedeHotel(Long idRedeHotel) {
        this.idRedeHotel = idRedeHotel;
    }

    public Double getSaldoElevado() {
        return saldoElevado;
    }

    public void setSaldoElevado(Double saldoElevado) {
        this.saldoElevado = saldoElevado;
    }

    public Long getTelefonia() {
        return telefonia;
    }

    public void setTelefonia(Long telefonia) {
        this.telefonia = telefonia;
    }

    public Timestamp getTesouraria() {
        return tesouraria;
    }

    public void setTesouraria(Timestamp tesouraria) {
        this.tesouraria = tesouraria;
    }

    public Long getUltimaCnfs() {
        return ultimaCnfs;
    }

    public void setUltimaCnfs(Long ultimaCnfs) {
        this.ultimaCnfs = ultimaCnfs;
    }

    public Long getUltimaNfs() {
        return ultimaNfs;
    }

    public void setUltimaNfs(Long ultimaNfs) {
        this.ultimaNfs = ultimaNfs;
    }

    public String getUltimaNotaHospedagem() {
        return ultimaNotaHospedagem;
    }

    public void setUltimaNotaHospedagem(String ultimaNotaHospedagem) {
        this.ultimaNotaHospedagem = ultimaNotaHospedagem;
    }

    public Long getUltimaNr() {
        return ultimaNr;
    }

    public void setUltimaNr(Long ultimaNr) {
        this.ultimaNr = ultimaNr;
    }

    public Long getUltimaRequisicao() {
        return ultimaRequisicao;
    }

    public void setUltimaRequisicao(Long ultimaRequisicao) {
        this.ultimaRequisicao = ultimaRequisicao;
    }

    public Long getUltimaSeqBancaria() {
        return ultimaSeqBancaria;
    }

    public void setUltimaSeqBancaria(Long ultimaSeqBancaria) {
        this.ultimaSeqBancaria = ultimaSeqBancaria;
    }

    public Long getUltimoNumContasPagar() {
        return ultimoNumContasPagar;
    }

    public void setUltimoNumContasPagar(Long ultimoNumContasPagar) {
        this.ultimoNumContasPagar = ultimoNumContasPagar;
    }

    public Long getUltimoNumCotacao() {
        return ultimoNumCotacao;
    }

    public void setUltimoNumCotacao(Long ultimoNumCotacao) {
        this.ultimoNumCotacao = ultimoNumCotacao;
    }

    public Long getUltimoNumDuplicata() {
        return ultimoNumDuplicata;
    }

    public void setUltimoNumDuplicata(Long ultimoNumDuplicata) {
        this.ultimoNumDuplicata = ultimoNumDuplicata;
    }

    public Long getUltimoNumPedido() {
        return ultimoNumPedido;
    }

    public void setUltimoNumPedido(Long ultimoNumPedido) {
        this.ultimoNumPedido = ultimoNumPedido;
    }

	public Long getUltimaCnfe() {
		return ultimaCnfe;
	}

	public void setUltimaCnfe(Long ultimaCnfe) {
		this.ultimaCnfe = ultimaCnfe;
	}
    
    
}
