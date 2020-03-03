package com.mozart.model.vo;


public class EstadoNfeVO extends MozartVO {

	private static final long serialVersionUID = -5368866542928980201L;
	
	private Long id;
	private String idFcp;
	private String descricao;
	private Double valor;
	
	public EstadoNfeVO() {
	}	
	
	public EstadoNfeVO(Object[] filtro ) {
		if (filtro != null){
			setLinha(filtro);
			
			idFcp = getString();
			id = getLong();
			descricao = getString();
			valor = getDouble();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getIdFcp() {
		return idFcp;
	}

	public void setIdFcp(String idFcp) {
		this.idFcp = idFcp;
	}
}