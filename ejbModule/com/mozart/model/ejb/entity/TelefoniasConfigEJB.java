package com.mozart.model.ejb.entity;

import javax.persistence.*;

import com.mozart.model.util.MozartUtil;

/**
 * The persistent class for the TELEFONIAS_CONFIG database table.
 * 
 */
@Entity
@Table(name="TELEFONIAS_CONFIG")
public class TelefoniasConfigEJB extends MozartEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TELEFONIAS_CONFIG_IDTELEFONIASCONFIG_GENERATOR", sequenceName="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TELEFONIAS_CONFIG_IDTELEFONIASCONFIG_GENERATOR")
	@Column(name="ID_TELEFONIAS_CONFIG")
	private Long idTelefoniasConfig;

	private Double acobrar;

	private String caminho;

	@Column(name="CAMINHO_INTERNET")
	private String caminhoInternet;

	private String custofim;

	private String custoini;

	private String datafim;

	private String dataini;

	private String horafim;

	private String horaini;

	@Column(name="ID_HOTEL")
	private Long idHotel;

	@Column(name="ID_TELEFONIA")
	private Long idTelefonia;

	@Column(name="INV_DATA")
	private String invData;

	private String ndiscfim;

	private String ndiscini;

	private String ramalfim;

	private String ramalini;

	@Column(name="TARIFA_TAXA")
	private String tarifaTaxa;

	private Double taxa;

	private String taxafim;

	private String taxaini;

	@Column(name="TEMP_SEC")
	private String tempSec;

	private String tempofim;

	private String tempoini;

	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", updatable=false, insertable=false),
	    @JoinColumn(name = "ID_TIPO_LANCAMENTO_TELEFONIA", referencedColumnName = "ID_TIPO_LANCAMENTO")
	})	
	private TipoLancamentoEJB tipoLancamentoTelefonia;
	@ManyToOne
	@JoinColumns({
	    @JoinColumn(name = "ID_HOTEL", referencedColumnName = "ID_HOTEL", updatable=false, insertable=false),
	    @JoinColumn(name = "ID_TIPO_LANCAMENTO_INTERNET", referencedColumnName = "ID_TIPO_LANCAMENTO")
	})
	private TipoLancamentoEJB tipoLancamentoInternet;
	
    public TelefoniasConfigEJB() {
    	 
    }

    @Deprecated
    public TelefoniasConfigEJB(String teste) {
    	ramalini = "1";
    	ramalfim = "5";
    	dataini  = "8";
    	datafim  = "8";
    	horaini  = "21";
    	horafim  = "8";
    	ndiscini = "37";
    	ndiscfim = "20";
    	tempoini = "108";
    	tempofim = "8";
    	custoini = "118";
    	custofim = "6";
    	taxaini  = "0";
    	taxafim  = "0";
    }
    
    
    public String[] build(String linha){
    	if (MozartUtil.isNull( linha ))
    		return null;
    	
    	String[] result = new String[7];
    	//Ramal
    	if (!MozartUtil.isNull(ramalfim) && !MozartUtil.isNull(ramalini) && !"0".equals(ramalfim) && !"0".equals(ramalini) )
    		result[0] = linha.substring(Integer.parseInt(ramalini)-1, (Integer.parseInt(ramalini)-1 + Integer.parseInt(ramalfim)));
    	//Data
    	if (!MozartUtil.isNull(datafim) && !MozartUtil.isNull(dataini)  && !"0".equals(dataini) && !"0".equals(datafim) )
    		result[1] = linha.substring(Integer.parseInt(dataini)-1, (Integer.parseInt(dataini)-1 + Integer.parseInt(datafim)));
    	//Hora
    	if (!MozartUtil.isNull(horafim) && !MozartUtil.isNull(horaini) && !"0".equals(horaini) && !"0".equals(horafim) )
    		result[2] = linha.substring(Integer.parseInt(horaini)-1, (Integer.parseInt(horaini)-1 + Integer.parseInt(horafim)));
    	//ndisc
    	if (!MozartUtil.isNull(ndiscfim) && !MozartUtil.isNull(ndiscini)&& !"0".equals(ndiscini) && !"0".equals(ndiscfim) )
    		result[3] = linha.substring(Integer.parseInt(ndiscini)-1, (Integer.parseInt(ndiscini)-1 + Integer.parseInt(ndiscfim)));
    	//ndisc
    	if (!MozartUtil.isNull(tempofim) && !MozartUtil.isNull(tempoini)&& !"0".equals(tempoini) && !"0".equals(tempofim))
    		result[4] = linha.substring(Integer.parseInt(tempoini)-1, (Integer.parseInt(tempoini)-1 + Integer.parseInt(tempofim)));
    	//custo
    	if (!MozartUtil.isNull(custofim) && !MozartUtil.isNull(custoini)&& !"0".equals(custoini) && !"0".equals(custofim))
    		result[5] = linha.substring(Integer.parseInt(custoini)-1, (Integer.parseInt(custoini)-1 + Integer.parseInt(custofim)));
    	//custo
    	if (!MozartUtil.isNull(taxafim) && !MozartUtil.isNull(taxaini)&& !"0".equals(taxaini) && !"0".equals(taxafim))
    		result[6] = linha.substring(Integer.parseInt(taxaini)-1, (Integer.parseInt(taxaini)-1 + Integer.parseInt(taxafim)));
    	
    	return result;
    }
    
    
    public static void main(String[] x){
    	
    	String linha = "4804   01/12/08 Seg 10:37:10 Ent    4834374824          <<Criciúma                              SC    0    00:05:06  0,00       152           True   14 ";
    	String[] result  = new TelefoniasConfigEJB("").build(linha);
    	
    	for (String valo: result){
    		System.out.println("Valor:" + valo + ".");
    	}
    	
    	
    }
    

	public Long getIdTelefoniasConfig() {
		return this.idTelefoniasConfig;
	}

	public void setIdTelefoniasConfig(Long idTelefoniasConfig) {
		this.idTelefoniasConfig = idTelefoniasConfig;
	}

	public Double getAcobrar() {
		return this.acobrar;
	}

	public void setAcobrar(Double acobrar) {
		this.acobrar = acobrar;
	}

	public String getCaminho() {
		return this.caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getCaminhoInternet() {
		return this.caminhoInternet;
	}

	public void setCaminhoInternet(String caminhoInternet) {
		this.caminhoInternet = caminhoInternet;
	}

	public String getCustofim() {
		return this.custofim;
	}

	public void setCustofim(String custofim) {
		this.custofim = custofim;
	}

	public String getCustoini() {
		return this.custoini;
	}

	public void setCustoini(String custoini) {
		this.custoini = custoini;
	}

	public String getDatafim() {
		return this.datafim;
	}

	public void setDatafim(String datafim) {
		this.datafim = datafim;
	}

	public String getDataini() {
		return this.dataini;
	}

	public void setDataini(String dataini) {
		this.dataini = dataini;
	}

	public String getHorafim() {
		return this.horafim;
	}

	public void setHorafim(String horafim) {
		this.horafim = horafim;
	}

	public String getHoraini() {
		return this.horaini;
	}

	public void setHoraini(String horaini) {
		this.horaini = horaini;
	}

	public Long getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public Long getIdTelefonia() {
		return this.idTelefonia;
	}

	public void setIdTelefonia(Long idTelefonia) {
		this.idTelefonia = idTelefonia;
	}

	public String getInvData() {
		return this.invData;
	}

	public void setInvData(String invData) {
		this.invData = invData;
	}

	public String getNdiscfim() {
		return this.ndiscfim;
	}

	public void setNdiscfim(String ndiscfim) {
		this.ndiscfim = ndiscfim;
	}

	public String getNdiscini() {
		return this.ndiscini;
	}

	public void setNdiscini(String ndiscini) {
		this.ndiscini = ndiscini;
	}

	public String getRamalfim() {
		return this.ramalfim;
	}

	public void setRamalfim(String ramalfim) {
		this.ramalfim = ramalfim;
	}

	public String getRamalini() {
		return this.ramalini;
	}

	public void setRamalini(String ramalini) {
		this.ramalini = ramalini;
	}

	public String getTarifaTaxa() {
		return this.tarifaTaxa;
	}

	public void setTarifaTaxa(String tarifaTaxa) {
		this.tarifaTaxa = tarifaTaxa;
	}

	public Double getTaxa() {
		return this.taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public String getTaxafim() {
		return this.taxafim;
	}

	public void setTaxafim(String taxafim) {
		this.taxafim = taxafim;
	}

	public String getTaxaini() {
		return this.taxaini;
	}

	public void setTaxaini(String taxaini) {
		this.taxaini = taxaini;
	}

	public String getTempSec() {
		return this.tempSec;
	}

	public void setTempSec(String tempSec) {
		this.tempSec = tempSec;
	}

	public String getTempofim() {
		return this.tempofim;
	}

	public void setTempofim(String tempofim) {
		this.tempofim = tempofim;
	}

	public String getTempoini() {
		return this.tempoini;
	}

	public void setTempoini(String tempoini) {
		this.tempoini = tempoini;
	}

	public TipoLancamentoEJB getTipoLancamentoTelefonia() {
		return tipoLancamentoTelefonia;
	}

	public void setTipoLancamentoTelefonia(TipoLancamentoEJB tipoLancamentoTelefonia) {
		this.tipoLancamentoTelefonia = tipoLancamentoTelefonia;
	}

	public TipoLancamentoEJB getTipoLancamentoInternet() {
		return tipoLancamentoInternet;
	}

	public void setTipoLancamentoInternet(TipoLancamentoEJB tipoLancamentoInternet) {
		this.tipoLancamentoInternet = tipoLancamentoInternet;
	}

}