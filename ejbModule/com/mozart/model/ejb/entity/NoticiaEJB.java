package com.mozart.model.ejb.entity;

import javax.persistence.*;

import java.util.Comparator;
import java.sql.Timestamp;


/**
 * The persistent class for the NOTICIA database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "NoticiaEJB.findByHotel", 
			hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
			query = "select o from NoticiaEJB o where o.idHotel = ?1 order by o.data desc"),
	@NamedQuery(name = "NoticiaEJB.findByIdNoticia", 
					hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
					query = "select o from NoticiaEJB o where o.id.idNoticia = ?1"),
})
@Table(name="NOTICIA")
public class NoticiaEJB extends MozartEntity  {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NoticiaPK id;

	private String ativo;

    
	private Timestamp data;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_PROGRAMA")
	private Long idPrograma;

	@ManyToOne(cascade={CascadeType.REFRESH}, fetch=FetchType.EAGER)
	@JoinColumn(name="ID_IDIOMA", referencedColumnName="ID_IDIOMA", insertable=false, updatable=false)
	private IdiomaMozartEJB idioma;

	private String noticia;

	private String resumo;

	private String titulo;

    public NoticiaEJB() {
    }
    
    
    @SuppressWarnings("unchecked")
	public static Comparator getComparator(){
        return new Comparator(){
            public int compare(Object o1, Object o2) {
            	NoticiaEJB primeiro = (NoticiaEJB)o1;
            	NoticiaEJB segundo = (NoticiaEJB)o2;
                
                String valorPrimeiro = primeiro.getIdioma()==null?primeiro.getData().getTime()+"":primeiro.getIdioma().getIdIdioma()+"";

                String valorSegundo = segundo.getIdioma()==null?segundo.getData().getTime()+"":segundo.getIdioma().getIdIdioma()+"";
                    
                return valorPrimeiro.compareTo( valorSegundo );
            }
        };
    }

    

	public NoticiaPK getId() {
		return this.id;
	}

	public void setId(NoticiaPK id) {
		this.id = id;
	}
	
	public String getAtivo() {
		return this.ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getNoticia() {
		return this.noticia;
	}

	public void setNoticia(String noticia) {
		this.noticia = noticia;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public IdiomaMozartEJB getIdioma() {
		return idioma;
	}

	public void setIdioma(IdiomaMozartEJB idioma) {
		this.idioma = idioma;
	}


	public Long getIdPrograma() {
		return idPrograma;
	}


	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}

}