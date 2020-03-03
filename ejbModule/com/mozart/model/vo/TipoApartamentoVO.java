package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

public class TipoApartamentoVO extends MozartVO {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -977488565913646435L;
	private FiltroWeb filtroTipoApto;
	private FiltroWeb filtroFantasia;
	
	
    /* Campos espelho do banco  bc - banco*/
    private Long bcIdTipoApartamento;
    private String bcTipoApartamento;
    private String bcFantasia;
    private Long bcIdHotel;
    private Long bcQtdePessoa;
    private String bcDescricaoApartamento;

    public TipoApartamentoVO() {
    	
    	filtroTipoApto = new FiltroWeb();
    	filtroFantasia = new FiltroWeb();
    }
    
    public TipoApartamentoVO(Object[] pLinha) {
    	setaDados(pLinha);
    }    

    
	public void setaDados(Object[] pLinha) {        
        setLinha(pLinha);
       
        bcIdTipoApartamento = getLong();
        bcTipoApartamento = getString();
        bcFantasia = getString();
        bcIdHotel = getLong();
        bcQtdePessoa = getLong();
        bcDescricaoApartamento = getString();
    }
    
    public void setBcIdTipoApartamento(Long bcIdTipoApartamento) {
        this.bcIdTipoApartamento = bcIdTipoApartamento;
    }

    public Long getBcIdTipoApartamento() {
        return bcIdTipoApartamento;
    }

    public void setBcTipoApartamento(String bcTipoApartamento) {
        this.bcTipoApartamento = bcTipoApartamento;
    }

    public String getBcTipoApartamento() {
        return bcTipoApartamento;
    }

    public void setBcFantasia(String bcFantasia) {
        this.bcFantasia = bcFantasia;
    }

    public String getBcFantasia() {
        return bcFantasia;
    }

    public void setBcIdHotel(Long bcIdHotel) {
        this.bcIdHotel = bcIdHotel;
    }

    public Long getBcIdHotel() {
        return bcIdHotel;
    }

    public void setBcQtdePessoa(Long bcQtdePessoa) {
        this.bcQtdePessoa = bcQtdePessoa;
    }

    public Long getBcQtdePessoa() {
        return bcQtdePessoa;
    }

    public void setBcDescricaoApartamento(String bcDescricaoApartamento) {
        this.bcDescricaoApartamento = bcDescricaoApartamento;
    }

    public String getBcDescricaoApartamento() {
        return bcDescricaoApartamento;
    }


	public FiltroWeb getFiltroTipoApto() {
		return filtroTipoApto;
	}


	public void setFiltroTipoApto(FiltroWeb filtroTipoApto) {
		this.filtroTipoApto = filtroTipoApto;
	}


	public FiltroWeb getFiltroFantasia() {
		return filtroFantasia;
	}


	public void setFiltroFantasia(FiltroWeb filtroFantasia) {
		this.filtroFantasia = filtroFantasia;
	}
}
