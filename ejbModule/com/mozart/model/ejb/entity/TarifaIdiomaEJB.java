package com.mozart.model.ejb.entity;

import java.io.Serializable;
import java.util.Comparator;

import javax.persistence.*;


/**
 * The persistent class for the TARIFA_IDIOMA database table.
 * 
 */
@Entity
@Table(name="TARIFA_IDIOMA")
public class TarifaIdiomaEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TARIFA_IDIOMA_IDTARIFAIDIOMA_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TARIFA_IDIOMA_IDTARIFAIDIOMA_GENERATOR")
	@Column(name="ID_TARIFA_IDIOMA")
	private Long idTarifaIdioma;

	@Column(name="DESCRICAO_WEB")
	private String descricaoWeb;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
		@JoinColumn(name = "ID_TARIFA", referencedColumnName="ID_TARIFA")
	})
	private TarifaEJB tarifaEJB;

	@OneToOne
	@JoinColumn(name="ID_IDIOMA")
	private IdiomaMozartEJB idiomaMozart;

	
	@SuppressWarnings("unchecked")
	public static Comparator getComparator(){
        return new Comparator(){
            public int compare(Object o1, Object o2) {
                TarifaIdiomaEJB primeiro = (TarifaIdiomaEJB)o1;
                TarifaIdiomaEJB segundo = (TarifaIdiomaEJB)o2;
                
                String valorPrimeiro = primeiro.getIdiomaMozart().getDescricao();
                String valorSegundo = segundo.getIdiomaMozart().getDescricao();
                    
                return valorPrimeiro.compareTo( valorSegundo );
            }
        };
    }
	
    public TarifaIdiomaEJB() {
    }

	public long getIdTarifaIdioma() {
		return this.idTarifaIdioma;
	}

	public void setIdTarifaIdioma(Long idTarifaIdioma) {
		this.idTarifaIdioma = idTarifaIdioma;
	}

	public String getDescricaoWeb() {
		return this.descricaoWeb;
	}

	public void setDescricaoWeb(String descricaoWeb) {
		this.descricaoWeb = descricaoWeb;
	}

	public IdiomaMozartEJB getIdiomaMozart() {
		return this.idiomaMozart;
	}

	public void setIdiomaMozart(IdiomaMozartEJB idiomaMozart) {
		this.idiomaMozart = idiomaMozart;
	}

	public TarifaEJB getTarifaEJB() {
		return tarifaEJB;
	}

	public void setTarifaEJB(TarifaEJB tarifaEJB) {
		this.tarifaEJB = tarifaEJB;
	}
	
}