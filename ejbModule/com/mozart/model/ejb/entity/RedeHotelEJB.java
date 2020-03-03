package com.mozart.model.ejb.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.mozart.model.util.MozartUtil;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "RedeHotelEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),
    query = "select o from RedeHotelEJB o")
@Table(name = "REDE_HOTEL")
public class RedeHotelEJB extends MozartEntity {
    private String automatico;
    private String bairro;
    private String cep;
    private String cgc;
    private String email;
    private String endereco;
    @Column(name="ENDERECO_LOGOTIPO")
    private String enderecoLogotipo;
    private Long expirar;
    private String fax;
    @Column(name="FORA_ANO")
    private String foraAno;
    @Column(name="ID_CIDADE", nullable = false)
    private Long idCidade;
    @Id
    @Column(name="ID_REDE_HOTEL", nullable = false)
    private Long idRedeHotel;
    @Column(name="INSC_EMBRATUR")
    private String inscEmbratur;
    @Column(name="INSC_ESTADUAL")
    private String inscEstadual;
    @Column(name="INSC_MUNICIPAL")
    private String inscMunicipal;
    @Column(name="LINK_VOUCHER")
    private String linkVoucher;
    @Column(name="NOME_FANTASIA")
    private String nomeFantasia;
    @Column(name="QTD_VALOR")
    private String qtdValor;
    @Column(name="RAZAO_SOCIAL")
    private String razaoSocial;
    private String sigla;
    private String telefone;
    private String telex;
    @Column(name="VALOR_INSCRICAO")
    private Double valorInscricao;
    @Column(name="ID_PROGRAMA")
    private Long idPrograma;
    
    //@OneToMany(mappedBy="redeHotelEJB", fetch=FetchType.LAZY)
    @Transient
    private List<com.mozart.model.ejb.entity.HotelEJB> hoteis;
    
    @Transient
    private CentralReservaEJB crsPropria;
    
    @Column(name="FORMATO_CONTA")
    private String formatoConta;
    
    private String ativo;

    public RedeHotelEJB() {
    }

    public String getAutomatico() {
        return automatico;
    }

    public void setAutomatico(String automatico) {
        this.automatico = automatico;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return MozartUtil.formatCEP(cep);
    }

    public void setCep(String cep) {
    	cep = MozartUtil.removerNaoNumericos(cep);
		if (!MozartUtil.validarCEP(cep))
			throw new IllegalArgumentException("CEP informado está em formato inválido.");
		this.cep = cep;
    }

    public String getCgc() {
        return cgc;
    }

    public void setCgc(String cgc) {
        this.cgc = cgc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEnderecoLogotipo() {
        return enderecoLogotipo;
    }

    public void setEnderecoLogotipo(String enderecoLogotipo) {
        this.enderecoLogotipo = enderecoLogotipo;
    }

    public Long getExpirar() {
        return expirar;
    }

    public void setExpirar(Long expirar) {
        this.expirar = expirar;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getForaAno() {
        return foraAno;
    }

    public void setForaAno(String foraAno) {
        this.foraAno = foraAno;
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

    public String getInscEmbratur() {
        return inscEmbratur;
    }

    public void setInscEmbratur(String inscEmbratur) {
        this.inscEmbratur = inscEmbratur;
    }

    public String getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    public String getInscMunicipal() {
        return inscMunicipal;
    }

    public void setInscMunicipal(String inscMunicipal) {
        this.inscMunicipal = inscMunicipal;
    }

    public String getLinkVoucher() {
        return linkVoucher;
    }

    public void setLinkVoucher(String linkVoucher) {
        this.linkVoucher = linkVoucher;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getQtdValor() {
        return qtdValor;
    }

    public void setQtdValor(String qtdValor) {
        this.qtdValor = qtdValor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelex() {
        return telex;
    }

    public void setTelex(String telex) {
        this.telex = telex;
    }

    public Double getValorInscricao() {
        return valorInscricao;
    }

    public void setValorInscricao(Double valorInscricao) {
        this.valorInscricao = valorInscricao;
    }

    public void setHoteis(List<com.mozart.model.ejb.entity.HotelEJB> hoteis) {
        this.hoteis = hoteis;
    }

    public List<com.mozart.model.ejb.entity.HotelEJB> getHoteis() {
        return hoteis;
    }

	public CentralReservaEJB getCrsPropria() {
		return crsPropria;
	}

	public void setCrsPropria(CentralReservaEJB crsPropria) {
		this.crsPropria = crsPropria;
	}

	public String getFormatoConta() {
		return formatoConta;
	}

	public void setFormatoConta(String formatoConta) {
		this.formatoConta = formatoConta;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	
	public Long getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idRedeHotel == null) ? 0 : idRedeHotel.hashCode());
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
		RedeHotelEJB other = (RedeHotelEJB) obj;
		if (idRedeHotel == null) {
			if (other.getIdRedeHotel() != null)
				return false;
		} else if (!idRedeHotel.equals(other.getIdRedeHotel()))
			return false;
		return true;
	}
}
