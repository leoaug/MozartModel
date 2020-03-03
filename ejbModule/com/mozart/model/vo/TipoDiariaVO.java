package com.mozart.model.vo;


public class TipoDiariaVO extends MozartVO {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6044317992280436259L;
	private Long bcIdTipoDiaria;
    private String bcDescricao;
    private String bcPadrao;
    private Long bcIdRedeHotel;
    
    public TipoDiariaVO() {
    }
    
    public void setaDados(Object[] pLinha) {        
        setLinha(pLinha);                            
        bcIdTipoDiaria= getLong();
        bcDescricao = getString();
        bcPadrao = getString();
        bcIdRedeHotel = getLong();
    }

    public void setBcIdTipoDiaria(Long bcIdTipoDiaria) {
        this.bcIdTipoDiaria = bcIdTipoDiaria;
    }

    public Long getBcIdTipoDiaria() {
        return bcIdTipoDiaria;
    }

    public void setBcDescricao(String bcDescricao) {
        this.bcDescricao = bcDescricao;
    }

    public String getBcDescricao() {
        return bcDescricao;
    }

    public void setBcPadrao(String bcPadrao) {
        this.bcPadrao = bcPadrao;
    }

    public String getBcPadrao() {
        return bcPadrao;
    }

    public void setBcIdRedeHotel(Long bcIdRedeHotel) {
        this.bcIdRedeHotel = bcIdRedeHotel;
    }

    public Long getBcIdRedeHotel() {
        return bcIdRedeHotel;
    }
}
