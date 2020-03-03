package com.mozart.model.vo;


public class EmpresaGrupoLancamentoVO extends MozartVO {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -2922458455540116012L;
	/* campos espelho banco */
    private Long bcIdEmpresa;
    private Long bcIdIdentificaLancamento;
    private String bcQuemPaga;
    private Long bcIdHotel;        
    
    public EmpresaGrupoLancamentoVO() {
    }
    
    
	public void setaDados(Object[] pLinha) {        
        setLinha(pLinha);
        bcIdEmpresa = getLong();
        bcIdIdentificaLancamento  = getLong();
        bcQuemPaga = getString();
        bcIdHotel = getLong();
    }

    public void setBcIdEmpresa(Long bcIdEmpresa) {
        this.bcIdEmpresa = bcIdEmpresa;
    }

    public Long getBcIdEmpresa() {
        return bcIdEmpresa;
    }

    public void setBcIdIdentificaLancamento(Long bcIdIdentificaLancamento) {
        this.bcIdIdentificaLancamento = bcIdIdentificaLancamento;
    }

    public Long getBcIdIdentificaLancamento() {
        return bcIdIdentificaLancamento;
    }

    public void setBcQuemPaga(String bcQuemPaga) {
        this.bcQuemPaga = bcQuemPaga;
    }

    public String getBcQuemPaga() {
        return bcQuemPaga;
    }

    public void setBcIdHotel(Long bcIdHotel) {
        this.bcIdHotel = bcIdHotel;
    }

    public Long getBcIdHotel() {
        return bcIdHotel;
    }
}
