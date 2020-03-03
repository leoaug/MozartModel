package com.mozart.model.ejb.entity;


import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mozart.model.util.MozartUtil;

@SuppressWarnings("serial")
@Entity
@NamedQuery(name = "HospedeEJB.findAll", hints=@QueryHint(name="eclipselink.refresh", value="TRUE"),query = "select o from HospedeEJB o")
@Table(name = "HOSPEDE")
public class HospedeEJB extends MozartEntity {
    private String bairro;
    private String celular;
    private String cep;
    private String cnpj;
    private String complemento;
    private String cpf;
    private String credito;
    private String ddd;
    private String ddi;
    private String email;
    private String endereco;
    private String fax;
    @Column(name="FIDELIDADE_DATA")
    private Timestamp fidelidadeData;
    @Column(name="FLAG_CONDO")
    private String flagCondo;
    private String identidade;
    @Column(name="ID_BAIRRO", nullable = false)
    private Long idBairro;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CIDADE", referencedColumnName = "ID_CIDADE")
    private CidadeEJB cidadeEJB;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE ,generator="idSeqHos")
    @SequenceGenerator(name="idSeqHos", sequenceName="id", allocationSize=1)
    @Column(name="ID_HOSPEDE", nullable = false)
    private Long idHospede;
    @Column(name="ID_HOTEL")
    private Long idHotel;
    @Column(name="ID_PROFISSAO")
    private Long idProfissao;
    @Column(name="ID_REDE_HOTEL")
    private Long idRedeHotel;

    @OneToOne(cascade={CascadeType.REFRESH})
    @JoinColumn(name = "ID_TIPO_HOSPEDE", referencedColumnName = "ID_TIPO_HOSPEDE")
    private TipoHospedeEJB tipoHospedeEJB;

    private String nacionalidade;
    
    private Timestamp nascimento;
    @Column(name="NOME_EMERGENCIA")
    private String nomeEmergencia;
    @Column(name="NOME_HOSPEDE", nullable = false)
    private String nomeHospede;
    private String observacao;
    @Column(name="ORGAO_EXPEDIDOR")
    private String orgaoExpedidor;
    private String passaporte;
    private String referencia;
    private String sexo;
    @Column(name="SOBRENOME_EMERGENCIA")
    private String sobrenomeEmergencia;
    @Column(name="SOBRENOME_HOSPEDE", nullable = false)
    private String sobrenomeHospede;
    private String telefone;
    @Column(name="TELEFONE_EMERGENCIA")
    private String telefoneEmergencia;
    private String telex;
    private String numero;

    public HospedeEJB() {
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getDdi() {
        return ddi;
    }

    public void setDdi(String ddi) {
        this.ddi = ddi;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Timestamp getFidelidadeData() {
        return fidelidadeData;
    }

    public void setFidelidadeData(Timestamp fidelidadeData) {
        this.fidelidadeData = fidelidadeData;
    }

    public String getFlagCondo() {
        return flagCondo;
    }

    public void setFlagCondo(String flagCondo) {
        this.flagCondo = flagCondo;
    }

    public String getIdentidade() {
        return identidade;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public Long getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Long idBairro) {
        this.idBairro = idBairro;
    }


    public Long getIdHospede() {
        return idHospede;
    }

    public void setIdHospede(Long idHospede) {
        this.idHospede = idHospede;
    }

    public Long getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Long idHotel) {
        this.idHotel = idHotel;
    }

    public Long getIdProfissao() {
        return idProfissao;
    }

    public void setIdProfissao(Long idProfissao) {
        this.idProfissao = idProfissao;
    }

    public Long getIdRedeHotel() {
        return idRedeHotel;
    }

    public void setIdRedeHotel(Long idRedeHotel) {
        this.idRedeHotel = idRedeHotel;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Timestamp getNascimento() {
        return nascimento;
    }

    public void setNascimento(Timestamp nascimento) {
        this.nascimento = nascimento;
    }

    public String getNomeEmergencia() {
        return nomeEmergencia;
    }

    public void setNomeEmergencia(String nomeEmergencia) {
        this.nomeEmergencia = nomeEmergencia;
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public void setNomeHospede(String nomeHospede) {
        this.nomeHospede = nomeHospede;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getOrgaoExpedidor() {
        return orgaoExpedidor;
    }

    public void setOrgaoExpedidor(String orgaoExpedidor) {
        this.orgaoExpedidor = orgaoExpedidor;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSobrenomeEmergencia() {
        return sobrenomeEmergencia;
    }

    public void setSobrenomeEmergencia(String sobrenomeEmergencia) {
        this.sobrenomeEmergencia = sobrenomeEmergencia;
    }

    public String getSobrenomeHospede() {
        return sobrenomeHospede;
    }

    public void setSobrenomeHospede(String sobrenomeHospede) {
        this.sobrenomeHospede = sobrenomeHospede;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefoneEmergencia() {
        return telefoneEmergencia;
    }

    public void setTelefoneEmergencia(String telefoneEmergencia) {
        this.telefoneEmergencia = telefoneEmergencia;
    }

    public String getTelex() {
        return telex;
    }

    public void setTelex(String telex) {
        this.telex = telex;
    }

    public void setCidadeEJB(CidadeEJB cidadeEJB) {
        this.cidadeEJB = cidadeEJB;
    }

    public CidadeEJB getCidadeEJB() {
        return cidadeEJB;
    }

	public TipoHospedeEJB getTipoHospedeEJB() {
		return tipoHospedeEJB;
	}

	public void setTipoHospedeEJB(TipoHospedeEJB tipoHospedeEJB) {
		this.tipoHospedeEJB = tipoHospedeEJB;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
