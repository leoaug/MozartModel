package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class FiscalCodigoVO extends MozartVO {

	private static final long serialVersionUID = -5368866542928980201L;

	private FiltroWeb filtroSubcodigoOuDescricao;
	
	private Long idCodigoFiscal;
	private String codEstado;
	private String codEstrangeiro;
	private String codFEstado;
	private String descricao;
	private String descricaoDocumento;
	private String descricaoMotivo;
	private String descricaoServico;
	private String descricaoSituacao;
	private String flgPrincipal;
	private Long idCidade;
	private String motivoCancela;
	private String situacaoNf;
	private String subCodigo;
	private Long tipoDocumento;
	private String tipoServico;
	
	public FiscalCodigoVO() {
		filtroSubcodigoOuDescricao = new FiltroWeb();
	}	
	
	public FiscalCodigoVO(Object[] filtro ) {
		if (filtro != null){
			setLinha(filtro);
			
			idCodigoFiscal = getLong();
			codEstado = getString();
			codEstrangeiro = getString();
			codFEstado = getString();
			descricao = getString();
			descricaoDocumento = getString();
			descricaoMotivo = getString();
			descricaoServico = getString();
			descricaoSituacao = getString();
			flgPrincipal = getString();
			idCidade = getLong();
			motivoCancela = getString();
			situacaoNf = getString();
			subCodigo = getString();
			tipoDocumento = getLong();
			tipoServico = getString();
		}
	}

	public Long getIdCodigoFiscal() {
		return idCodigoFiscal;
	}

	public void setIdCodigoFiscal(Long idCodigoFiscal) {
		this.idCodigoFiscal = idCodigoFiscal;
	}

	public String getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

	public String getCodEstrangeiro() {
		return codEstrangeiro;
	}

	public void setCodEstrangeiro(String codEstrangeiro) {
		this.codEstrangeiro = codEstrangeiro;
	}

	public String getCodFEstado() {
		return codFEstado;
	}

	public void setCodFEstado(String codFEstado) {
		this.codFEstado = codFEstado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricaoDocumento() {
		return descricaoDocumento;
	}

	public void setDescricaoDocumento(String descricaoDocumento) {
		this.descricaoDocumento = descricaoDocumento;
	}

	public String getDescricaoMotivo() {
		return descricaoMotivo;
	}

	public void setDescricaoMotivo(String descricaoMotivo) {
		this.descricaoMotivo = descricaoMotivo;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public String getDescricaoSituacao() {
		return descricaoSituacao;
	}

	public void setDescricaoSituacao(String descricaoSituacao) {
		this.descricaoSituacao = descricaoSituacao;
	}

	public String getFlgPrincipal() {
		return flgPrincipal;
	}

	public void setFlgPrincipal(String flgPrincipal) {
		this.flgPrincipal = flgPrincipal;
	}

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public String getMotivoCancela() {
		return motivoCancela;
	}

	public void setMotivoCancela(String motivoCancela) {
		this.motivoCancela = motivoCancela;
	}

	public String getSituacaoNf() {
		return situacaoNf;
	}

	public void setSituacaoNf(String situacaoNf) {
		this.situacaoNf = situacaoNf;
	}

	public String getSubCodigo() {
		return subCodigo;
	}

	public void setSubCodigo(String subCodigo) {
		this.subCodigo = subCodigo;
	}

	public Long getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Long tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(String tipoServico) {
		this.tipoServico = tipoServico;
	}

	public FiltroWeb getFiltroSubcodigoOuDescricao() {
		return filtroSubcodigoOuDescricao;
	}

	public void setFiltroSubcodigoOuDescricao(FiltroWeb filtroSubcodigoOuDescricao) {
		this.filtroSubcodigoOuDescricao = filtroSubcodigoOuDescricao;
	}
}