package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class ContaCorrenteGeralVO extends MozartVO {
	private static final long serialVersionUID = 1L;
	private FiltroWeb filtroApto;
	private FiltroWeb filtroEmpresa;
	
	
	private String gracNumApto;
	private String gracNomeFantasiaEmpresaRede;
	private String gracObsrvacoesCheckin;
	private String gracSiglaHotel;
	
	private Long bcIdCheckin;
	
	
	public ContaCorrenteGeralVO() {
		setFiltroApto(new FiltroWeb());
		setFiltroEmpresa(new FiltroWeb());
	}

	public ContaCorrenteGeralVO(Object[] linha) {
		if (linha != null) {
			
			setLinha(linha);
			bcIdCheckin = getLong();
			gracNumApto = getString();
			gracNomeFantasiaEmpresaRede = getString();
			gracObsrvacoesCheckin = getString();
			gracSiglaHotel = getString();
		}
	}

	public FiltroWeb getFiltroApto() {
		return filtroApto;
	}

	public void setFiltroApto(FiltroWeb filtroApto) {
		this.filtroApto = filtroApto;
	}

	public FiltroWeb getFiltroEmpresa() {
		return filtroEmpresa;
	}

	public void setFiltroEmpresa(FiltroWeb filtroEmpresa) {
		this.filtroEmpresa = filtroEmpresa;
	}

	public String getGracNumApto() {
		return gracNumApto;
	}

	public void setGracNumApto(String gracNumApto) {
		this.gracNumApto = gracNumApto;
	}

	public String getGracNomeFantasiaEmpresaRede() {
		return gracNomeFantasiaEmpresaRede;
	}

	public void setGracNomeFantasiaEmpresaRede(String gracNomeFantasiaEmpresaRede) {
		this.gracNomeFantasiaEmpresaRede = gracNomeFantasiaEmpresaRede;
	}

	public String getGracObsrvacoesCheckin() {
		return gracObsrvacoesCheckin;
	}

	public void setGracObsrvacoesCheckin(String gracObsrvacoesCheckin) {
		this.gracObsrvacoesCheckin = gracObsrvacoesCheckin;
	}

	public String getGracSiglaHotel() {
		return gracSiglaHotel;
	}

	public void setGracSiglaHotel(String gracSiglaHotel) {
		this.gracSiglaHotel = gracSiglaHotel;
	}
	
	public Long getBcIdCheckin() {
		return bcIdCheckin;
	}

	public void setBcIdCheckin(Long bcIdCheckin) {
		this.bcIdCheckin = bcIdCheckin;
	}

	@Override
	public String toString() {
		return "ContaCorrenteGeralVO [gracNumApto=" + gracNumApto
				+ ", gracNomeFantasiaEmpresaRede="
				+ gracNomeFantasiaEmpresaRede + "]";
	}

		
}