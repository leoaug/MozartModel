package com.mozart.model.vo;



import com.mozart.model.vo.filtro.FiltroWeb;

public class PratoVO extends MozartVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
				
		/* FILTRO */
		private FiltroWeb filtroGrupo;
		private FiltroWeb filtroProduto;
		
		
		
		private Long idPrato;
		private String nomePrato;
		private String tipo;
		private String grupo;
		private Double vrCusto;
		private Double vrVenda;
		private Double custoPerc;
		
		private String gracValorIncompleto;
		
		
		
		
		public PratoVO(){
			
			filtroGrupo = new FiltroWeb();
			filtroProduto = new FiltroWeb();
			
			
		}	
		
		public PratoVO (Object[] filtro ) {
			
			if (filtro != null){
				setLinha(filtro);
			
				idPrato = getLong();
				nomePrato = getString();
				tipo = getString();
				grupo = getString();
				vrCusto = getDouble();
				vrVenda = getDouble();
				custoPerc = getDouble();
				
				
			}
		}

		
		public FiltroWeb getFiltroGrupo() {
			return filtroGrupo;
		}

		public void setFiltroGrupo(FiltroWeb filtroGrupo) {
			this.filtroGrupo = filtroGrupo;
		}

		public FiltroWeb getFiltroProduto() {
			return filtroProduto;
		}

		public void setFiltroProduto(FiltroWeb filtroProduto) {
			this.filtroProduto = filtroProduto;
		}

		public String getNomePrato() {
			return nomePrato;
		}

		public void setNomePrato(String nomePrato) {
			this.nomePrato = nomePrato;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public Double getVrVenda() {
			return vrVenda;
		}

		public void setVrVenda(Double vrVenda) {
			this.vrVenda = vrVenda;
		}

		public Double getVrCusto() {
			return vrCusto;
		}

		public void setVrCusto(Double vrCusto) {
			this.vrCusto = vrCusto;
		}

		public Double getCustoPerc() {
			return custoPerc;
		}

		public void setCustoPerc(Double custoPerc) {
			this.custoPerc = custoPerc;
		}

		public String getGrupo() {
			return grupo;
		}

		public void setGrupo(String grupo) {
			this.grupo = grupo;
		}

		public Long getIdPrato() {
			return idPrato;
		}

		public void setIdPrato(Long idPrato) {
			this.idPrato = idPrato;
		}

		public String getGracValorIncompleto() {
			return gracValorIncompleto;
		}

		public void setGracValorIncompleto(String gracValorIncompleto) {
			this.gracValorIncompleto = gracValorIncompleto;
		}
		
		

				
}