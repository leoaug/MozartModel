package com.mozart.model.ejb.entity;

import java.util.Comparator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@NamedQueries({
@NamedQuery(name = "CidadeEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from CidadeEJB o"),
@NamedQuery(name = "CidadeEJB.findByName", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from CidadeEJB o where o.cidade like ?1 order by o.cidade")
})
@Table(name = "CIDADE")
public class CidadeEJB extends MozartEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5046002663877151497L;
	@Column(nullable = false)
    private String cidade;
    private String ddd;
    @Id
    @SequenceGenerator(name="CIDADE_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CIDADE_GENERATOR")
    @Column(name="ID_CIDADE", nullable = false)
    private Long idCidade;
    
    @JoinColumn(name="ID_ESTADO", referencedColumnName="ID_ESTADO")
    private EstadoEJB estado;
    @Column(name="ID_REDE_HOTEL")
    private Long idRedeHotel;
    @Column(name="CODIGO_IBGE")
    private Long codigoIbge;

    
    @SuppressWarnings("unchecked")
	public static Comparator getComparator(){
        return new Comparator(){
            public int compare(Object o1, Object o2) {
                CidadeEJB primeiro = (CidadeEJB)o1;
                CidadeEJB segundo = (CidadeEJB)o2;
                
                String valorPrimeiro = primeiro.getEstado().getEstado()+""+
						               primeiro.getCidade();                       

                String valorSegundo = segundo.getEstado().getEstado()+""+
						              segundo.getCidade();
                    
                return valorPrimeiro.compareTo( valorSegundo );
            }
        };
    }
    
    public String toString(){
    	return cidade  + (estado == null?"":" - "+estado.getUf());
    }
    
    public CidadeEJB() {
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public Long getIdRedeHotel() {
        return idRedeHotel;
    }

    public void setIdRedeHotel(Long idRedeHotel) {
        this.idRedeHotel = idRedeHotel;
    }

    public void setEstado(EstadoEJB estado) {
        this.estado = estado;
    }

    public EstadoEJB getEstado() {
        return estado;
    }

	public Long getCodigoIbge() {
		return codigoIbge;
	}

	public void setCodigoIbge(Long codigoIbge) {
		this.codigoIbge = codigoIbge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idCidade == null) ? 0 : idCidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CidadeEJB other = (CidadeEJB) obj;
		if (idCidade == null) {
			if (other.idCidade != null)
				return false;
		} else if (!idCidade.equals(other.idCidade))
			return false;
		return true;
	}
}
