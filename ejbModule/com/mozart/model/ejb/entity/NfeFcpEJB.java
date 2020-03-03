package com.mozart.model.ejb.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "NfeFcpEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from NfeFcpEJB o")
@Table(name = "NFE_FCP")
public class NfeFcpEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7074632989960534299L;
	
	@Id
    @Column(name="ID_NFE_FCP")
	@SequenceGenerator(name="SEQ_MOVIMENTO_ESTOQUE", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_MOVIMENTO_ESTOQUE")
	private Long idNfeFcp;
	
	@ManyToOne
	@JoinColumn(name = "ID_ESTADO", insertable=true, updatable=true, referencedColumnName = "ID_ESTADO")
	private EstadoEJB estado;
	
    @Column(name="PERCENTUAL")
    private Double percentual;
    
    public NfeFcpEJB() {
    }

	public Long getIdNfeFcp() {
		return idNfeFcp;
	}

	public void setIdNfeFcp(Long idNfeFcp) {
		this.idNfeFcp = idNfeFcp;
	}

	public EstadoEJB getEstado() {
		return estado;
	}

	public void setEstado(EstadoEJB estado) {
		this.estado = estado;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}
}
