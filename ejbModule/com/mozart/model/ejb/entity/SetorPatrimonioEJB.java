package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PATRIMONIO_SETOR database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name = "SetorPatrimonioEJB.findByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
	    	    query = "select o from SetorPatrimonioEJB o where o.idRedeHotel=?1 order by o.descricao")
	})
@Table(name="PATRIMONIO_SETOR")
public class SetorPatrimonioEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PATRIMONIO_SETOR_IDPATRIMONIOSETOR_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PATRIMONIO_SETOR_IDPATRIMONIOSETOR_GENERATOR")
	@Column(name="ID_PATRIMONIO_SETOR")
	private Long idSetorPatrimonio;

	private String descricao;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="NOME_FANTASIA")
	private String nomeFantasia;

    public SetorPatrimonioEJB() {
    }
    
    public Long getIdSetorPatrimonio() {
		return this.idSetorPatrimonio;
	}

	public void setIdSetorPatrimonio(Long idSetorPatrimonio) {
		this.idSetorPatrimonio = idSetorPatrimonio;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public void setUsuario(UsuarioEJB usuarioEJB) {

		
	}

}