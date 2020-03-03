package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "TipoDiariaEJB.findAllByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from TipoDiariaEJB o where o.idRedeHotel =?1 order by o.descricao")
@Table(name = "TIPO_DIARIA")

public class TipoDiariaEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
    private String descricao;
	
	@Column(name="ID_REDE_HOTEL", nullable = false)
    private Long idRedeHotel;
    @Id
    @SequenceGenerator(name="TIPO_DIARIA_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_DIARIA_GENERATOR")
	@Column(name="ID_TIPO_DIARIA", nullable = false)
    private Long idTipoDiaria;
    @Column(nullable = false)
    private String padrao;

    public TipoDiariaEJB() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getIdRedeHotel() {
        return idRedeHotel;
    }

    public void setIdRedeHotel(Long idRedeHotel) {
        this.idRedeHotel = idRedeHotel;
    }

    public Long getIdTipoDiaria() {
        return idTipoDiaria;
    }

    public void setIdTipoDiaria(Long idTipoDiaria) {
        this.idTipoDiaria = idTipoDiaria;
    }

    public String getPadrao() {
        return padrao;
    }

    public void setPadrao(String padrao) {
        this.padrao = padrao;
    }

}
