package com.mozart.model.vo;

import com.mozart.model.util.MozartUtil;


public class LinhaNotaFiscalVO extends MozartVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4350256576741126293L;
	private Integer indice;
	private StringBuilder conteudo;
	
	public LinhaNotaFiscalVO(Integer indice){
		this.indice = indice;
		this.conteudo = new StringBuilder(MozartUtil.rpad(" ", " ", 500));
	}
	
	public boolean equals(Object obj){
		
		if (obj == null)
			return false;
		
		return ((LinhaNotaFiscalVO)obj).getIndice().equals( indice );
		
	}
	
	public Integer getIndice() {
		return indice;
	}
	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public String getConteudo() {
		return conteudo.toString();
	}

	public void addColuna(Long coluna, String valor) {
		if (valor != null)
		conteudo.insert(coluna.intValue()-1, valor);	
		/*for (int x = coluna.intValue()-1, y=0; y<valor.length();x++,y++){
			conteudo[x] = valor.substring(y, y+1);
		}*/
	}

}
