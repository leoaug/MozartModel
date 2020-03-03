package com.mozart.model.vo;

import java.util.Date;

public class EmpresaRedeVO extends MozartVO {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 390691493915273386L;
	/*campos espelho banco*/
    private Long bcIdEmpresa;
    private Long bcIdRedeHotel;
    private String bcContato;
    private String bcTelefone;
    private String bcTelefone2;
    private String bcFax;
    private String bcEmail;
    private String bcEmail2;
    private String bcTelex;
    private Date bcDataNascimento;
    private String bcObservacao;
    private Long bcIdGrupoEconomico;
    private String bcInternet;
    private String bcCrs;
    private String bcCredito;
    private Double bcValorCredito;
    private Date bcDataCadastro;
    private Long bcIdHotel;
    private String bcNomeFantasia;
    private String bcParticular;
    private Long bcIdCorporate;
    private String bcContato2;
    private Date bcDataNascimento2;
    private Long bcIdPromotor;
    private Long bcIdCidade;
    private String bcCidade;
    
    
	public void setaDados(Object[] pLinha) {
        
        setLinha(pLinha);                
               
        bcIdEmpresa = getLong();
        bcIdRedeHotel = getLong();
        bcContato = getString();
        bcTelefone = getString();
        bcTelefone2 = getString();
        bcFax = getString();
        bcEmail = getString();
        bcEmail2 = getString();
        bcTelex = getString();
        bcDataNascimento = getDate();
        bcObservacao = getString();
        bcIdGrupoEconomico = getLong();
        bcInternet = getString();
        bcCrs = getString();
        bcCredito = getString();
        bcValorCredito = getDouble();
        bcDataCadastro = getDate();
        bcIdHotel = getLong();
        bcNomeFantasia = getString();
        bcParticular = getString();
        bcIdCorporate = getLong();
        bcContato2 = getString();
        bcDataNascimento2 = getDate();
        bcIdPromotor = getLong();
    }
        
	 public EmpresaRedeVO() {
	    }

	 
	 public EmpresaRedeVO(Object[] obj) {
		 
		 if (obj != null){
			 	setaDados( obj );
			 	bcIdCidade = getLong();
			 	bcCidade = getString();
		 }
		 
	 }

    public void setBcIdEmpresa(Long bcIdEmpresa) {
        this.bcIdEmpresa = bcIdEmpresa;
    }

    public Long getBcIdEmpresa() {
        return bcIdEmpresa;
    }

    public void setBcIdRedeHotel(Long bcIdRedeHotel) {
        this.bcIdRedeHotel = bcIdRedeHotel;
    }

    public Long getBcIdRedeHotel() {
        return bcIdRedeHotel;
    }

    public void setBcContato(String bcContato) {
        this.bcContato = bcContato;
    }

    public String getBcContato() {
        return bcContato;
    }

    public void setBcTelefone(String bcTelefone) {
        this.bcTelefone = bcTelefone;
    }

    public String getBcTelefone() {
        return bcTelefone;
    }

    public void setBcTelefone2(String bcTelefone2) {
        this.bcTelefone2 = bcTelefone2;
    }

    public String getBcTelefone2() {
        return bcTelefone2;
    }

    public void setBcFax(String bcFax) {
        this.bcFax = bcFax;
    }

    public String getBcFax() {
        return bcFax;
    }

    public void setBcEmail(String bcEmail) {
        this.bcEmail = bcEmail;
    }

    public String getBcEmail() {
        return bcEmail;
    }

    public void setBcEmail2(String bcEmail2) {
        this.bcEmail2 = bcEmail2;
    }

    public String getBcEmail2() {
        return bcEmail2;
    }

    public void setBcTelex(String bcTelex) {
        this.bcTelex = bcTelex;
    }

    public String getBcTelex() {
        return bcTelex;
    }

    public void setBcDataNascimento(Date bcDataNascimento) {
        this.bcDataNascimento = bcDataNascimento;
    }

    public Date getBcDataNascimento() {
        return bcDataNascimento;
    }

    public void setBcObservacao(String bcObservacao) {
        this.bcObservacao = bcObservacao;
    }

    public String getBcObservacao() {
        return bcObservacao;
    }

    public void setBcIdGrupoEconomico(Long bcIdGrupoEconomico) {
        this.bcIdGrupoEconomico = bcIdGrupoEconomico;
    }

    public Long getBcIdGrupoEconomico() {
        return bcIdGrupoEconomico;
    }

    public void setBcInternet(String bcInternet) {
        this.bcInternet = bcInternet;
    }

    public String getBcInternet() {
        return bcInternet;
    }

    public void setBcCrs(String bcCrs) {
        this.bcCrs = bcCrs;
    }

    public String getBcCrs() {
        return bcCrs;
    }

    public void setBcCredito(String bcCredito) {
        this.bcCredito = bcCredito;
    }

    public String getBcCredito() {
        return bcCredito;
    }

    public void setBcValorCredito(Double bcValorCredito) {
        this.bcValorCredito = bcValorCredito;
    }

    public Double getBcValorCredito() {
        return bcValorCredito;
    }

    public void setBcDataCadastro(Date bcDataCadastro) {
        this.bcDataCadastro = bcDataCadastro;
    }

    public Date getBcDataCadastro() {
        return bcDataCadastro;
    }

    public void setBcIdHotel(Long bcIdHotel) {
        this.bcIdHotel = bcIdHotel;
    }

    public Long getBcIdHotel() {
        return bcIdHotel;
    }

    public void setBcNomeFantasia(String bcNomeFantasia) {
        this.bcNomeFantasia = bcNomeFantasia;
    }

    public String getBcNomeFantasia() {
        return bcNomeFantasia;
    }

    public void setBcParticular(String bcParticular) {
        this.bcParticular = bcParticular;
    }

    public String getBcParticular() {
        return bcParticular;
    }

    public void setBcIdCorporate(Long bcIdCorporate) {
        this.bcIdCorporate = bcIdCorporate;
    }

    public Long getBcIdCorporate() {
        return bcIdCorporate;
    }

    public void setBcContato2(String bcContato2) {
        this.bcContato2 = bcContato2;
    }

    public String getBcContato2() {
        return bcContato2;
    }

    public void setBcDataNascimento2(Date bcDataNascimento2) {
        this.bcDataNascimento2 = bcDataNascimento2;
    }

    public Date getBcDataNascimento2() {
        return bcDataNascimento2;
    }

    public void setBcIdPromotor(Long bcIdPromotor) {
        this.bcIdPromotor = bcIdPromotor;
    }

    public Long getBcIdPromotor() {
        return bcIdPromotor;
    }

	public Long getBcIdCidade() {
		return bcIdCidade;
	}

	public void setBcIdCidade(Long bcIdCidade) {
		this.bcIdCidade = bcIdCidade;
	}

	public String getBcCidade() {
		return bcCidade;
	}

	public void setBcCidade(String bcCidade) {
		this.bcCidade = bcCidade;
	}
}
