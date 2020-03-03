package com.mozart.model.ejb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
//import javax.persistence.IdClass;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@NamedQueries({
@NamedQuery(name = "TipoHospedeEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from TipoHospedeEJB o"), 
@NamedQuery(name = "TipoHospedeEJB.findByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    	    query = "select o from TipoHospedeEJB o where o.idRedeHotel=?1 order by o.tipoHospede")
})
@Table(name = "TIPO_HOSPEDE")
//@IdClass(TipoHospedeEJBPK.class)
public class TipoHospedeEJB extends MozartEntity {
  
    @Column(name="ID_REDE_HOTEL", nullable = false)
    private Long idRedeHotel;
    @Id
    @SequenceGenerator(name="TIPO_HOSPEDE_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_HOSPEDE_GENERATOR")
	@Column(name="ID_TIPO_HOSPEDE", nullable = false)
    private Long idTipoHospede;
    private Long padrao;
    @Column(name="TIPO_HOSPEDE", nullable = false)
    private String tipoHospede;

    public TipoHospedeEJB() {

	}

	public Long getIdRedeHotel() {
        return idRedeHotel;
    }

    public void setIdRedeHotel(Long idRedeHotel) {
        this.idRedeHotel = idRedeHotel;
    }

    public Long getIdTipoHospede() {
        return idTipoHospede;
    }

    public void setIdTipoHospede(Long idTipoHospede) {
        this.idTipoHospede = idTipoHospede;
    }

    public Long getPadrao() {
        return padrao;
    }

    public void setPadrao(Long padrao) {
        this.padrao = padrao;
    }

    public String getTipoHospede() {
        return tipoHospede;
    }

    public void setTipoHospede(String tipoHospede) {
        this.tipoHospede = tipoHospede;
    }
    
    
	public EmpresaRedeEJB getEmpresaEJB() {

		return null;
	}

	public Object getHospedeEJB() {

		return null;
	}

	public void setIdHotel(Long long1) {

		
	}
   
}