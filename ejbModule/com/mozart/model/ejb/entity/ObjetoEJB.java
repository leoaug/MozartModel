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
@NamedQuery(name = "ObjetoEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from ObjetoEJB o")
@Table(name = "OBJETO")
public class ObjetoEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 2442561784892096909L;
	@Column(nullable = false)
    private String descricao;
    private String fantasia;
    @Column(name="ID_HOTEL", nullable = false)
    private Long idHotel;
    @Id
    @SequenceGenerator(name="seqObjeto", sequenceName="id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqObjeto")
    @Column(name="ID_OBJETO", nullable = false)
    private Long idObjeto;
    private Double valor;


    public ObjetoEJB() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Long idObjeto) {
        this.idObjeto = idObjeto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
