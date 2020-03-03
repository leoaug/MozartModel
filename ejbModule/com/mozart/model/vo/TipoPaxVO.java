package com.mozart.model.vo;

public class TipoPaxVO extends MozartVO {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -7150852916825453488L;
	private Long bcIdTipoPax;
    private String bcDescricao;
    
    public TipoPaxVO() {
    }
    
    public TipoPaxVO(Long id, String descricao) {
        bcIdTipoPax = id;
        bcDescricao = descricao;
    }

    public void setBcIdTipoPax(Long bcIdTipoPax) {
        this.bcIdTipoPax = bcIdTipoPax;
    }

    public Long getBcIdTipoPax() {
        return bcIdTipoPax;
    }

    public void setBcDescricao(String bcDescricao) {
        this.bcDescricao = bcDescricao;
    }

    public String getBcDescricao() {
        return bcDescricao;
    }
}
