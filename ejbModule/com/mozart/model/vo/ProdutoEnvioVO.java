package com.mozart.model.vo;

import java.text.ParseException;

public class ProdutoEnvioVO extends MozartVO {

	private static final long serialVersionUID = 1L;

	private Long idHotel;
	private Long filtroIdNotaFiscal;
	
	private String idNota;
	private String token;
	private String cprod;
	private String cean;
	private String xprod;
	private String ncm;
	private String cest;
	private String cfop;
	private String ucom;
	private String qcom;
	private double vuncom;
	private double vprod;
	private String ceantrib;
	private String utrib;
	private double qtrib;
	private double vuntrib;
	private double vdesc;
	private double voutros;
	private long indtotal;
	private double vtottrib;
	private String icmsOrigem;
	private String icmsCst;
	private String icmsModbc;
	private double icmsRedbc;
	private double icmsVbc;
	private double icmsPicms;
	private double icmsVicms;
	private String ipiCenq;
	private String ipintCst;
	private double pisaliqVbc;
	private double pisaliqPpis;
	private String pisaliqCst;
	private double pisaliqVpis;
	private String cofinsaliqCst;
	private double cofinsaliqVbc;
	private double cofinsaliqPcofins;
	private double cofinsaliqVcofins;
	private double icmsPredbc;
	private String tipoTributacao;
	private String csosn;
	private double vbcstret;
	private double vicmsstret;
	private String pisntCst;
	private String cofinsntCst;
	private String infadprod;
	private String ipiCst;
	private double ipiVbc;
	private double ipiPipi;
	private double ipiVipi;
	private double vfcpufdest;
	private double vfcp;
	private double pmvast;
	private double vbcst;
	private double picmsst;
	private double vicmsst;
	private double pvcp;
	
	public ProdutoEnvioVO() {

	}

	public ProdutoEnvioVO(Object[] filtro) throws ParseException {
		if (filtro != null) {
			setLinha(filtro);

			cprod = getString();
			cean = getString();
			xprod = getString();
			ncm = getString();
			cest = getString();
			cfop = getString();
			ucom = getString();
			qcom = getString();
			vuncom = getDouble();
			vprod = getDouble();
			ceantrib = getString();
			utrib = getString();
			qtrib = getDouble();
			vuntrib = getDouble();
			vdesc = getDouble();
			voutros = getDouble();
			indtotal = getLong();
			vtottrib = getDouble();
			icmsOrigem = getString();
			icmsCst = getString();
			icmsModbc = getString();
			icmsRedbc = getDouble();
			icmsVbc = getDouble();
			icmsPicms = getDouble();
			icmsVicms = getDouble();
			ipiCenq = getString();
			ipintCst = getString();
			pisaliqCst = getString();
			pisaliqVbc = getDouble();
			pisaliqPpis = getDouble();
			pisaliqVpis = getDouble();
			cofinsaliqCst = getString();
			cofinsaliqVbc = getDouble();
			cofinsaliqPcofins = getDouble();
			cofinsaliqVcofins = getDouble();
			icmsPredbc = getDouble();
			tipoTributacao = getString();
			csosn = getString();
			vbcstret = getDouble();
			vicmsstret = getDouble();
			pisntCst = getString();
			cofinsntCst = getString();
			infadprod = getString();
			ipiCst = getString();
			ipiVbc = getDouble();
			ipiPipi = getDouble();
			ipiVipi = getDouble();
			vfcpufdest = getDouble();
			vfcp = getDouble();
			pmvast = getDouble();
			vbcst = getDouble();
			picmsst = getDouble();
			vicmsst = getDouble();
			pvcp = getDouble();
			
		}
	}

	public Long getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(Long idHotel) {
		this.idHotel = idHotel;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getFiltroIdNotaFiscal() {
		return filtroIdNotaFiscal;
	}

	public void setFiltroIdNotaFiscal(Long filtroIdNotaFiscal) {
		this.filtroIdNotaFiscal = filtroIdNotaFiscal;
	}

	public String getIdNota() {
		return idNota;
	}

	public void setIdNota(String idNota) {
		this.idNota = idNota;
	}

	public String getCprod() {
		return cprod;
	}

	public void setCprod(String cprod) {
		this.cprod = cprod;
	}

	public String getCean() {
		return cean;
	}

	public void setCean(String cean) {
		this.cean = cean;
	}

	public String getXprod() {
		return xprod;
	}

	public void setXprod(String xprod) {
		this.xprod = xprod;
	}

	public String getNcm() {
		return ncm;
	}

	public void setNcm(String ncm) {
		this.ncm = ncm;
	}

	public String getCest() {
		return cest;
	}

	public void setCest(String cest) {
		this.cest = cest;
	}

	public String getCfop() {
		return cfop;
	}

	public void setCfop(String cfop) {
		this.cfop = cfop;
	}

	public String getUcom() {
		return ucom;
	}

	public void setUcom(String ucom) {
		this.ucom = ucom;
	}

	public String getQcom() {
		return qcom;
	}

	public void setQcom(String qcom) {
		this.qcom = qcom;
	}

	public double getVuncom() {
		return vuncom;
	}

	public void setVuncom(double vuncom) {
		this.vuncom = vuncom;
	}

	public double getVprod() {
		return vprod;
	}

	public void setVprod(double vprod) {
		this.vprod = vprod;
	}

	public String getCeantrib() {
		return ceantrib;
	}

	public void setCeantrib(String ceantrib) {
		this.ceantrib = ceantrib;
	}

	public String getUtrib() {
		return utrib;
	}

	public void setUtrib(String utrib) {
		this.utrib = utrib;
	}

	public double getQtrib() {
		return qtrib;
	}

	public void setQtrib(double qtrib) {
		this.qtrib = qtrib;
	}

	public double getVuntrib() {
		return vuntrib;
	}

	public void setVuntrib(double vuntrib) {
		this.vuntrib = vuntrib;
	}

	public double getVdesc() {
		return vdesc;
	}

	public void setVdesc(double vdesc) {
		this.vdesc = vdesc;
	}

	public double getVoutros() {
		return voutros;
	}

	public void setVoutros(double voutros) {
		this.voutros = voutros;
	}

	public long getIndtotal() {
		return indtotal;
	}

	public void setIndtotal(long indtotal) {
		this.indtotal = indtotal;
	}

	public double getVtottrib() {
		return vtottrib;
	}

	public void setVtottrib(double vtottrib) {
		this.vtottrib = vtottrib;
	}

	public String getIcmsOrigem() {
		return icmsOrigem;
	}

	public void setIcmsOrigem(String icmsOrigem) {
		this.icmsOrigem = icmsOrigem;
	}

	public String getIcmsCst() {
		return icmsCst;
	}

	public void setIcmsCst(String icmsCst) {
		this.icmsCst = icmsCst;
	}

	public String getIcmsModbc() {
		return icmsModbc;
	}

	public void setIcmsModbc(String icmsModbc) {
		this.icmsModbc = icmsModbc;
	}

	public double getIcmsRedbc() {
		return icmsRedbc;
	}

	public void setIcmsRedbc(double icmsRedbc) {
		this.icmsRedbc = icmsRedbc;
	}

	public double getIcmsVbc() {
		return icmsVbc;
	}

	public void setIcmsVbc(double icmsVbc) {
		this.icmsVbc = icmsVbc;
	}

	public double getIcmsPicms() {
		return icmsPicms;
	}

	public void setIcmsPicms(double icmsPicms) {
		this.icmsPicms = icmsPicms;
	}

	public double getIcmsVicms() {
		return icmsVicms;
	}

	public void setIcmsVicms(double icmsVicms) {
		this.icmsVicms = icmsVicms;
	}

	public String getIpiCenq() {
		return ipiCenq;
	}

	public void setIpiCenq(String ipiCenq) {
		this.ipiCenq = ipiCenq;
	}

	public String getIpintCst() {
		return ipintCst;
	}

	public void setIpintCst(String ipintCst) {
		this.ipintCst = ipintCst;
	}

	public String getPisaliqCst() {
		return pisaliqCst;
	}

	public void setPisaliqCst(String pisaliqCst) {
		this.pisaliqCst = pisaliqCst;
	}

	public double getPisaliqVbc() {
		return pisaliqVbc;
	}

	public void setPisaliqVbc(double pisaliqVbc) {
		this.pisaliqVbc = pisaliqVbc;
	}

	public double getPisaliqPpis() {
		return pisaliqPpis;
	}

	public void setPisaliqPpis(double pisaliqPpis) {
		this.pisaliqPpis = pisaliqPpis;
	}

	public double getPisaliqVpis() {
		return pisaliqVpis;
	}

	public void setPisaliqVpis(double pisaliqVpis) {
		this.pisaliqVpis = pisaliqVpis;
	}

	public String getCofinsaliqCst() {
		return cofinsaliqCst;
	}

	public void setCofinsaliqCst(String cofinsaliqCst) {
		this.cofinsaliqCst = cofinsaliqCst;
	}

	public double getCofinsaliqVbc() {
		return cofinsaliqVbc;
	}

	public void setCofinsaliqVbc(double cofinsaliqVbc) {
		this.cofinsaliqVbc = cofinsaliqVbc;
	}

	public double getCofinsaliqPcofins() {
		return cofinsaliqPcofins;
	}

	public void setCofinsaliqPcofins(double cofinsaliqPcofins) {
		this.cofinsaliqPcofins = cofinsaliqPcofins;
	}

	public double getCofinsaliqVcofins() {
		return cofinsaliqVcofins;
	}

	public void setCofinsaliqVcofins(double cofinsaliqVcofins) {
		this.cofinsaliqVcofins = cofinsaliqVcofins;
	}

	public double getIcmsPredbc() {
		return icmsPredbc;
	}

	public void setIcmsPredbc(double icmsPredbc) {
		this.icmsPredbc = icmsPredbc;
	}

	public String getTipoTributacao() {
		return tipoTributacao;
	}

	public void setTipoTributacao(String tipoTributacao) {
		this.tipoTributacao = tipoTributacao;
	}

	public String getCsosn() {
		return csosn;
	}

	public void setCsosn(String csosn) {
		this.csosn = csosn;
	}

	public double getVbcstret() {
		return vbcstret;
	}

	public void setVbcstret(double vbcstret) {
		this.vbcstret = vbcstret;
	}

	public double getVicmsstret() {
		return vicmsstret;
	}

	public void setVicmsstret(double vicmsstret) {
		this.vicmsstret = vicmsstret;
	}

	public String getPisntCst() {
		return pisntCst;
	}

	public void setPisntCst(String pisntCst) {
		this.pisntCst = pisntCst;
	}

	public String getCofinsntCst() {
		return cofinsntCst;
	}

	public void setCofinsntCst(String cofinsntCst) {
		this.cofinsntCst = cofinsntCst;
	}

	public String getInfadprod() {
		return infadprod;
	}

	public void setInfadprod(String infadprod) {
		this.infadprod = infadprod;
	}

	public String getIpiCst() {
		return ipiCst;
	}

	public void setIpiCst(String ipiCst) {
		this.ipiCst = ipiCst;
	}

	public double getIpiVbc() {
		return ipiVbc;
	}

	public void setIpiVbc(double ipiVbc) {
		this.ipiVbc = ipiVbc;
	}

	public double getIpiPipi() {
		return ipiPipi;
	}

	public void setIpiPipi(double ipiPipi) {
		this.ipiPipi = ipiPipi;
	}

	public double getIpiVipi() {
		return ipiVipi;
	}

	public void setIpiVipi(double ipiVipi) {
		this.ipiVipi = ipiVipi;
	}

	public double getVfcpufdest() {
		return vfcpufdest;
	}

	public void setVfcpufdest(double vfcpufdest) {
		this.vfcpufdest = vfcpufdest;
	}

	public double getVfcp() {
		return vfcp;
	}

	public void setVfcp(double vfcp) {
		this.vfcp = vfcp;
	}

	public double getPvcp() {
		return pvcp;
	}

	public void setPvcp(double pvcp) {
		this.pvcp = pvcp;
	}

	public double getPmvast() {
		return pmvast;
	}

	public void setPmvast(double pmvast) {
		this.pmvast = pmvast;
	}

	public double getVbcst() {
		return vbcst;
	}

	public void setVbcst(double vbcst) {
		this.vbcst = vbcst;
	}

	public double getPicmsst() {
		return picmsst;
	}

	public void setPicmsst(double picmsst) {
		this.picmsst = picmsst;
	}

	public double getVicmsst() {
		return vicmsst;
	}

	public void setVicmsst(double vicmsst) {
		this.vicmsst = vicmsst;
	}
}
