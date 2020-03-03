package com.mozart.model.ejb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;

@Entity
@NamedQueries({
	@NamedQuery(name = "FiscalCodigoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	    query = "select o from FiscalCodigoEJB o where o.flgPrincipal = 'N' and (o.codEstado = '5' or o.codFEstado = '6' or o.codEstrangeiro = '7') order by o.subCodigo"),
	@NamedQuery(name = "FiscalCodigoEJB.obterCodigoCompra", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	query = "select o from FiscalCodigoEJB o where  o.flgPrincipal = 'N' and (o.codEstado = '1' or o.codEstrangeiro = '3') order by o.subCodigo")
})
@Table(name="FISCAL_CODIGO")
public class FiscalCodigoEJB extends MozartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_CODIGO_FISCAL")
	private Long idCodigoFiscal;
	
	@Column(name="COD_ESTADO")
	private String codEstado;

	@Column(name="COD_ESTRANGEIRO")
	private String codEstrangeiro;

	@Column(name="COD_F_ESTADO")
	private String codFEstado;

	private String descricao;

	@Column(name="DESCRICAO_DOCUMENTO")
	private String descricaoDocumento;

	@Column(name="DESCRICAO_MOTIVO")
	private String descricaoMotivo;

	@Column(name="DESCRICAO_SERVICO")
	private String descricaoServico;

	@Column(name="DESCRICAO_SITUACAO")
	private String descricaoSituacao;

	@Column(name="FLG_PRINCIPAL")
	private String flgPrincipal;

	@Column(name="ID_CIDADE")
	private Long idCidade;

	@Column(name="MOTIVO_CANCELA")
	private String motivoCancela;

	@Column(name="SITUACAO_NF")
	private String situacaoNf;

	@Column(name="SUB_CODIGO")
	private String subCodigo;

	@Column(name="TIPO_DOCUMENTO")
	private Long tipoDocumento;

	@Column(name="TIPO_SERVICO")
	private String tipoServico;

    public FiscalCodigoEJB() {
    }

	public String getCodEstado() {
		return this.codEstado;
	}

	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

	public String getCodEstrangeiro() {
		return this.codEstrangeiro;
	}

	public void setCodEstrangeiro(String codEstrangeiro) {
		this.codEstrangeiro = codEstrangeiro;
	}

	public String getCodFEstado() {
		return this.codFEstado;
	}

	public void setCodFEstado(String codFEstado) {
		this.codFEstado = codFEstado;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoDocumento() {
		return this.descricaoDocumento;
	}

	public void setDescricaoDocumento(String descricaoDocumento) {
		this.descricaoDocumento = descricaoDocumento;
	}

	public String getDescricaoMotivo() {
		return this.descricaoMotivo;
	}

	public void setDescricaoMotivo(String descricaoMotivo) {
		this.descricaoMotivo = descricaoMotivo;
	}

	public String getDescricaoServico() {
		return this.descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public String getDescricaoSituacao() {
		return this.descricaoSituacao;
	}

	public void setDescricaoSituacao(String descricaoSituacao) {
		this.descricaoSituacao = descricaoSituacao;
	}

	public String getFlgPrincipal() {
		return this.flgPrincipal;
	}

	public void setFlgPrincipal(String flgPrincipal) {
		this.flgPrincipal = flgPrincipal;
	}

	public Long getIdCidade() {
		return this.idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public Long getIdCodigoFiscal() {
		return this.idCodigoFiscal;
	}

	public void setIdCodigoFiscal(Long idCodigoFiscal) {
		this.idCodigoFiscal = idCodigoFiscal;
	}

	public String getMotivoCancela() {
		return this.motivoCancela;
	}

	public void setMotivoCancela(String motivoCancela) {
		this.motivoCancela = motivoCancela;
	}

	public String getSituacaoNf() {
		return this.situacaoNf;
	}

	public void setSituacaoNf(String situacaoNf) {
		this.situacaoNf = situacaoNf;
	}

	public String getSubCodigo() {
		return this.subCodigo;
	}

	public void setSubCodigo(String subCodigo) {
		this.subCodigo = subCodigo;
	}

	public Long getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(Long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoServico() {
		return this.tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}
}