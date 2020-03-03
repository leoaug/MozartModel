package com.mozart.model.vo;



public class ReservaGrupoLancamentoVO extends MozartVO {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 6774792281294797180L;
	private Long bcIdCentralReserva;
    private Long bcIdReserva;
    private Long bcIdIdentificaLancamento;
    private String bcQuemPaga;
    private Long bcIdHotel;
    private Long bcIdEmpresa;        
    
    
	public void setaDados(Object[] pLinha) {    
        setLinha(pLinha);
        bcIdCentralReserva = getLong();
        bcIdReserva = getLong();
        bcIdIdentificaLancamento = getLong();
        bcQuemPaga = getString();
        bcIdHotel = getLong();
        bcIdEmpresa = getLong();
    }
    
    public ReservaGrupoLancamentoVO() {
    }


    public void setBcIdCentralReserva(Long bcIdCentralReserva) {
        this.bcIdCentralReserva = bcIdCentralReserva;
    }

    public Long getBcIdCentralReserva() {
        return bcIdCentralReserva;
    }

    public void setBcIdReserva(Long bcIdReserva) {
        this.bcIdReserva = bcIdReserva;
    }

    public Long getBcIdReserva() {
        return bcIdReserva;
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

    public void setBcIdEmpresa(Long bcIdEmpresa) {
        this.bcIdEmpresa = bcIdEmpresa;
    }

    public Long getBcIdEmpresa() {
        return bcIdEmpresa;
    }
}
