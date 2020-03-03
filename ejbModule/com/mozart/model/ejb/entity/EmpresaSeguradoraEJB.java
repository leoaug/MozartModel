package com.mozart.model.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;



@Entity
@NamedQuery(name = "EmpresaSeguradoraEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from EmpresaSeguradoraEJB o")
@Table(name = "EMPRESA_SEGURADORA")
@IdClass(EmpresaSeguradoraEJBPK.class)
public class EmpresaSeguradoraEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4391242903995843339L;
	@Column(name="DT_FIM_SEGURO")
    private Timestamp dtFimSeguro;
    
    @Column(name="DT_INICIO_SEGURO", nullable = false)
    private Timestamp dtInicioSeguro;
    @Id
    @Column(name="ID_HOTEL_SEGURADO", nullable = false, insertable = false, 
        updatable = false)
    private Long idHotelSegurado;
    @Id
    @Column(name="ID_SEGURADORA", nullable = false, insertable = true, 
        updatable = true)
    private Long idSeguradora;
    
    @Column(name="DIA_VENCIMENTO", nullable = true)
    private Long diaVencimento;
    @Column(name="VL_SEGURO", nullable = false)
    private Double vlSeguro;
    @Column(name="VALOR_MANUTENCAO", nullable = false)
    private Double vlManutencao;
    @Column(name="VALOR_DATACENTER", nullable = false)
    private Double vlDatacenter;

    @ManyToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "ID_HOTEL_SEGURADO", referencedColumnName = "ID_HOTEL")
    private HotelEJB segurado;

    @Column(name="NUM_CONTRATO_APOLICE", nullable = false)
    private Long numContratoApolice;

    @Column(name="NUM_SUB_CONTRATO_APOLICE", nullable = false)
    private Long numSubContratoApolice;

    @Column(name="NUM_PLANO_APOLICE", nullable = false)
    private Long numPlanoApolice;

    public EmpresaSeguradoraEJB() {
    }

    public Timestamp getDtFimSeguro() {
        return dtFimSeguro;
    }

    public void setDtFimSeguro(Timestamp dtFimSeguro) {
        this.dtFimSeguro = dtFimSeguro;
    }

    public Timestamp getDtInicioSeguro() {
        return dtInicioSeguro;
    }

    public void setDtInicioSeguro(Timestamp dtInicioSeguro) {
        this.dtInicioSeguro = dtInicioSeguro;
    }

    public Long getIdHotelSegurado() {
        return idHotelSegurado;
    }

    public void setIdHotelSegurado(Long idHotelSegurado) {
        this.idHotelSegurado = idHotelSegurado;
    }

    public Long getIdSeguradora() {
        return idSeguradora;
    }

    public void setIdSeguradora(Long idSeguradora) {
        this.idSeguradora = idSeguradora;
    }

    public Double getVlSeguro() {
        return vlSeguro;
    }

    public void setVlSeguro(Double vlSeguro) {
        this.vlSeguro = vlSeguro;
    }
    
    public void setSegurado(HotelEJB segurado) {
        this.segurado = segurado;
    }

    public HotelEJB getSegurado() {
        return segurado;
    }

    public void setDiaVencimento(Long diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

    public Long getDiaVencimento() {
        return diaVencimento;
    }

    public void setVlManutencao(Double vlManutencao) {
        this.vlManutencao = vlManutencao;
    }

    public Double getVlManutencao() {
        return vlManutencao;
    }

    public void setVlDatacenter(Double vlDatacenter) {
        this.vlDatacenter = vlDatacenter;
    }

    public Double getVlDatacenter() {
        return vlDatacenter;
    }

    public void setNumContratoApolice(Long numContratoApolice) {
        this.numContratoApolice = numContratoApolice;
    }

    public Long getNumContratoApolice() {
        return numContratoApolice;
    }

    public void setNumSubContratoApolice(Long numSubContratoApolice) {
        this.numSubContratoApolice = numSubContratoApolice;
    }

    public Long getNumSubContratoApolice() {
        return numSubContratoApolice;
    }

    public void setNumPlanoApolice(Long numPlanoApolice) {
        this.numPlanoApolice = numPlanoApolice;
    }

    public Long getNumPlanoApolice() {
        return numPlanoApolice;
    }
    
    public boolean equals(Object other) {
        if (other instanceof EmpresaSeguradoraEJBPK) {
            final EmpresaSeguradoraEJB otherEmpresaSeguradoraEJBPK = (EmpresaSeguradoraEJB) other;
            final boolean areEqual = otherEmpresaSeguradoraEJBPK.getIdHotelSegurado().equals(idHotelSegurado);
            return areEqual;
        }
        return false;
    }

    
}
