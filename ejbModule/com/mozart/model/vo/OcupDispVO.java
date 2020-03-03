package com.mozart.model.vo;


public class OcupDispVO extends MozartVO {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -4553783128108552326L;
	private String data;
    private String fantasia;
    private Long valor;
    private Double percentual;
    private String diaSemana;
    private Long total;
    private Long totDia;
    private String totDiaString;
    private Double percentDia;
    private String percentDiaString;
    private Long ultimoDoDia;
    private Long idTarifa;
    private Long idTipoApto;
    
    public OcupDispVO() {
        
    }
    
    
    public OcupDispVO(Object[] linha) {
    	if (linha != null){
    		setLinha(linha);
    		data = getString();
    		fantasia = getString();
    		valor = getLong();
    		percentual = getDouble();
    		diaSemana = getString();
    		total = getLong();
    		totDia = getLong();
    		percentDia = getDouble();
    		idTarifa = getLong();
    		idTipoApto = getLong();
    	}
        
    }
    
    public void setaDados(Object[] pLinha) {        
        setLinha(pLinha);
        data = getString();
        fantasia = getString();
        valor = getLong();
        percentual = getDouble();
        diaSemana = getString();
        total = getLong();
        totDia = getLong();
        if ( totDia.longValue()  < 100 )
            totDiaString = totDia.toString();
        else
            totDiaString = "100";
        percentDia = getDouble();
        if ( percentDia.longValue()  < 100 )
            percentDiaString = percentDia.toString().replace(",",".");
        else
            percentDiaString = "100";
        ultimoDoDia = new Long(0);
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getValor() {
        return valor;
    }

    public void setPercentual(Double percentual) {
        this.percentual = percentual;
    }

    public Double getPercentual() {
        return percentual;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotDia(Long totDia) {
        this.totDia = totDia;
    }

    public Long getTotDia() {
        return totDia;
    }

    public void setPercentDia(Double percentDia) {
        this.percentDia = percentDia;
    }

    public Double getPercentDia() {
        return percentDia;
    }

    public void setPercentDiaString(String percentDiaString) {
        this.percentDiaString = percentDiaString;
    }

    public String getPercentDiaString() {
        return percentDiaString;
    }

    public void setTotDiaString(String totDiaString) {
        this.totDiaString = totDiaString;
    }

    public String getTotDiaString() {
        return totDiaString;
    }

    public void setUltimoDoDia(Long ultimoDoDia) {
        this.ultimoDoDia = ultimoDoDia;
    }

    public Long getUltimoDoDia() {
        return ultimoDoDia;
    }


	public Long getIdTarifa() {
		return idTarifa;
	}


	public void setIdTarifa(Long idTarifa) {
		this.idTarifa = idTarifa;
	}


	public Long getIdTipoApto() {
		return idTipoApto;
	}


	public void setIdTipoApto(Long idTipoApto) {
		this.idTipoApto = idTipoApto;
	}
}
