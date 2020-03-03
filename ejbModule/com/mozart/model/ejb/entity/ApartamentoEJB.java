package com.mozart.model.ejb.entity;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mozart.model.util.MozartUtil;


@Entity
@NamedQueries({
@NamedQuery(name = "ApartamentoEJB.findByTipo", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from ApartamentoEJB o where o.idHotel = ?1 and o.tipoApartamentoEJB.idTipoApartamento = ?2 order by o.numApartamento")
})
@Table(name = "APARTAMENTO")
public class ApartamentoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4773888904274261310L;
	private String area;
    private String bloco;
    private String caracteristica;
    @Column(nullable = false)
    private String checkout;
    @Column(nullable = false)
    private String cofan;
    @Column(name="DATA_ENTRADA")
    private Timestamp dataEntrada;
    @Column(name="DATA_SAIDA")
    private Timestamp dataSaida;
    @Column(name="DEPOSITO_ANTECIPADO", nullable = false)
    private String depositoAntecipado;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqAptos")
    @SequenceGenerator(name="idSeqAptos", sequenceName="id", allocationSize=1)
    @Column(name="ID_APARTAMENTO", nullable = false)
    private Long idApartamento;
    @ManyToOne
    @JoinColumn(name = "ID_CAMAREIRA", referencedColumnName = "ID_CAMAREIRA")
    private CamareiraEJB camareira;
    
    @Column(name="ID_HOTEL")
    private Long idHotel;
    @Column(name="NUM_APARTAMENTO")
    private Long numApartamento;
    private String observacao;
    private String status;
    @OneToOne
    @JoinColumn(name = "ID_TIPO_APARTAMENTO", referencedColumnName = "ID_TIPO_APARTAMENTO")
    private TipoApartamentoEJB tipoApartamentoEJB;
    
    
    public boolean equals(Object obj){
    	if (obj == null || !(obj instanceof ApartamentoEJB))
    		return false;
    	return idApartamento.equals( ((ApartamentoEJB)obj).getIdApartamento() );
    }
    public String toString(){
    
        return (MozartUtil.isNull(bloco)?numApartamento:bloco)+" "+(tipoApartamentoEJB!=null?tipoApartamentoEJB.getFantasia():"")+" "+status;
    }

    public ApartamentoEJB() {
    	tipoApartamentoEJB = new TipoApartamentoEJB();
    	camareira = new CamareiraEJB();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public String getCofan() {
        return cofan;
    }

    public void setCofan(String cofan) {
        this.cofan = cofan;
    }

    public Timestamp getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Timestamp dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Timestamp getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Timestamp dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDepositoAntecipado() {
        return depositoAntecipado;
    }

    public void setDepositoAntecipado(String depositoAntecipado) {
        this.depositoAntecipado = depositoAntecipado;
    }

    public Long getIdApartamento() {
        return idApartamento;
    }

    public void setIdApartamento(Long idApartamento) {
        this.idApartamento = idApartamento;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }


    public Long getNumApartamento() {
        return numApartamento;
    }

    public void setNumApartamento(Long numApartamento) {
        this.numApartamento = numApartamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TipoApartamentoEJB getTipoApartamentoEJB() {
        return tipoApartamentoEJB;
    }

    public void setTipoApartamentoEJB(TipoApartamentoEJB tipoApartamentoEJB) {
        this.tipoApartamentoEJB = tipoApartamentoEJB;
    }

	public CamareiraEJB getCamareira() {
		return camareira;
	}

	public void setCamareira(CamareiraEJB camareira) {
		this.camareira = camareira;
	}


  
}
