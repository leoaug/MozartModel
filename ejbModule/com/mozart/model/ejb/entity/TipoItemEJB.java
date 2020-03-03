package com.mozart.model.ejb.entity;

import javax.persistence.*;


/**
 * The persistent class for the TIPO_ITEM database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name = "TipoItemEJB.findByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
			query = "select o from TipoItemEJB o where o.idRedeHotel = ?1 order by o.nomeTipo"),
@NamedQuery(name = "TipoItemEJB.findLikeNomeByRede", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
			query = "select o from TipoItemEJB o where o.idRedeHotel = ?1 and o.nomeTipo like ?2 order by o.nomeTipo")
})
@Table(name="TIPO_ITEM")
public class TipoItemEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TIPO_ITEM_IDTIPOITEM_GENERATOR", sequenceName="ID", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_ITEM_IDTIPOITEM_GENERATOR")
	@Column(name="ID_TIPO_ITEM")
	private Long idTipoItem;

	private String apelido;

	@Column(name="ID_REDE_HOTEL")
	private Long idRedeHotel;

	@Column(name="NOME_TIPO")
	private String nomeTipo;

    public TipoItemEJB() {
    }

	public Long getIdTipoItem() {
		return this.idTipoItem;
	}

	public void setIdTipoItem(Long idTipoItem) {
		this.idTipoItem = idTipoItem;
	}

	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Long getIdRedeHotel() {
		return this.idRedeHotel;
	}

	public void setIdRedeHotel(Long idRedeHotel) {
		this.idRedeHotel = idRedeHotel;
	}

	public String getNomeTipo() {
		return this.nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

}