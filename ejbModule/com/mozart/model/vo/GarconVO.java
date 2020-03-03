package com.mozart.model.vo;



import java.util.Date;

import com.mozart.model.vo.filtro.FiltroWeb;

public class GarconVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
				
		/* FILTRO */
		private FiltroWeb filtroNome;
		private FiltroWeb filtroAtivo;
		
		
		private Long idGarcon;
		private String nomeGarcon;
		private Double comissao;
		private String ativo;
		private Date data;
		
		public GarconVO(){
			
			filtroNome = new FiltroWeb();
			filtroAtivo = new FiltroWeb();
			
		}	
		
		public GarconVO(Object[] filtro ) {
			
			if (filtro != null){
				setLinha(filtro);
			
				
				idGarcon = getLong();
				nomeGarcon = getString();
				ativo = getString();
				comissao = getDouble();
				data = getDate();
			}
		}

		public FiltroWeb getFiltroNome() {
			return filtroNome;
		}

		public void setFiltroNome(FiltroWeb filtroNome) {
			this.filtroNome = filtroNome;
		}

		public FiltroWeb getFiltroAtivo() {
			return filtroAtivo;
		}

		public void setFiltroAtivo(FiltroWeb filtroAtivo) {
			this.filtroAtivo = filtroAtivo;
		}

		public Long getIdNomeGarcon() {
			return idGarcon;
		}

		public void setIdNomeGarcon(Long idNomeGarcon) {
			this.idGarcon = idNomeGarcon;
		}

		public String getNomeGarcon() {
			return nomeGarcon;
		}

		public void setNomeGarcon(String nomeGarcon) {
			this.nomeGarcon = nomeGarcon;
		}

		public Double getComissao() {
			return comissao;
		}

		public void setComissao(Double comissao) {
			this.comissao = comissao;
		}

		public String getAtivo() {
			return ativo;
		}

		public void setAtivo(String ativo) {
			this.ativo = ativo;
		}

		public Date getData() {
			return data;
		}

		public void setData(Date data) {
			this.data = data;
		}

		public Long getIdGarcon() {
			return idGarcon;
		}

		public void setIdGarcon(Long idGarcon) {
			this.idGarcon = idGarcon;
		}

		
		
		
	}
