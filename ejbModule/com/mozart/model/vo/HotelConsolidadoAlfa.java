package com.mozart.model.vo;

import com.mozart.model.vo.filtro.FiltroWeb;

import java.math.BigDecimal;

public class HotelConsolidadoAlfa extends MozartVO {


    /**
	 * 
	 */
	private static final long serialVersionUID = -384925871157373969L;

	private FiltroWeb filtroVigencia;

    private FiltroWeb filtroDataSaida;

    private Long[] idHoteis;
    private Long idSeguradora;
    private String redeHotel;
    private String hotel;
    private String vigencia;
    private Long qtdeDiaria;
    private Double vlSeguro;
    private Double vlManutencao;
    private Long qtdeApto;
    private Double vlTotalManutencao;
    private Double vlDatacenter;
    private Double vlTotalDatacenter;
    private Double vlTotalPagar;
    private Double vlTotalSeguro;
    
    
    public HotelConsolidadoAlfa() {        
        filtroVigencia = new FiltroWeb();    
        filtroDataSaida = new FiltroWeb();    
    }


    
	public HotelConsolidadoAlfa(Object[] pLinha) {
        Object[] linha = pLinha;
        if (linha != null){
            int id = 0;                    
            redeHotel         = (String)linha[ id++ ];
            hotel             = (String)linha[ id++ ];
            //vigencia          =  new Date ( ((Timestamp)linha[ id++ ]).getTime() );
             vigencia         =  (String)linha[ id++ ];
            qtdeDiaria        = ((BigDecimal)linha[ id++ ]).longValue();

            vlSeguro          = ((BigDecimal)linha[ id++ ]).doubleValue();
            vlManutencao      = ((BigDecimal)linha[ id++ ]).doubleValue();
            qtdeApto          = ((BigDecimal)linha[ id++ ]).longValue();

            vlTotalManutencao = ((BigDecimal)linha[ id++ ]).doubleValue();
            vlDatacenter      = ((BigDecimal)linha[ id++ ]).doubleValue();
            vlTotalDatacenter = ((BigDecimal)linha[ id++ ]).doubleValue();
            vlTotalPagar      = ((BigDecimal)linha[ id++ ]).doubleValue();
            vlTotalSeguro     = ((BigDecimal)linha[ id++ ]).doubleValue();
        }
    }
    

    public void setIdHoteis(Long[] idHoteis) {
        this.idHoteis = idHoteis;
    }

    public Long[] getIdHoteis() {
        return idHoteis;
    }

    public void setRedeHotel(String redeHotel) {
        this.redeHotel = redeHotel;
    }

    public String getRedeHotel() {
        return redeHotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getHotel() {
        return hotel;
    }

    public void setQtdeDiaria(Long qtdeDiaria) {
        this.qtdeDiaria = qtdeDiaria;
    }

    public Long getQtdeDiaria() {
        return qtdeDiaria;
    }

    public void setVlSeguro(Double vlSeguro) {
        this.vlSeguro = vlSeguro;
    }

    public Double getVlSeguro() {
        return vlSeguro;
    }

    public void setVlManutencao(Double vlManutencao) {
        this.vlManutencao = vlManutencao;
    }

    public Double getVlManutencao() {
        return vlManutencao;
    }

    public void setQtdeApto(Long qtdeApto) {
        this.qtdeApto = qtdeApto;
    }

    public Long getQtdeApto() {
        return qtdeApto;
    }

    public void setVlTotalManutencao(Double vlTotalManutencao) {
        this.vlTotalManutencao = vlTotalManutencao;
    }

    public Double getVlTotalManutencao() {
        return vlTotalManutencao;
    }

    public void setVlDatacenter(Double vlDatacenter) {
        this.vlDatacenter = vlDatacenter;
    }

    public Double getVlDatacenter() {
        return vlDatacenter;
    }

    public void setVlTotalDatacenter(Double vlTotalDatacenter) {
        this.vlTotalDatacenter = vlTotalDatacenter;
    }

    public Double getVlTotalDatacenter() {
        return vlTotalDatacenter;
    }

    public void setVlTotalPagar(Double vlTotalPagar) {
        this.vlTotalPagar = vlTotalPagar;
    }

    public Double getVlTotalPagar() {
        return vlTotalPagar;
    }

    public void setIdSeguradora(Long idSeguradora) {
        this.idSeguradora = idSeguradora;
    }

    public Long getIdSeguradora() {
        return idSeguradora;
    }

    public void setFiltroVigencia(FiltroWeb filtroVigencia) {
        this.filtroVigencia = filtroVigencia;
    }

    public FiltroWeb getFiltroVigencia() {
        return filtroVigencia;
    }

    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }

    public String getVigencia() {
        return vigencia;
    }

    public void setVlTotalSeguro(Double vlTotalSeguro) {
        this.vlTotalSeguro = vlTotalSeguro;
    }

    public Double getVlTotalSeguro() {
        return vlTotalSeguro;
    }

    public void setFiltroDataSaida(FiltroWeb filtroDataSaida) {
        this.filtroDataSaida = filtroDataSaida;
    }

    public FiltroWeb getFiltroDataSaida() {
        return filtroDataSaida;
    }

}
