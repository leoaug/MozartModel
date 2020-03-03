package com.mozart.model.vo;

import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class AchadosPerdidoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	/* FILTRO */
	private FiltroWeb filtroData;
	private FiltroWeb filtroLocal;
	private FiltroWeb filtroObjeto;
	
	

	private Long idAchadosPerdidos;
	private String objeto;
	private String periodo;
	private String local;
	private Date data;
	private String funcionarioAchou;
	private Long idHospede;
	private String dataDevolucao;
	private String funcionarioRecebe;
	private String documento;
	private Long idHotel;
	private String recebedor;
	private String docRecebedor;
	private String hospede;
	private String celular;
	
	
	
	
		
	
	public AchadosPerdidoVO(){
		
		filtroData = new FiltroWeb();
		filtroLocal = new FiltroWeb();
		filtroObjeto = new FiltroWeb();
				
		
	}	
	
	public AchadosPerdidoVO(Object[] filtro ) {
		
		if (filtro != null){
			setLinha(filtro);
		
			idAchadosPerdidos = getLong();
			objeto = getString();
			periodo = getString();
			local = getString();
			data = getDate();
			funcionarioAchou = getString();
			idHospede = getLong(); 
			dataDevolucao = getString();
			funcionarioRecebe = getString();
			documento = getString();
			idHotel = getLong();
			recebedor = getString();
			docRecebedor = getString();
			hospede = getString();
			celular = getString();
			
			
		
		}
		
	}

	public FiltroWeb getFiltroData() {
		return filtroData;
	}

	public void setFiltroData(FiltroWeb filtroData) {
		this.filtroData = filtroData;
	}

	public FiltroWeb getFiltroLocal() {
		return filtroLocal;
	}

	public void setFiltroLocal(FiltroWeb filtroLocal) {
		this.filtroLocal = filtroLocal;
	}

	public FiltroWeb getFiltroObjeto() {
		return filtroObjeto;
	}

	public void setFiltroObjeto(FiltroWeb filtroObjeto) {
		this.filtroObjeto = filtroObjeto;
	}

	public Long getIdAchadosPerdido() {
		return idAchadosPerdidos;
	}

	public void setIdAchadosPerdido(Long idAchadosPerdido) {
		this.idAchadosPerdidos = idAchadosPerdido;
	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getFuncionarioAchou() {
		return funcionarioAchou;
	}

	public void setFuncionarioAchou(String funcionarioAchou) {
		this.funcionarioAchou = funcionarioAchou;
	}

	public Long getIdHospede() {
		return idHospede;
	}

	public void setIdHospede(Long idHospede) {
		this.idHospede = idHospede;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getFuncionarioRecebe() {
		return funcionarioRecebe;
	}

	public void setFuncionarioRecebe(String funcionarioRecebe) {
		this.funcionarioRecebe = funcionarioRecebe;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getRecebedor() {
		return recebedor;
	}

	public void setRecebedor(String recebedor) {
		this.recebedor = recebedor;
	}

	public String getDocRecebedor() {
		return docRecebedor;
	}

	public void setDocRecebedor(String docRecebedor) {
		this.docRecebedor = docRecebedor;
	}

	public String getHospede() {
		return hospede;
	}

	public void setHospede(String hospede) {
		this.hospede = hospede;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
	
	

	

	
}
