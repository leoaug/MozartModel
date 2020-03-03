package com.mozart.model.ejb.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TELEFONIAS database table.
 * 
 */
@Entity
@Table(name="TELEFONIAS")
public class TelefoniaEJB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TELEFONIAS_IDTELEFONIA_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TELEFONIAS_IDTELEFONIA_GENERATOR")
	@Column(name="ID_TELEFONIA")
	private Long idTelefonia;

	private String nome;

    public TelefoniaEJB() {
    }

	public Long getIdTelefonia() {
		return this.idTelefonia;
	}

	public void setIdTelefonia(Long idTelefonia) {
		this.idTelefonia = idTelefonia;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}