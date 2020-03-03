package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class ApiGeralVO extends MozartVO{

	
	private static final long serialVersionUID = -6684199255746963299L;

	private Long idApiGeral;
	
	private Long idApiContrato;
	
	private String token;
	
	private String url;
	
	private String nome;
	
	private String ativo;
	
	private String apiContratoAtivo;
	
	private String apiContratoNome;
		
	private Long apiVendedorId;
	
	private String apiVendedorNome;
	
	private String apiVendedorAtivo;
		
	private FiltroWeb razaoSocial;
	
	private String razaoSocialString;
	
	private Long idEmpresa;
	
	private String nomeFantasia;
	
	private String hotelNomeFantasia;
	
	private String hotelNomeFantasiaTL;
	
	private String tipoLancamentoDescricao;
	
	private String tipoLancamentoDescricaoCK;
	
	public ApiGeralVO(){
		razaoSocial = new FiltroWeb();
	}
	
	
	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdApiGeral() {
		return idApiGeral;
	}

	public void setIdApiGeral(Long idApiGeral) {
		this.idApiGeral = idApiGeral;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public FiltroWeb getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(FiltroWeb razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public String getRazaoSocialString() {
		return razaoSocialString;
	}


	public void setRazaoSocialString(String razaoSocialString) {
		this.razaoSocialString = razaoSocialString;
	}


	public String getNomeFantasia() {
		return nomeFantasia;
	}


	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getApiContratoAtivo() {
		return apiContratoAtivo;
	}


	public void setApiContratoAtivo(String apiContratoAtivo) {
		this.apiContratoAtivo = apiContratoAtivo;
	}


	public String getApiContratoNome() {
		return apiContratoNome;
	}


	public void setApiContratoNome(String apiContratoNome) {
		this.apiContratoNome = apiContratoNome;
	}


	public String getHotelNomeFantasia() {
		return hotelNomeFantasia;
	}


	public void setHotelNomeFantasia(String hotelNomeFantasia) {
		this.hotelNomeFantasia = hotelNomeFantasia;
	}


	public String getTipoLancamentoDescricao() {
		return tipoLancamentoDescricao;
	}


	public void setTipoLancamentoDescricao(String tipoLancamentoDescricao) {
		this.tipoLancamentoDescricao = tipoLancamentoDescricao;
	}


	public String getTipoLancamentoDescricaoCK() {
		return tipoLancamentoDescricaoCK;
	}


	public void setTipoLancamentoDescricaoCK(String tipoLancamentoDescricaoCK) {
		this.tipoLancamentoDescricaoCK = tipoLancamentoDescricaoCK;
	}


	public String getApiVendedorNome() {
		return apiVendedorNome;
	}


	public void setApiVendedorNome(String apiVendedorNome) {
		this.apiVendedorNome = apiVendedorNome;
	}


	public Long getIdApiContrato() {
		return idApiContrato;
	}


	public void setIdApiContrato(Long idApiContrato) {
		this.idApiContrato = idApiContrato;
	}


	public String getApiVendedorAtivo() {
		return apiVendedorAtivo;
	}


	public void setApiVendedorAtivo(String apiVendedorAtivo) {
		this.apiVendedorAtivo = apiVendedorAtivo;
	}


	public String getHotelNomeFantasiaTL() {
		return hotelNomeFantasiaTL;
	}


	public void setHotelNomeFantasiaTL(String hotelNomeFantasiaTL) {
		this.hotelNomeFantasiaTL = hotelNomeFantasiaTL;
	}


	public Long getApiVendedorId() {
		return apiVendedorId;
	}


	public void setApiVendedorId(Long apiVendedorId) {
		this.apiVendedorId = apiVendedorId;
	}

	
	
	
}
