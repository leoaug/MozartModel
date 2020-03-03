package com.mozart.model.ejb.entity;

import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the DUPLICATA_TEMP database table.
 * 
 */
@Entity
@Table(name="DUPLICATA_TEMP")
public class DuplicataTempEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DUPLICATA_TEMP_IDDUPLICATATEMP_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DUPLICATA_TEMP_IDDUPLICATATEMP_GENERATOR")
	@Column(name="ID_DUPLICATA_TEMP")
	private long idDuplicataTemp;

	private Double ajustes;

	private Long ano;

	private Double cofins;

	private Double comissao;
	
	// TODO: (ID / Conta Corrente) Atributo incompativel, nao obtem entidade
	@Column(name="ID_CONTA_CORRENTE")
	private Long contaCorrente;

	private Double cssl;

    
	@Column(name="DATA_LANCAMENTO")
	private Timestamp dataLancamento;

    
	@Column(name="DATA_VENCIMENTO")
	private Timestamp dataVencimento;

	private Double encargos;

	@Column(name="ID_EMPRESA")
	private Long idEmpresa;

	@Column(name="ID_HOSPEDE")
	private Long idHospede;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_NOTA")
	private Long idNota;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	private String imprimir;

	private Double ir;

	@Column(name="IR_RETENCAO")
	private Double irRetencao;

	private Double iss;

	@Column(name="JUSTIFICA_AJUSTE")
	private String justificaAjuste;

	private String master;

	@Column(name="NUM_PARCELAS")
	private Long numParcelas;

	private Double pis;

	@Column(name="VALOR_DUPLICATA")
	private Double valorDuplicata;

    public DuplicataTempEJB() {
    }

	public long getIdDuplicataTemp() {
		return this.idDuplicataTemp;
	}

	public void setIdDuplicataTemp(long idDuplicataTemp) {
		this.idDuplicataTemp = idDuplicataTemp;
	}

	public Double getAjustes() {
		return this.ajustes;
	}

	public void setAjustes(Double ajustes) {
		this.ajustes = ajustes;
	}

	public Long getAno() {
		return this.ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Double getCofins() {
		return this.cofins;
	}

	public void setCofins(Double cofins) {
		this.cofins = cofins;
	}

	public Double getComissao() {
		return this.comissao;
	}

	public void setComissao(Double comissao) {
		this.comissao = comissao;
	}

	public Long getContaCorrente() {
		return this.contaCorrente;
	}

	public void setContaCorrente(Long contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public Double getCssl() {
		return this.cssl;
	}

	public void setCssl(Double cssl) {
		this.cssl = cssl;
	}

	public Timestamp getDataLancamento() {
		return this.dataLancamento;
	}

	public void setDataLancamento(Timestamp dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Timestamp getDataVencimento() {
		return this.dataVencimento;
	}

	public void setDataVencimento(Timestamp dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getEncargos() {
		return this.encargos;
	}

	public void setEncargos(Double encargos) {
		this.encargos = encargos;
	}

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdHospede() {
		return this.idHospede;
	}

	public void setIdHospede(Long idHospede) {
		this.idHospede = idHospede;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdNota() {
		return this.idNota;
	}

	public void setIdNota(Long idNota) {
		this.idNota = idNota;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getImprimir() {
		return this.imprimir;
	}

	public void setImprimir(String imprimir) {
		this.imprimir = imprimir;
	}

	public Double getIr() {
		return this.ir;
	}

	public void setIr(Double ir) {
		this.ir = ir;
	}

	public Double getIrRetencao() {
		return this.irRetencao;
	}

	public void setIrRetencao(Double irRetencao) {
		this.irRetencao = irRetencao;
	}

	public Double getIss() {
		return this.iss;
	}

	public void setIss(Double iss) {
		this.iss = iss;
	}

	public String getJustificaAjuste() {
		return this.justificaAjuste;
	}

	public void setJustificaAjuste(String justificaAjuste) {
		this.justificaAjuste = justificaAjuste;
	}

	public String getMaster() {
		return this.master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public Long getNumParcelas() {
		return this.numParcelas;
	}

	public void setNumParcelas(Long numParcelas) {
		this.numParcelas = numParcelas;
	}

	public Double getPis() {
		return this.pis;
	}

	public void setPis(Double pis) {
		this.pis = pis;
	}

	public Double getValorDuplicata() {
		return this.valorDuplicata;
	}

	public void setValorDuplicata(Double valorDuplicata) {
		this.valorDuplicata = valorDuplicata;
	}

}